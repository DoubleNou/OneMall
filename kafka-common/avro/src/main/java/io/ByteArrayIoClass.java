package io;

import java.io.*;

/**
 * @program: kafka-common
 * @description:
 * @author: Nou
 * @create: 2019-06-09 13:05
 **/
public class ByteArrayIoClass {
    public static void main(String[] args) throws IOException {
       ByteArrayIoClass io = new ByteArrayIoClass();
       io.byteArrayInputTest();
       io.byteArrayOutputTest();

       io.insert("1","2","3","4");
    }

    private void byteArrayInputTest() throws IOException {
        //1。不需要源、都是从内存或者网络io中获取 2。选择流 3。操作 4。 不需要释放

        byte[] src = "你好呀北京asdasdasdasdasdasdasd".getBytes();

        BufferedInputStream is = null;
        BufferedOutputStream os = null;

        is = new BufferedInputStream(new ByteArrayInputStream(src));
        os = new BufferedOutputStream(new ByteArrayOutputStream());

        int len = -1;

        byte[] buffer = new byte[1024];
        while ((len = is.read(buffer)) != -1){
            String st = new String(buffer, 0,len);
            System.out.println(st);

            os.write(buffer, 0 , buffer.length);
            os.flush();
        }
    }

    private void byteArrayOutputTest(){
        byte[] dest = null;

        ByteArrayOutputStream os = null;
        try {
            os = new ByteArrayOutputStream();
            byte[] datas = "你好呀北哈哈哈哈哈哈哈京".getBytes();
            os.write(datas, 0 , datas.length);
            os.flush();
            dest = os.toByteArray();
            System.out.println(new String(dest, 0 , dest.length));
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    private void insert(String... sts){

        StringBuilder sb = new StringBuilder();

        for (String st:sts){
            sb.append(":").append(st);
        }

        System.out.println(sb.toString());

        Object o = new Object();

    }
}
