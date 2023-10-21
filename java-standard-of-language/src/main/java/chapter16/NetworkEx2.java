package chapter16;

import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx2 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.codechobo.com:80/sample/hello.html?referer=codechobo#index1");
    }
}
