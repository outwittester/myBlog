package com.sincere.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 5000);

        InputStream is = socket.getInputStream();

        OutputStream os = socket.getOutputStream();

        os.write("hello world".getBytes());

        byte[] buffer = new byte[200];

        int length = is.read(buffer);

        System.out.println(new String(buffer, 0, length));
        is.close();
        os.close();
        socket.close();
    }
}
