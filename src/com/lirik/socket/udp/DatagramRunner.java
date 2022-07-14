package com.lirik.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramRunner {

    public static void main(String[] args) throws IOException {

        InetAddress inetAddress = InetAddress.getByName("localhost");

        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            byte[] buffer = "Hello from UDP client".getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, inetAddress, 7777);
            datagramSocket.send(packet);
        }
    }
}
