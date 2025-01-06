package week_6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class validatePasswordTest {

    private final validatePassword validator = new validatePassword(); // instance of the class to test
    
    // Test for password length check
    @Test
    public void testPasswordLengthCheck() {
        assertTrue(validator.passwordLengthCheck("Valid1Password"));
        assertFalse(validator.passwordLengthCheck("Short"));
        assertFalse(validator.passwordLengthCheck("ThisPasswordIsWayTooLong"));
    }

    // Test for password containing at least one uppercase letter
    @Test
    public void testPasswordUppercaseCheck() {
        assertTrue(validator.passwordUppercaseCheck("Password1"));
        assertFalse(validator.passwordUppercaseCheck("password1"));
        assertFalse(validator.passwordUppercaseCheck("123456"));
    }

    // Test for password containing at least one lowercase letter
    @Test
    public void testPasswordLowercaseCheck() {
        assertTrue(validator.passwordLowercaseCheck("Password1"));
        assertFalse(validator.passwordLowercaseCheck("PASSWORD1"));
        assertFalse(validator.passwordLowercaseCheck("123456"));
    }

    // Test for password containing at least one special character
    @Test
    public void testPasswordSpecialCharacterCheck() {
        assertTrue(validator.passwordSpecialCharacterCheck("Password@1"));
        assertFalse(validator.passwordSpecialCharacterCheck("Password1"));
        assertFalse(validator.passwordSpecialCharacterCheck("123456"));
    }

    // Test for password containing at least one number
    @Test
    public void testPasswordNumberCheck() {
        assertTrue(validator.passwordNumberCheck("Password1"));
        assertFalse(validator.passwordNumberCheck("Password"));
        assertFalse(validator.passwordNumberCheck("special$char"));
    }
}
