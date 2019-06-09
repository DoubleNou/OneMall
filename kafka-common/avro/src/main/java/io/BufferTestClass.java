package io;

import java.io.*;

/**
 * @program: kafka-common
 * @description:
 * @author: Nou
 * @create: 2019-06-09 12:54
 **/
public class BufferTestClass {

    public static void main(String[] args) {
        String path = "/Users/noudepc/IdeaProjects/onemall/kafka-common/test1.text";
        String pathDest = "/Users/noudepc/IdeaProjects/onemall/kafka-common/test3.text";

        BufferTestClass bufferTestClass = new BufferTestClass();
        bufferTestClass.FileInput(path);
        bufferTestClass.FileOutPut(path, pathDest);

    }

    private void FileInput(String path){
        //1.创建源 2.选择流 3.操作 4. 释放
        File src  = new File(path);
        int len = -1;

        try(BufferedInputStream is = new BufferedInputStream(new FileInputStream(src));) {
            byte[] buffer =new byte[1024];
            while ((len = is.read(buffer)) != -1){
                String st = new String(buffer, 0 , len);
                System.out.println(st);
            }
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    private void FileOutPut(String srcPath, String destPath){
        //1.创建源 2.选择流 3.操作 4. 释放
        File src  = new File(srcPath);
        File dest = new File(destPath);
        int len = -1;

        try(BufferedInputStream is = new BufferedInputStream(new FileInputStream(src));
            BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] buffer =new byte[1024];
            while ((len = is.read(buffer)) != -1){
               os.write(buffer, 0 , len);
               os.flush();
            }
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
