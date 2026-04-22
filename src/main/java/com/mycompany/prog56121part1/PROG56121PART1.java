/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
// NJABULO SHANDU ST 10518194 PROG POE
package com.mycompany.prog56121part1;

//import necesary classes for input handling  and regex pattern matching

import java.util.regex.Pattern;
import java.util.Random;
import java.util.Scanner;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;



/**
 *
 * @author KoMkh
 */
public class PROG56121PART1 {
 
  // NJABULO SHANDU ST 10518194 PROG POE
    private static boolean exit;
    private static int maxMessages = 0;
    private static int totalMessages = 0;
    private static int messageCounter = 0;
    
    static final JSONArray messageStorage = new JSONArray();
    
    
      static Scanner input = new Scanner(System.in);
    
      
      

private static String CheckRecipient(String recipient) {
    if (recipient == null || !recipient.matches("^\\+\\d{9,12}$")) {
        System.out.println("Invalid number. Must include country code and be <=12 digits.");
        return null;
    }
    return recipient;
}
 
static void showRecentlySentMessages() {
    if (messageStorage.isEmpty()) {
        System.out.println("No stored messages.");
    } else {
        System.out.println("Stored Messages:");
        for (Object obj : messageStorage) {
            System.out.println(obj);
        }
    }
}
// NJABULO SHANDU ST 10518194 PROG POE
    
    public static void sendMessage() {
    long messageId = 10000000000L + new Random().nextInt(900000000);
    messageCounter++;

    System.out.print("Input recipient number (+CCXXXXXXXXXX): ");
    String recipient = input.nextLine();
    recipient = CheckRecipient(recipient);
    if (recipient == null) return;

    System.out.print("Enter your message (max 250 characters): ");
    String message = input.nextLine();

    if (message.length() > 250) {
        System.out.println("Message exceeds 250 characters");
        return;
    }

    String[] words = message.trim().split("\\s+");
    String hash = String.format("%02d:%d:%s%s",
            Long.valueOf(Long.toString(messageId).substring(0, 2)),
            messageCounter,
            words[0].toUpperCase(),
            words.length > 1? words[words.length - 1].toUpperCase() : "");

    System.out.println("\nSelect action:");
    System.out.println("1. Post");
    System.out.println("2. Cancel");
    System.out.println("3. Archive");

    int action = Integer.parseInt(input.nextLine());

    if (action == 2) {
        System.out.println("Message Cancelled");
        return;
    }

    JSONObject jsonMessage = new JSONObject();
    jsonMessage.put("MessageID", messageId);
    jsonMessage.put("MessageHash", hash);
}

                          //  Main Method 
    // NJABULO SHANDU ST 10518194 PROG POE 
    
    public static void main(String[] args){

        String storedUsername = "";
        String storedPassword = "";
        String cellPhone;
    
                            //  Registration 
                            
        // Loop until valid username
        
        String username;
        while (true) {
            System.out.print("Enter Username (must contain '_' and max 5 chars): ");
            username = input.nextLine();
            if (checkUserName(username)) break;
            System.out.println("Invalid username. Example: user_");
        }

        // Loop until valid password
        
        String password;
        while (true) {
            System.out.print("Enter Password (8+ chars, 1 capital, 1 number, 1 special char): ");
            password = input.nextLine();
            if (checkPasswordComplexity(password)) break;
            System.out.println("Invalid password. Example: Password1!");
        }
        String registerMessage = registerUser(username, password);
        System.out.println(registerMessage);
         // Register user
        System.out.println(registerMessage);
        storedUsername = username;
        storedPassword = password;
        
        
        // Loop until valid cell phone
        
        while (true) {
            System.out.print("Enter Cell Phone (+27 followed by 9 digits): ");
            cellPhone = input.nextLine();
            if (checkCellPhoneNumber(cellPhone)) {
                System.out.println("Cell phone number successfully added.");
                break;
            }
            System.out.println("Invalid number. Must start with +27 and have 9 digits. Example: +27123456789");
        }
        

        //  Login Section 
        
        System.out.println("\nLogin");
        
        String loginUser;
        String loginPass;
        boolean status;

        while (true) {
            System.out.print("Enter Username: ");
            loginUser = input.nextLine();

            System.out.print("Enter Password: ");
            loginPass = input.nextLine();

            status = PROG56121PART1.loginUser(loginUser, loginPass, storedUsername, storedPassword);

            System.out.println(PROG56121PART1.returnLoginStatus(status));

            if (status) break; // stop loop on successful login
          //NJABULO SHANDU ST10518194 
        }
        System.out.print("Welcome to ChatIT");
        loginUser = input.nextLine();
            
        
        try {
            System.out.print("How many messages do you wish to send? ");
            maxMessages = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, exiting programme");
            return;
        }

          while (!exit) {
            System.out.println("\nSelect an Option:");
            System.out.println("1. Post Message");
            System.out.println("2. Previous Messages");
            System.out.println("3. Exit");
            System.out.print("Choice: ");

            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    if (totalMessages < maxMessages) {
                        sendMessage();
                    } else {
                        System.out.println("Maximum Message Reached. You may not send more");
                    }
                    break;
                case 2:
                    showRecentlySentMessages();
                    break;
                case 3:
                    exit = true;
                    break;
            }
        }
    
}
                    
                        //  Static Methods 

    // Check if username contains "_" and max 5 characters
    
    public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    
    // Check if password has at least 8 chars, capital letter, number, special char
    
    public static boolean checkPasswordComplexity(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return Pattern.matches(regex, password);
    }
    
    

    // Check if cell phone number is valid (+27 followed by 9 digits)
    
    public static boolean checkCellPhoneNumber(String number) {
        String regex = "^\\+27\\d{9}$";
        return Pattern.matches(regex, number);
    }
    // Register user and validate username and password
    
    public static String registerUser(String username, String password) {
        if (!checkUserName(username)) {
            return "Username is not correct. Must have _ and max 5 chars.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correct. Must have 8+ chars, capital letter, number, and special char.";
        }
        return "Username and password successfully captured. User registered!";
    }
//NJABULO SHANDU ST10518194
    // Login user by checking stored username and password
    
    
    
    
    public static boolean loginUser(String username, String password, String storedUsername, String storedPassword) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }

    // Show login message
    
    public static String returnLoginStatus(boolean status) {
        if (status) {
            return "Login successful! Welcome back!";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    

    static void saveMessagesToJSON() {
    try (FileWriter file = new FileWriter("storedMessages.json")) {
        file.write(messageStorage.toJSONString());
        file.flush();
        System.out.println("Stored messages saved to storedMessages.json");
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
       
     // NJABULO SHANDU ST 10518194 PROG POE // NJABULO SHANDU ST 10518194 PROG POE // NJABULO SHANDU ST 10518194 PROG POE   
    
        
        

        
        
        
    

