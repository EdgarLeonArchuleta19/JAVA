//......Cliente:
import java.net.*;
import java.io.*;


public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
        escritor.println("Mensaje enviado por el cliente. Edgar Leon Archuleta");

        BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String respuesta = lector.readLine();
        System.out.println("Respuesta recibida: " + respuesta);

        socket.close();
    }
}
