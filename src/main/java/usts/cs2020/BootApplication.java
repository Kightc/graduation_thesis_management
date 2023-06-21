package usts.cs2020;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description:
 *
 * @Author Kight
 * @Date 2023/6/21 15:59
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("usts.cs2020.mapper")
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}
