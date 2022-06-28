package ccnu.cs.c2.g8.oldbookmanagesystem.control;

import ccnu.cs.c2.g8.oldbookmanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


public class UserControl {
    @Autowired
    UserService userService;
}
