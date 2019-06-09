package io;

import java.io.*;

/**
 * @program: kafka-common
 * @description:
 * @author: Nou
 * @create: 2019-06-09 18:02
 **/
public class DataIoClass {

    public static void main(String[] args) {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(os));

        try {
            dos.writeUTF("hello你好呀");
        } catch ( IOException e ) {
            e.printStackTrace();
        }

        byte[] datas = os.toByteArray();


        DataInputStream is = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));

        try {
            System.out.println(datas);
            String st = is.readUTF();
            System.out.println(st);
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }


}
