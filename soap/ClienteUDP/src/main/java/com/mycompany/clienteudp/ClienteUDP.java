/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clienteudp;

import java.net.*;

public class ClienteUDP {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            byte[] sendData = "Hola servidor, te mando msj!".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
            socket.send(sendPacket);
            System.out.println("MENSAJE UDP MANDADO AL SERVER.");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}