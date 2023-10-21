package chapter15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("java-standrad-of-language/src/chapter15/input.txt");
            FileOutputStream fos = new FileOutputStream("java-standrad-of-language/src/chapter15/output.txt");

            int data = 0;
            while((data=fis.read()) != -1)
                fos.write(data);

            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
