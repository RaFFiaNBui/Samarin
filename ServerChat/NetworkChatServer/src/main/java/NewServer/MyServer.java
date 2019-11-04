import Auth.AuthService;
import Auth.BaseAuthService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    private static final int PORT = 8189;
    private final AuthService authService = new BaseAuthService();;


    public MyServer() {
        System.out.println("Server is running");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            authService.start();
            while (true) {
                System.out.println("Awaiting client connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Client has connected");

            }
        } catch (IOException e) {
            System.err.println("Ошибка в работе сервера. Причина: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
