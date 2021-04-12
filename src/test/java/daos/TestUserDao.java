package daos;

import models.User;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Set;

public class TestUserDao {

    @Test
    public void testFindById () {
        // Given
        UserDao d = new UserDao();
        int givenId = 1;
        LocalDate givenDob = LocalDate.of(1992, 8, 2);

        // When
        User actualUser = d.findById(givenId);

        // Then
        Assert.assertEquals(actualUser.getName(), "Theresa Mashura");
        Assert.assertEquals(actualUser.getDob(), givenDob);
    }

    @Test
    public void testFindAllUsers() {
        // Given
        UserDao d = new UserDao();

        // When
        Set<User> actual = d.findAll();

        // Then
        Assert.assertTrue(actual.size() > 0);
    }

    @Test
    public void testCreateUser () {
        // Given
        UserDao d = new UserDao();
        User givenUser = new User("iHeartPuppies", "Christina Shoemaker", LocalDate.of(1995, 9, 12), "Wilmington", "USA", "puppiesRcute");

        // When
        Integer userCreated = d.create(givenUser);

        // Then
        Assert.assertTrue(userCreated != null);
    }

    @Test
    public void testUpdateUser () {
        // Given
        UserDao d = new UserDao();
        User givenUser = new User(4,"iHeartPuppies", "Christina Shoemaker", LocalDate.of(1995, 9, 12), "Dublin", "Ireland", "puppiesRcute");

        // When
        Boolean userUpdated = d.update(givenUser);

        // Then
        Assert.assertTrue(userUpdated);
    }

    @Test
    public void testDeleteUser() {
        // Given
        UserDao d = new UserDao();
        User givenUser = new User(null,"ExistsFleetingly", "Joe Temp", LocalDate.of(1995, 9, 12), "The Void", "NotAroundLong", "doesitmatter");


        // When
        Integer actualId = d.create(givenUser);
        boolean deleted = d.delete(actualId);

        // Then
        Assert.assertTrue(actualId != null);
        Assert.assertTrue(deleted);
    }
}
