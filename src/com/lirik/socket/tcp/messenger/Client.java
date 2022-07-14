package com.lirik.socket.tcp.messenger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * После запуска сервера можно запускать клиент и печатать сообщения!!!
 * Когда отправим на сервер слово stop, то сервер остановит свое выполнение и программа остановится, а у клиента вывалится EXCEPTION!!!
 */

public class Client {

    public static void main(String[] args) throws IOException {

        InetAddress inetAddress = Inet4Address.getByName("localhost");


        try (Socket socket = new Socket(inetAddress, 7777);
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());   //  необходим для отправки запроса на сервер
             DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {    // необходим для считывания ответа от сервера
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String request = scanner.nextLine();
                outputStream.writeUTF(request); // отправили запрос на сервер
                System.out.println("Response from server: " + inputStream.readUTF());
            }
        }
    }
}
