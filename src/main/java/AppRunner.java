import daos.UserDao;
import models.User;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

public class AppRunner {


    public static void main(String[] args) {

    UserDao user = new UserDao();

    User theresa = user.findById(1);
    theresa.setCity("Baltimore");
    if (user.update(theresa)) {
        System.out.println("Theresa's city has been updated.");
    };

    User monica = new User(null, "Monica123", "Monica Brian", LocalDate.of(1992, 8, 8), "West Chester", "USA", "abc");
    System.out.println("New user with id: " + user.create(monica) +  "has been created");

    if (user.delete(4)) {
        System.out.println("User with id 4 has been deleted.");
    };

    Set<User> listUsers = user.findAll();
    Iterator<User> itr = listUsers.iterator();
    while (itr.hasNext()) {
        System.out.println(itr.next()) ;
    }

    }
}


