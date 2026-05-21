/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog56121part1;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class PROG56121PART1IT {

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }


    private static Object returnLoginStatus(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
//TESTING CheckUserName
@Test
public void testCheckUserName() {
    //Test Data:"Kyl_1"
assertTrue(PROG56121PART1.checkUserName("Kyl_1")); // valid
assertFalse(PROG56121PART1.checkUserName("user")); // missing _
assertFalse(PROG56121PART1.checkUserName("long_username")); // too long
}
//testCheckPasswordComplexity
@Test
public void testCheckPasswordComplexity() {
    //Test Data:"Ch&&sec@ke99!"
assertTrue(PROG56121PART1.checkPasswordComplexity("Ch&&sec@ke99!")); // valid
assertFalse(PROG56121PART1.checkPasswordComplexity("password")); // no capital, number, special
assertFalse(PROG56121PART1.checkPasswordComplexity("Password")); // no number, special
assertFalse(PROG56121PART1.checkPasswordComplexity("Pass1234")); // no special char
}
//testCheckCellPhoneNumber
@Test
public void testCheckCellPhoneNumber() {
assertTrue(PROG56121PART1.checkCellPhoneNumber("+27123456789")); // valid
assertFalse(PROG56121PART1.checkCellPhoneNumber("0123456789")); // missing +27
assertFalse(PROG56121PART1.checkCellPhoneNumber("+2712345678")); // too short
}
//testRegisterUser
@Test
public void testRegisterUser() {
assertEquals("Username and password successfully captured. User registered!",
PROG56121PART1.registerUser("user_", "Passw0rd!"));

assertEquals("Username is not correct. Must have _ and max 5 chars.",
PROG56121PART1.registerUser("user", "Passw0rd!"));

assertEquals("Password is not correct. Must have 8+ chars, capital letter, number, and special char.",
PROG56121PART1.registerUser("user_", "password"));
}
//testLoginUser
@Test
public void testLoginUser() {
String storedUsername = "user_";
String storedPassword = "Passw0rd!";

assertTrue(PROG56121PART1.loginUser("user_", "Passw0rd!", storedUsername, storedPassword));
assertFalse(PROG56121PART1.loginUser("wrong", "Passw0rd!", storedUsername, storedPassword));
assertFalse(PROG56121PART1.loginUser("user_", "wrong", storedUsername, storedPassword));
}
//testReturnLoginStatus
@Test
public void testReturnLoginStatus() {
assertEquals("Login successful! Welcome back!", PROG56121PART1IT.returnLoginStatus(true));
assertEquals("Username or password incorrect, please try again.", PROG56121PART1IT.returnLoginStatus(false));
}
@Test
    public void testLoginSuccessful() {
        assertTrue(PROG56121PART1.loginUser("Kyl_1", "Ch&&sec@ke99!", "Kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        assertFalse(PROG56121PART1.loginUser("wrong", "wrong", "Kyl_1", "Ch&&sec@ke99!"));
    }

    /**
     * Test of main method, of class PROG56121PART1.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = new String[0];
        PROG56121PART1.main(args);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of registerUser method, of class PROG56121PART1.
     */
    @Test
    public void testRegisterUser_String_String() {
        System.out.println("registerUser");
        String username = "";
        String password = "";
        String expResult = "";
        String result = PROG56121PART1.registerUser(username, password);
        
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of validateNumber method, of class PROG56121PART1.
     */
    @Test
    public void testValidateNumber() {
        System.out.println("validateNumber");
        String num = "";
        String expResult = "";
        String result = PROG56121PART1.validateNumber(num);
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of createMessageHash method, of class PROG56121PART1.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        String id = "";
        int num = 0;
        String msg = "";
        String expResult = "";
        String result = PROG56121PART1.createMessageHash(id, num, msg);
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of registerUser method, of class PROG56121PART1.
     */
    @Test
    public void testRegisterUser_0args() {
        System.out.println("registerUser");
        String[] expResult = null;
        String[] result = PROG56121PART1.registerUser();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of login method, of class PROG56121PART1.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String[] credentials = null;
        PROG56121PART1.login(credentials);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getMessageLimit method, of class PROG56121PART1.
     */
    @Test
    public void testGetMessageLimit() {
        System.out.println("getMessageLimit");
        int expResult = 0;
        int result = PROG56121PART1.getMessageLimit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of displayMenu method, of class PROG56121PART1.
     */
    @Test
    public void testDisplayMenu() {
        System.out.println("displayMenu");
        PROG56121PART1.displayMenu();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of sendMessage method, of class PROG56121PART1.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        PROG56121PART1.sendMessage();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of showMessages method, of class PROG56121PART1.
     */
    @Test
    public void testShowMessages() {
        System.out.println("showMessages");
        PROG56121PART1.showMessages();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of discardLastMessage method, of class PROG56121PART1.
     */
    @Test
    public void testDiscardLastMessage() {
        System.out.println("discardLastMessage");
        PROG56121PART1.discardLastMessage();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of storeMessage method, of class PROG56121PART1.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        PROG56121PART1.storeMessage();
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of saveAndExit method, of class PROG56121PART1.
     */
    @Test
    public void testSaveAndExit() {
        System.out.println("saveAndExit");
        PROG56121PART1.saveAndExit();
        // TODO review the generated test code and remove the default call to fail.
        
    }
}