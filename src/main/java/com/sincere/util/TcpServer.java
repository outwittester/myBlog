package com.sincere.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000);

        Socket socket = ss.accept();


        InputStream is = socket.getInputStream();

        OutputStream os = socket.getOutputStream();

        byte[] buffer = new byte[200];

        int length = is.read(buffer);

        System.out.println(new String(buffer,0,length));

        os.write("Dear I am coming ".getBytes());

        is.close();
        os.close();
        socket.close();

    }
}