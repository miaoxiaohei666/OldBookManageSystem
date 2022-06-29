package ccnu.cs.c2.g8.oldbookmanagesystem;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.User;
import ccnu.cs.c2.g8.oldbookmanagesystem.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OldBookManageSystemApplication {

    public static void main(String[] args) {
        //SpringApplication.run(OldBookManageSystemApplication.class, args);
        UserService userService = new UserService();
        if (userService.isUser(2020213673)){
            System.out.println("ok!");
        }
        else System.out.println("no");
    }

}
