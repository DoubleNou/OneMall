package com.gate.websocket.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @program: kafka-common
 * @description:
 * @author: Nou
 * @create: 2019-06-29 16:28
 **/
public class SxsUtils {

    public static void close(Closeable...tagets){

        for (Closeable target : tagets){
            try {
                if (null != target){
                    target.close();
                }
            } catch ( IOException e ) {
                e.printStackTrace();
            }
        }

    }
}
