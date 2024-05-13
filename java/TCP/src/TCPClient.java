import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.223.45", 9876); // Conéctate al servidor TCP en localhost y el puerto 6789
            System.out.println("Cliente TCP conectado al servidor.");

            // Lee el mensaje recibido del servidor TCP
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = in.readLine();
            System.out.println("Mensaje recibido del servidor TCP: " + message);

            // Cierra el socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
