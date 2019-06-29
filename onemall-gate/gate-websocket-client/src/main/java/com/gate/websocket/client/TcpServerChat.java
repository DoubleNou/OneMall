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
 * @create: 2019-06-27 10:42
 **/
public class TcpServerChat {

    public static void main(String[] args) {
        System.out.println("——————————server————————————");

        try {
            ServerSocket socket = new ServerSocket(8888);

            //2.阻塞式等待连接accept
            Socket client = socket.accept();

            //3.接收消息
            DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());

            boolean isRunning = true;
            while (isRunning) {
                String msgs = dataInputStream.readUTF();
                System.out.println(msgs);

                //4.返回消息
                dataOutputStream.writeUTF(msgs);
                dataOutputStream.flush();
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }
}
