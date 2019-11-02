package ru.controller.message;

import javafx.scene.control.TextArea;
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
    private boolean needStopServerOnClosed;

    public ServerMessageService(TextArea chatTextArea, boolean needStopServerOnClosed) {
        this.chatTextArea = chatTextArea;
        this.needStopServerOnClosed = needStopServerOnClosed;
        initialaze();
    }

    private void initialaze() {
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

    public void setNetwork (Network network) {
        this.network = network;
    }

    @Override
    public void sendMessage(String message) {
        network.send(message);
    }

    @Override
    public void processRetrievedMessage(String message) {
        chatTextArea.appendText(message + System.lineSeparator());
    }
}
