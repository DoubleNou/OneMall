package com.onemall.gate.websocket.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/**
 * @program: kafka-common
 * @description:
 * @author: Nou
 * @create: 2019-06-18 17:16
 **/
@Configuration
public class Config {
    @Bean
    public DataSource dataSource0(){
        return new DruidDataSource();
    }
}
