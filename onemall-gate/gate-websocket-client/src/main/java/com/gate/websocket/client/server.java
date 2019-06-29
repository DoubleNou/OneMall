package com.gate.websocket.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: kafka-common
 * @description:
 * @author: Nou
 * @create: 2019-06-22 19:46
 **/
public class server {
    public static void main(String[] args) throws IOException {

        System.out.println("++++++++++server++++++++++++++");
        ServerSocket server = new ServerSocket(8081);

        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");
        DataInputStream is = new DataInputStream(client.getInputStream());

        String data = is.readUTF();

        System.out.println(data);

        is.close();
        client.close();
    }
}
