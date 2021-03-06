package Vinnik.g144;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/** Handles communication with user (button presses). */
public class Controllers {

    private Button[] buttons;
    private int countOfPressedButtons = 0;
    private int countOfTurnsFirstPlayer = 0;

    @FXML
    private void initialize() {
        buttons = new Button[]{button1, button2, button3, button4, button5, button6, button7, button8, button9};
        textField.textProperty().setValue("");
        textField.setEditable(false);
    }

    @FXML
    private void buttonPressed(ActionEvent event) {
        for (int i = 0; i < 9; i++) {
            if (event.getSource().equals(buttons[i])) {
                if (countOfPressedButtons % 2 == 0) {
                    buttons[i].setText("X");
                    countOfTurnsFirstPlayer++;
                } else {
                    buttons[i].setText("O");
                }
                countOfPressedButtons++;
                buttons[i].setDisable(true);
            }
        }
        gameEnd();
    }

    private void gameEnd() {
        CheckWin checkWin = new CheckWin();
        String[][] values = toArrayOfValues(buttons);
        if (checkWin.isWin(values)) {
            if (countOfPressedButtons % 2 == 0) {
                textField.textProperty().setValue("O win:)");
            } else {
                textField.textProperty().setValue("X win:)");
            }
            for (Button i : buttons) {
                i.setDisable(true);
            }
        } else if (countOfTurnsFirstPlayer == 5) {
            textField.textProperty().setValue("draw:)");
            for (Button i : buttons) {
                i.setDisable(true);
            }
        }
    }

    private String[][] toArrayOfValues(Button[] buttons) {
        int sizeOfValues = (int) Math.sqrt(buttons.length);
        String[][] values = new String[sizeOfValues][sizeOfValues];
        int count = 0;
        for (int i = 0; i < sizeOfValues; i++) {
            for (int j = 0; j < sizeOfValues; j++) {
                values[i][j] = buttons[count].getText();
                count++;
            }
        }
        return values;
    }

    @FXML
    private TextField textField;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;
}
