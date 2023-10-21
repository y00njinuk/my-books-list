package chapter15;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamEx1 {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("java-standrad-of-language/src/chapter15/123.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
            for(int i ='1'; i<='9'; i++) {
                bos.write(i);
            } // [49, 50, 51, 52, 53]

            fos.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
