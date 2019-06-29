package com.gate.websocket.client;

import com.gate.websocket.utils.SxsUtils;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @program: kafka-common
 * @description:
 * @author: Nou
 * @create: 2019-06-29 17:30
 **/
public class Receive implements Runnable {
    Socket client;
    DataInputStream dis;
    boolean isRunning = true;

    public Receive(Socket client) {
        this.client = client;
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch ( IOException e ) {
            release();
        }
    }

    //接收消息
    private String recive(){
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch ( IOException e ) {
            release();
        }
        return msg;
    }

    @Override
    public void run() {

        while (isRunning){
            String msg = recive();
            if(!"".equals(msg)){
                System.out.println(msg);
            }
        }
    }

    //释放资源
    private void release(){
        isRunning = false;
        SxsUtils.close(dis,client);
    }
}
