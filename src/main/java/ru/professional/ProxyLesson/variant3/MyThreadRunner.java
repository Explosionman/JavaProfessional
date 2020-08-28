package ru.professional.ProxyLesson.variant3;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class MyThreadRunner implements Runnable {
    private String ip;
    private int port;

    public MyThreadRunner(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));

        try {
            URLConnection connection = new URL("https://vozhzhaev.ru/test.php").openConnection(proxy);

            InputStream is = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            char[] buffer = new char[256];
            int rc;

            StringBuilder sb = new StringBuilder();

            while ((rc = reader.read(buffer)) != -1)
                sb.append(buffer, 0, rc);

            reader.close();

            System.out.println("ip: " + ip + ":" + port + " - ДОСТУПЕН");
        } catch (Exception e) {
            System.out.println("ip: " + ip + ":" + port + " - недоступен");
        }
    }
}

