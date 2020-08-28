package ru.professional.ProxyLesson.variant2;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class MainVar2 {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("C://forTest/ip.txt");
        int c;
        String ipList = "";
        while ((c=reader.read())!=-1){
            ipList += (char)c;
        }
        String[] ipListArray = ipList.split("\r");
        for (int i = 0; i < ipListArray.length; i++) {
            String[] splitString = ipListArray[i].split(":");
            String ip = splitString[0].trim();
            int port = Integer.parseInt(splitString[1]);
            Thread var2 = new Thread(new Runnable() {
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

                        System.out.println("ip: "+ip+":"+port+" - ДОСТУПЕН");
                    }catch (Exception e){
                        System.out.println("ip: "+ip+":"+port+" - недоступен");
                    }
                }
            });
            var2.start();
        }
    }
}


