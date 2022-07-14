package com.lirik.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;

/**
 * При создании объекта класса Socket в конструктор передаем адрес ресурса или его IP-address, а также порт. Для протокола HTTP это порт
 * 80, а для протокола HTTPS это порт 443!!!
 */

public class SocketRunner {

    public static void main(String[] args) throws IOException {

        /**
         * Первый вариант, когда адрес передается простой строкой
         */

        try (Socket socket = new Socket("google.com", 80);
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());   //  необходим для отправки запроса на сервер
             DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {    // необходим для считывания ответа от сервера

            outputStream.writeUTF("hello world"); // отправили запрос на сервер
            byte[] response = inputStream.readAllBytes(); // получили ответ от сервера
            System.out.println(response.length);
        }

        /**
         * Объект класса InetAddress можно передавать в конструктор класса Socket вместо имени хоста. Так будет наиболее верно
         */

        InetAddress inetAddress = Inet4Address.getByName("google.com");

        /**
         * Второй вариант, когда адрес передается с помощью объекта класса InetAddress. Такой способ будет более верным и правильным!!!
         */

        try (Socket socket = new Socket(inetAddress, 80);
             DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());   //  необходим для отправки запроса на сервер
             DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {    // необходим для считывания ответа от сервера

            outputStream.writeUTF("hello world"); // отправили запрос на сервер
            byte[] response = inputStream.readAllBytes(); // получили ответ от сервера
            System.out.println(response.length);
        }
    }
}
