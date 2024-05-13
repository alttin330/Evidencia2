import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];

            System.out.println("Servidor UDP corriendo...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                System.out.println("Mensaje recibido del cliente TCP: " + message);

                // Si el mensaje es "Inicio de sesión", responde al cliente UDP
                if (message.equals("Inicio de sesión")) {
                    sendUDPResponse(clientAddress, clientPort);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para enviar una respuesta UDP al cliente
    private static void sendUDPResponse(InetAddress clientAddress, int clientPort) {
        try {
            DatagramSocket socket = new DatagramSocket();
            String responseMessage = "Inicio de sesión activado";
            byte[] sendData = responseMessage.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            socket.send(sendPacket);
            System.out.println("Respuesta enviada al cliente TCP: " + responseMessage);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
