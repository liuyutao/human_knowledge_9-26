package com.allin.knowledge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Aubergine
 * zhaoshuangquan@allinmd.cn
 * 2017-08-30 14:58
 */
@SpringBootApplication
//@MapperScan(basePackages = "com.allin.knowledge.mapper")
//@EnableConfigurationProperties({MyBatisProperty.class})//加载配置文件信息
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}
