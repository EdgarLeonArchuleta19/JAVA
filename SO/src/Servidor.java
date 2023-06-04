// IPC básico entre dos procesos dentro de la misma computadora.
import java.net.*;
import java.io.*;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidorSocket = new ServerSocket(5000);
        System.out.println("Servidor iniciado. Esperando conexion...");
        Socket socket = servidorSocket.accept();
        System.out.println("Conexion establecida.");

        BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String mensaje = lector.readLine();
        System.out.println("Mensaje recibido: " + mensaje);

        PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
        escritor.println("Mensaje recibido por el servidor. Edgar Leon Archuleta");

        socket.close();
        servidorSocket.close();
    }
}
