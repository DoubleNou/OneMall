package com.gate.websocket.client;

import com.gate.websocket.utils.SxsUtils;

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
public class TcpServerMutiChat {

    public static void main(String[] args) {
        System.out.println("——————————server————————————");

        try {
            ServerSocket socket = new ServerSocket(8888);

            while (true){
                //2.阻塞式等待连接accept
                Socket client = socket.accept();
                System.out.println("______一个用户建立了连接_______");
                new Thread(new Channel(client)).start();
            }

        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }

    /**
     * 一个客户代表一个channel
     */
    static class Channel implements Runnable{

        DataInputStream dataInputStream;
        DataOutputStream dataOutputStream;
        Socket client;
        boolean isRunning = true;

        public Channel(Socket client) {
            this.client = client;
            try {
                this.dataInputStream = new DataInputStream(client.getInputStream());
                this.dataOutputStream = new DataOutputStream(client.getOutputStream());
            } catch ( IOException e ) {
                release();
            }

        }
        //接收消息
        private String recive(){
            String msg = "";
            try {
                 msg = dataInputStream.readUTF();
            } catch ( IOException e ) {
                release();
            }
            return msg;
        }
        //发送消息
        private void send(String msg){
            try {
                dataOutputStream.writeUTF(msg);
                dataOutputStream.flush();
            } catch ( IOException e ) {
                release();
            }
        }
        //释放资源
        private void release(){
            isRunning = false;
            SxsUtils.close(dataInputStream, dataOutputStream);
        }

        @Override
        public void run() {
            while (isRunning){
                String msg = recive();
                System.out.println(msg);
                if(!"".equals(msg)){
                    send(msg);
                }
            }
        }
    }


}
