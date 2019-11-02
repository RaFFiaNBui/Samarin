package ru.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import ru.controller.message.ServerMessageService;
import ru.controller.message.IMessageService;

public class Controller implements Initializable {

    public @FXML TextArea chatTextArea;
    public @FXML TextField messageText;
    public @FXML Button sendMessageButton;

    private IMessageService messageService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //this.messageService = new MockMessageService(chatTextArea);
        try {
            this.messageService = new ServerMessageService(chatTextArea, true);
        } catch (Exception e) {
            showError(e);
        }
    }

    private void showError(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка соединения с сервером!");
        alert.setHeaderText(e.getMessage());
        alert.show();
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
