package com.gate.websocket.client;

import java.io.*;
import java.net.Socket;

/**
 * @program: kafka-common
 * @description:
 * @author: Nou
 * @create: 2019-06-27 13:03
 **/
public class TcpClientMultiChat2 {
    public static void main(String[] args) {
        System.out.println("_________client_________");
        try {
            Socket client = new Socket("localhost", 8888);

            //客户端发送消息
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(client.getInputStream());

            boolean isRunning = true;
            while (isRunning) {
                String msg = console.readLine();
                dataOutputStream.writeUTF(msg);
                dataOutputStream.flush();

                msg = dataInputStream.readUTF();
                System.out.println(msg);
            }

            dataOutputStream.close();
            dataInputStream.close();
            client.close();

        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
