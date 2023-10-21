package chapter15;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {
    public static void main(String[] args) {
        String fileName = "java-standrad-of-language/src/chapter15/test.txt";
        int data = 0;

        try(
            FileInputStream fis = new FileInputStream(fileName);
            FileReader fr = new FileReader(fileName);
        ) {
            while((data=fis.read()) != -1) { System.out.print((char)data); }
            System.out.println();

            while((data=fr.read()) != -1) { System.out.print((char)data); }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
