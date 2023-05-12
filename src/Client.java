import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket;
        {
            try {
                socket = new Socket("127.0.0.1",12345);

                //asking user input with buffer
                BufferedReader userInputBuffer= new BufferedReader(new InputStreamReader(System.in));
                //taking data from socket buffer
                BufferedReader socketBuffer=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //send the msg
                OutputStream outputStream= socket.getOutputStream();
                PrintWriter printWriter= new PrintWriter(outputStream);
                String sendingMsg, receivingMsg;
                while(true){
                    receivingMsg= socketBuffer.readLine();
                    System.out.println("msg from server: "+receivingMsg);

                    sendingMsg = userInputBuffer.readLine();
                    printWriter.println(sendingMsg);
                    printWriter.flush();

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
