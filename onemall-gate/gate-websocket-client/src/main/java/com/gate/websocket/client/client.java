package com.gate.websocket.client;

import java.io.*;
import java.net.Socket;

/**
 * @program: kafka-common
 * @description:
 * @author: Nou
 * @create: 2019-06-22 19:46
 **/
public class client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",8081);

        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(System.in));

        String data =  inputStream.readLine();

        System.out.println(data);
        outputStream.writeUTF(data);
        outputStream.flush();

        outputStream.close();
        socket.close();

    }
}
