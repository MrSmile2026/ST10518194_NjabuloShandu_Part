/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog56121part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PROG56121PART1IT {

    private static Object returnLoginStatus(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
//TESTING CheckUserName
@Test
public void testCheckUserName() {
assertTrue(PROG56121PART1.checkUserName("user_")); // valid
assertFalse(PROG56121PART1.checkUserName("user")); // missing _
assertFalse(PROG56121PART1.checkUserName("long_username")); // too long
}
//testCheckPasswordComplexity
@Test
public void testCheckPasswordComplexity() {
assertTrue(PROG56121PART1.checkPasswordComplexity("Passw0rd!")); // valid
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
}