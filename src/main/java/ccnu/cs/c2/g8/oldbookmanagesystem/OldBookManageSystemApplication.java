package ccnu.cs.c2.g8.oldbookmanagesystem;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OldBookManageSystemApplication {

    public static void main(String[] args) {
        //SpringApplication.run(OldBookManageSystemApplication.class, args);
        Book book = new Book();
        User user = new User();
        System.out.println(user.toString());

    }

}
