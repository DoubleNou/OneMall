package com.gate.websocket.client;

import com.gate.websocket.utils.SxsUtils;
import sun.applet.resources.MsgAppletViewer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @program: kafka-common
 * @description:
 * @author: Nou
 * @create: 2019-06-29 17:11
 **/
public class ClientSender implements Runnable{
    private BufferedReader console;
    private DataOutputStream dos;
    private Socket client;
    boolean isRunning = true;

    public ClientSender(Socket client) {
        this.client = client;
        console = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(client.getOutputStream());
        } catch ( IOException e ) {
            this.release();
        }
    }

    @Override
    public void run() {
        while (isRunning){
            try {
                String msg = console.readLine();
                if(!"".equals(msg)){
                    send(msg);
                }
            } catch ( IOException e ) {
                this.release();
            }
        }
    }
    //发送消息
    private void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch ( IOException e ) {
            this.release();
        }
    }

    //释放资源
    private void release(){
        isRunning = false;
        SxsUtils.close(dos);
    }


}
