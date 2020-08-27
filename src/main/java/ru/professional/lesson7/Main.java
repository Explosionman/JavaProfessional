package ru.professional.lesson7;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) throws Exception {
        URLConnection connection = new URL("https://vozhzhaev.ru/test.php").openConnection();

        InputStream is = connection.getInputStream();
        InputStreamReader reader = new InputStreamReader(is);
        char[] buffer = new char[256];
        int rc;
        StringBuilder sb = new StringBuilder();
        while ((rc = reader.read(buffer)) != -1)
            sb.append(buffer, 0, rc);
        reader.close();
        System.out.println(sb);
    }
}
