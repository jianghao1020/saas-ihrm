package com.gitee.ihrm;

import com.gitee.ihrm.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author jianghao
 */
@SpringBootApplication
public class IhrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(IhrmApplication.class, args);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }

}
