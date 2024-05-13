import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
            // Conexión al servidor UDP
            DatagramSocket udpSocket = new DatagramSocket();
            InetAddress udpServerAddress = InetAddress.getByName("192.168.224.213");
            int udpServerPort = 0;

            // Envía un mensaje al servidor UDP
            String message = "Inicio de sesión";
            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, udpServerAddress, udpServerPort);
            udpSocket.send(sendPacket);
            System.out.println("Mensaje enviado al servidor UDP desde el cliente TCP.");

            // Configura el servidor TCP
            ServerSocket serverSocket = new ServerSocket(6789);
            System.out.println("Servidor TCP corriendo...");
            
            while(true){
                 // Acepta la conexión del cliente TCP
                Socket clientSocket = serverSocket.accept();//esperando
                System.out.println("Cliente TCP conectado desde: " + clientSocket.getInetAddress());
                
                // Envía el mensaje al cliente TCP
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Te has logueado");

                // Cierra los sockets
                clientSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
