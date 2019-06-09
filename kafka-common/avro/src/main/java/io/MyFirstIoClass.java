package io;

import java.io.*;

/**
 * @program: kafka-common
 * @description:
 * @author: Nou
 * @create: 2019-06-08 18:31
 **/
public class MyFirstIoClass {

    public static void main(String[] args) {
        MyFirstIoClass io = new MyFirstIoClass();
        String path = "/Users/noudepc/IdeaProjects/onemall/kafka-common/test1.text";
        String path2  = "/Users/noudepc/IdeaProjects/onemall/kafka-common/test2.text";

        io.copyFiles(path, path2);
    }

    private void testIoRead(String path){
        File file = new File(path);

        int temp = -1;
        InputStream inputStream = null;
        try {
            byte[] car = new byte[1024];
            inputStream = new FileInputStream(file);
            while ((temp=inputStream.read(car)) != -1){
                String str = new String(car, 0 ,temp);
                System.out.println(str);
            }
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch ( IOException e ) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void testIoWrite(String msg, String path){
        File file = new File(path);

        int temp = -1;
        FileOutputStream os = null;
        try {
            byte[] msgBytes = msg.getBytes();
            os = new FileOutputStream(file,true);
            os.write(msgBytes,0,msgBytes.length);
            os.flush();
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if(os != null){
                try {
                    os.close();
                } catch ( IOException e ) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void outPutStreamTest(String msg,String path){

        File file = new File(path);
        FileOutputStream os= null;

        try {
            byte[] bytes = msg.getBytes();
            os = new FileOutputStream(file);
            os.write(bytes, 0 , bytes.length);
            os.flush();
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if(os !=null){
                try {
                    os.close();
                } catch ( IOException e ) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void copyFiles(String srcPath,String destPath){
        //1.创建源
        File src = new File(srcPath);
        File dest = new File(destPath);
        //2. 选择流
        InputStream is = null;
        OutputStream os = null;

        int temp = -1;
        try {
            //3. 分段读取
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);

            byte[] bytes = new byte[256];
            while ((temp = is.read(bytes)) != -1){
                os.write(bytes, 0 ,bytes.length);
            }
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        }finally {
            //4. 释放，先打开后关闭
            if(os != null){
                try {
                    os.close();
                } catch ( IOException e ) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch ( IOException e ) {
                    e.printStackTrace();
                }
            }
        }
    }
}
