package ru.controller.message;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import ru.controller.Controller;
import ru.controller.Network;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServerMessageService implements IMessageService{

    private static final String HOST_ADDRESS_PROP = "server.address";
    private static final String HOST_PORT_PROP = "server.port";
    private static final String STOP_SERVER_COMMAND = "/end";

    private String hostAddress;
    private int hostPort;

    private final TextArea chatTextArea;
    private Network network;
    private Controller controller;
    private boolean needStopServerOnClosed;

    public ServerMessageService(Controller controller, boolean needStopServerOnClosed) {
        this.chatTextArea = controller.chatTextArea;
        this.controller = controller;
        this.needStopServerOnClosed = needStopServerOnClosed;
        initialize();
    }

    private void initialize() {
        readProperties();
        startConnectionToServer();
    }

    private void startConnectionToServer() {
        try {
            this.network = new Network(hostAddress, hostPort, this);
        } catch (IOException e) {
            throw new ServerConnectionException("Ошибка соединения с сервером.", e);
        }
    }

    private void readProperties() {
        Properties serverProperties = new Properties();
        try (InputStream inputStream = getClass().getResourceAsStream("/app.properties")) {
            serverProperties.load(inputStream);
            hostAddress = serverProperties.getProperty(HOST_ADDRESS_PROP);
            hostPort = Integer.parseInt(serverProperties.getProperty(HOST_PORT_PROP));
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла app.properties", e);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ошибка номера порта", e);
        }
    }

    @Override
    public void sendMessage(String message) {
        network.send(message);
    }

    @Override
    public void processRetrievedMessage(String message) {
        if (message.startsWith("/authok")) {
            controller.authPanel.setVisible(false);
            controller.chatPanel.setVisible(true);
        } else if (controller.authPanel.isVisible()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Authentication is failed");
            alert.setContentText(message);
            alert.showAndWait();
        } else {
            chatTextArea.appendText("Сервер: " + message + System.lineSeparator());
        }
    }

    @Override
    public void close() throws IOException {
        if(needStopServerOnClosed) {
            sendMessage(STOP_SERVER_COMMAND);
        }
        network.close();
    }
}
