import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        try {
            ServerSocket serverSocket= new ServerSocket(12345);
            Socket socket=serverSocket.accept();
            System.out.println("Client is added");

            //asking input from user
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            //taking input from socket
            BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //to send the message
            OutputStream outputStream= socket.getOutputStream();
            PrintWriter printWriter= new PrintWriter(outputStream);
            String sendMsg, receiveMsg;
            while(true){
                sendMsg = userInput.readLine();
                printWriter.println(sendMsg);
                printWriter.flush();

                receiveMsg= socketInput.readLine();
                System.out.println("msg from client: "+receiveMsg);
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}