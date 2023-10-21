package chapter9;

import java.io.Console;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;

public class StringEx5 {
    public static void main(String[] args) throws Exception {
        String str = "가";

        StringBuffer sb = new StringBuffer("abc");
        sb.append("123");

        Console console = System.console();
        String input = console.readLine();

        Math.round(123);

        byte[] bArr = str.getBytes(StandardCharsets.UTF_8);
        byte[] bArr2 = str.getBytes(StandardCharsets.ISO_8859_1);
        byte[] bArr3 = str.getBytes("CP949");

        System.out.println("UTF-8 : " + joinByteArr(bArr));
        System.out.println("ISO-8859-1 : " + joinByteArr(bArr2));
        System.out.println("CP949 : " + joinByteArr(bArr3));

        System.out.println("UTF-8 : " + new String(bArr, StandardCharsets.UTF_8));
        System.out.println("ISO-8859-1 : " + new String(bArr2, StandardCharsets.ISO_8859_1));
        System.out.println("CP949 : " + new String(bArr3, "CP949"));
    }

    static String joinByteArr(byte[] bArr){
        StringJoiner sj = new StringJoiner(";", "[", "]");

        for(byte b : bArr)
            sj.add(String.format("%02X",b));

        return sj.toString();
    }

}