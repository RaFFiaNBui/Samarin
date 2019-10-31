package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.MockMessageService;
import sample.IMessageService;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    public @FXML TextArea chatTextArea;
    public @FXML TextField messageText;
    public @FXML Button sendMessageButton;

    private IMessageService messageService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.messageService = new MockMessageService(chatTextArea);
    }

    @FXML
    public void sendText(ActionEvent actionEvent) {

        sendMessage();
    }

    @FXML
    public void sendMessage(ActionEvent actionEvent) {

        sendMessage();
    }

    private void sendMessage() {
        String message = messageText.getText();
        messageService.sendMessage(message);
        messageText.clear();
    }
}