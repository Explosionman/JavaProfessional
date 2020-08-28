package ru.professional.ProxyLesson.variant3;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class MainVar3 {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("C://forTest/ip.txt");
        int c;
        String ipList = "";
        while ((c = reader.read()) != -1) {
            ipList += (char) c;
        }
        String[] ipListArray = ipList.split("\r");
        for (int i = 0; i < ipListArray.length; i++) {
            String[] splitString = ipListArray[i].split(":");
            String ip = splitString[0].trim();
            int port = Integer.parseInt(splitString[1]);
            Thread var3 = new Thread(new MyThreadRunner(ip, port));
            var3.start();
        }
    }
}