package ccnu.cs.c2.g8.oldbookmanagesystem;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class OldBookManageSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OldBookManageSystemApplication.class, args);

    }
}
