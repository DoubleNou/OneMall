package com.gate.websocket.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @program: kafka-common
 * @description:
 * @author: Nou
 * @create: 2019-06-27 13:03
 **/
public class TcpClientMultiChat {
    public static void main(String[] args) {
        System.out.println("_________client_________");
        try {
            Socket client = new Socket("localhost", 8888);
            new Thread(new ClientSender(client)).start();
            new Thread(new Receive(client)).start();
        } catch ( UnknownHostException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
