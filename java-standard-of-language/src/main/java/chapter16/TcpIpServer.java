package chapter16;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            // create ServerSocket and port binding.
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime()+"서버가 준비되었습니다.");
        } catch(IOException e) { e.printStackTrace(); }

        while(true) {
            try {
                // wait.
                System.out.println(getTime()+"연결 요청을 기다립니다.");
                // create new socket.
                Socket socket = serverSocket.accept();
                System.out.println(getTime()+socket.getInetAddress()+"로부터 연결요청이 들어왔습니다.");
                // create stream.
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);
                // send.
                dos.writeUTF("[Notice] Test Message1 from Server.");
                System.out.println(getTime()+"데이터를 전송하였습니다.");
                // close.
                dos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm::ss]");
        return f.format(new Date());
    }
}
