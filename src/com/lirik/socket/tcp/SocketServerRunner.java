package com.lirik.socket.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * С помощью класса ServerSocket мы создаем сервер, куда будут обращаться клиенты!!! В конструктор надо передать только порт!!! Порт
 * можно указать в диапазоне от 0 до 65000!!!
 */

public class SocketServerRunner {

    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(7777);
             Socket socket = serverSocket.accept();
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream()); // ответ для клиента, формируемый сервером
             DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {  // запрос, пришедший от клиента
            System.out.println("Client request: "+ inputStream.readUTF());
            outputStream.writeUTF("Hello from server!");
        }
    }
}
