package models;

import dao.DatabaseRule;
import org.junit.*;

import static org.junit.Assert.*;

@SuppressWarnings("ConstantConditions")
public class UserTest {

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    private User newUser(){
        return new User("Kanye West","Manager","Artist","Def Jam");
    }

    @Test
    public void initializeCorrectly(){
        User user = newUser();
        assertTrue(user instanceof User);
    }

    @Test
    public void getFunctionsWorkWell(){
        User user = newUser();
        assertEquals(user.getName(),newUser().getName());
        assertEquals(user.getPosition(),newUser().getPosition());
        assertEquals(user.getRole(),newUser().getRole());
        assertEquals(user.getDepartment(),newUser().getDepartment());
    }


}