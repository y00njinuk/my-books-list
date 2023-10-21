package chapter15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderEx {
    public static void main(String[] args) {
        String line = "";

        try(InputStreamReader isr = new InputStreamReader(System.in, "MS949");
            BufferedReader br = new BufferedReader(isr);) {

            System.out.println("OS Encoding Type: " + isr.getEncoding());

            do {
                System.out.print("Input : (exit? q) ");
                line = br.readLine();
                System.out.println("Result : " + line);
            } while(!line.equalsIgnoreCase("q"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
