import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();

            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 1111;

            String message = "¡Hola desde el cliente UDP!";
            byte[] sendData = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            socket.send(sendPacket);
            System.out.println("Mensaje enviado al servidor TCP desde el cliente UDP.");

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
