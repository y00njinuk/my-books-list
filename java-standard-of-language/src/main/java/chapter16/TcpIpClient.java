package chapter16;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class TcpIpClient {
    public static void main(String[] args) {
        try {
            String serverIp = "127.0.0.1";
            System.out.println("서버에 연결중입니다. 서버 IP: " + serverIp);
            // create socket.
            Socket socket = new Socket(serverIp, 7777);
            // create stream.
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            // read.
            System.out.println("서버로부터 받은 메세지: " +  dis.readUTF());
            System.out.println("연결을 종료합니다.");
            // close.
            dis.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
