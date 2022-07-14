package com.lirik.socket.tcp.messenger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Сначала стартуем сервер!!1
 */

public class Server {

    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(7777);
             Socket socket = serverSocket.accept();
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream()); // ответ для клиента, формируемый сервером
             DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {  // запрос, пришедший от клиента
            Scanner scanner = new Scanner(System.in);
            String request = inputStream.readUTF();
            while (!"stop".equals(request)) {
                System.out.println("Request from client: " + request);
                String response = scanner.nextLine();
                outputStream.writeUTF(response);
                request = inputStream.readUTF();
            }
        }
    }

}
