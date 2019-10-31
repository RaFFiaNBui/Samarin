package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class Controller {

    @FXML public TextField inPutText;
    @FXML public Button myButton;
    @FXML public TextArea textArea;

    @FXML
    public void enterInputText(ActionEvent e) {
//        String text = textArea.getText();
//        textArea.setText(text + "\n" + inPutText.getText());
        textArea.appendText("\n" + inPutText.getText());
        inPutText.setText("");
    }
}
