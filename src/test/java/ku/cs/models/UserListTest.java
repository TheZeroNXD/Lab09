import ku.cs.models.UserList;
import ku.cs.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    private UserList userList;

    @BeforeEach
    void setUp() {
        userList = new UserList();

        // Add 3 users to UserList for each test
        userList.addUser("user1", "password1");
        userList.addUser("user2", "password2");
        userList.addUser("user3", "password3");
    }

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        User foundUser = userList.findUserByUsername("user1");

        assertNotNull(foundUser);
        assertEquals("user1", foundUser.getUsername());
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        boolean passwordChanged = userList.changePassword("user2", "password2", "newPassword");

        assertTrue(passwordChanged);

        // Verify that the password has been changed
        User user = userList.findUserByUsername("user2");
        assertNotNull(user);
        assertTrue(user.isPassword("newPassword"));
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // Attempt to log in with correct username and password
        User loggedInUser = userList.login("user3", "password3");

        assertNotNull(loggedInUser);
        assertEquals("user3", loggedInUser.getUsername());
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // Attempt to log in with correct username but incorrect password
        User loggedInUser = userList.login("user1", "incorrectPassword");

        assertNull(loggedInUser); // This test should fail
    }
}
