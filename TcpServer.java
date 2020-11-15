import java.io.*;
import  java.net.*;

public class TcpServer {
    public static void main(String[] argv) throws Exception {
        try (ServerSocket server = new ServerSocket(8001);
             FileOutputStream fos = new FileOutputStream("server_recv.txt");
             FileInputStream fis = new FileInputStream("server_send.txt")) {
            System.out.println("waiting for connection from client");
            Socket socket = server.accept();
            System.out.println("client connected");

            int ch;
            InputStream input = socket.getInputStream();

            while ((ch = input.read()) != 0) {
                fos.write(ch);
            }

            OutputStream output = socket.getOutputStream();

            while ((ch = fis.read()) != -1) {
                output.write(ch);
            }
            socket.close();
            System.out.println("connection closed");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}