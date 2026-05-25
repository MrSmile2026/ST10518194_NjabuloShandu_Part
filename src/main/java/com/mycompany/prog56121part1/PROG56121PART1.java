/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
// NJABULO SHANDU ST 10518194 PROG POE
package com.mycompany.prog56121part1;

// Import necessary classes for input handling, file operations, and regex pattern matching
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


/**
 *
 * @author KoMkh
 */
//NJABULO SHANDU ST 10518194 PROG POE
// Define a Message class to store message attributes
class Message {
    String id;
    String hash;
    String recipient;
    String content;
    String timestamp;
    String status;
    
// Constructor to initialize a Message object
public Message(String id, String hash, String recipient, String content, String timestamp, String status) {
    this.id = id;
    this.hash = hash;
    this.recipient = recipient;
    this.content = content;
    this.timestamp = timestamp;
    this.status = status;
    }
}

//NJABULO SHANDU ST 10518194 PROG POE
public class PROG56121PART1 {
// List to store message
    static ArrayList<Message> messages = new ArrayList<>();
// Scanner object for input handling
    static Scanner input = new Scanner(System.in);
// Count of messages sent
    static int sentCount = 0;
// Maximum number of messages allowed
    static int messageLimit = 0;
    
    
    
// Validation methods...
    public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    public static boolean checkPasswordComplexity(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return Pattern.matches(regex, password);
    }
// Check if cell phone number is valid (+27 followed by 9 digits)
    public static boolean checkCellPhoneNumber(String number) {
        String regex = "^\\+27\\d{9}$";
        return Pattern.matches(regex, number);
    }
    public static String registerUser(String username, String password) {
        if (!checkUserName(username)) {
            return "Username is not correct. Must have _ and max 5 chars.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correct. Must have 8+ chars, capital letter, number, and special char.";
        }
        return "Username and password successfully captured. User registered!";
    }
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
    
       public static String validateNumber(String num) { // check phone number

        if (num == null) return "incorrect"; // null check

        if (!num.startsWith("+27")) // must start +27
            return "incorrect:Recipient number must start with +27";

        if (num.length() != 12) // must be 12 chars
            return "incorrect:Recipient number must be 12 digits (+27XXXXXXXXX)";

        if (!num.substring(3).matches("\\d{9}")) // rest must be digits
            return "incorrect: only digits allowed after +27";

        return "Recipient number enterd successfully"; // correct number
    }
    
//NJABULO SHANDU ST 10518194 PROG POE    
    public static String createMessageHash(String id, int num, String msg) {
        String[] words = msg.trim().split(" ");
        String first = words.length > 0 ? words[0] : "MSG";
        String last = words.length > 1 ? words[words.length - 1] : words[0];
        return (id.substring(0, 2) + ":" + num + ":" + first + last).toUpperCase();
    }
    
    
    
// Main method
    public static void main(String[] args) {
    String[] credentials = registerUser();
    login(credentials);
    
// Get the message limit
        messageLimit = getMessageLimit();
        
// Loop until the user chooses to quit
        while (true) {
                // Display the menu
            displayMenu();
                // Get the user's choice
            String choice = input.nextLine();
            switch (choice) {
                case "1":
                // Send a message           
                    sendMessage();
                    break;
                case "2":
                // Show messages
                    showMessages();
                    break;
                case "3":
                // Discard the last message             
                    discardLastMessage();
                    break;
                case "4":
                // Save messages to file   
                    storeMessage();
                    break;
                case "5":
                // Save and exit    
                    saveAndExit();
                    return;
                default:
                // Invalid option
                    System.out.println("[ERROR] Invalid option!");
            }
        }
    }
   
    
    
// Method to register a new user and return their credentials
    public static String[] registerUser() {
    System.out.println("Registration");
    String username;
    while (true) {
        System.out.print("Enter Username (must contain '_' and max 5 chars): ");
        username = input.nextLine();
        if (checkUserName(username)) break;
        System.out.println("Invalid username. Example: User_");
    }
    String password;
    while (true) {
        System.out.print("Enter Password (8+ chars, 1 capital, 1 number, 1 special char): ");
        password = input.nextLine();
        if (checkPasswordComplexity(password)) break;
        System.out.println("Invalid password. Example: Password5!");
    }
    String cellPhone;
     while (true) {
            System.out.print("Enter Cell Phone (+27 followed by 9 digits): ");
            cellPhone = input.nextLine();
            if (checkCellPhoneNumber(cellPhone)) {
                System.out.println("Cell phone number successfully added.");
                break;
            }
            System.out.println("Invalid number. Must start with +27 and have 9 digits. Example: +27123456789");
        }
     
    
//NJABULO SHANDU ST 10518194 PROG POE  
// Display registration message and return credentials
    System.out.println(registerUser(username, password));
    return new String[] {username, password};
    }
  
    
// Method to handle user login
public static void login(String[] credentials) {
    System.out.println("\nLogin");
    while (true) {
        System.out.print("Enter Username: ");
        String loginUser = input.nextLine();
        System.out.print("Enter Password: ");
        String loginPass = input.nextLine();
        if (loginUser(loginUser, loginPass, credentials[0], credentials[1])) {
            System.out.println("WELCOME TO QUICKCHAT");
            break;// Break loop if login is successful
        }
        System.out.println("Invalid credentials. Try again.");
    }
}



// Method to get the message limit
    public static int getMessageLimit() {
        while (true) {
            try {
                System.out.print("How many messages do you want to send? ");
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Invalid number!");
            }
        }
    }
    
    
    
// Method to display the menu
    public static void displayMenu() {
        System.out.println("\n~~~~MENU~~~~");
        System.out.println("1. Send Message");
        System.out.println("2. Show Messages");
        System.out.println("3. Discard Last Message");
        System.out.println("4. Save Messages");
        System.out.println("5. Quit");
        System.out.println("~~~~~~~~~~~~~~");
        System.out.print("Choose option(1-5): ");
    }
    
    
//NJABULO SHANDU ST 10518194 PROG POE    
// Method to send a message
    public static void sendMessage() {
        if (sentCount >= messageLimit) {
            System.out.println("[WARNING] Message limit reached!");
            return;
        }
        System.out.print("Enter Recipient Number (+27XXXXXXXXX): ");
        String rec = input.nextLine();
        
        String validation = validateNumber(rec); // validate number
        if (!validation.equals("Recipient number enterd successfully")) { // if invalid
            System.out.println("[ERROR] " + validation); // show error
            return;
        }
        String usernameUser;
    while (true) {
        System.out.print("Enter Recipient Username (must contain '_' and max 5 chars): ");
        usernameUser = input.nextLine();
        if (checkUserName(usernameUser)) break;
        System.out.println("Invalid Recipient username. Example: User_");
    }
    
        System.out.print("Enter Message (max 250 chars): ");
String msg = input.nextLine();
if (msg.length() > 250) {
    int excessChars = msg.length() - 250;
    int excessWords = msg.substring(250).split("\\s+").length;
    System.out.println("[ERROR] Message exceeds 250 characters by " + excessChars + " characters (" + excessWords + " words). [Please reduce the size]");
    return;

        }
        String id = String.format("%010d", (long) (Math.random() * 10000000000L));
        String hash = createMessageHash(id, sentCount, msg);
        Message message = new Message(id, hash, rec, msg, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "SENT");
        messages.add(message);
        sentCount++;
        System.out.println("\n.............MESSAGE DETAILSK..................");
       
        System.out.println("MESSAGE ID : " + id);
        System.out.println("RECIPIENT NUMBER : "+ rec);
        System.out.println("RECIPIENT USERNAME :" + usernameUser);
        System.out.println("MESSAGE : " + msg);
        System.out.println("HASH : " + hash);
        System.out.println("TIME : " + message.timestamp);
        System.out.println("Message successfully sent");
        System.out.println("\n...............................");
    }
    
    
    
   
// Method to show messages
    public static void showMessages() {
        System.out.println("\n..............................");
        System.out.println(" SHOW MESSAGES");
        System.out.println("................................");
        
        System.out.println("[COMING SOON] This feature is under development."); // placeholder
        System.out.println("Please check back later."); // note
        
        System.out.println("\n...............................");
    }
    
    
    
// Method to discard the last message
    public static void discardLastMessage() {
        if (messages.isEmpty()) {
            System.out.println(" No messages to discard.");
            return;
        }
        Message lastMessage = messages.remove(messages.size() - 1);
        sentCount--;
        System.out.println(" Message discarded: " + lastMessage.content);
    }
    
    
    
// Method to save messages to file
    public static void storeMessage() {
        try (FileWriter file = new FileWriter("messages.json")) {
            file.write("[\n");
            for (int i = 0; i < messages.size(); i++) {
                Message msg = messages.get(i);
                file.write(" {\n");
                file.write(" \"id\": \"" + msg.id + "\",\n");
                file.write(" \"hash\": \"" + msg.hash + "\",\n");
                file.write(" \"recipient\": \"" + msg.recipient + "\",\n");
                file.write(" \"message\": \"" + msg.content + "\",\n");
                file.write(" \"status\": \"" + msg.status + "\",\n");
                file.write(" \"time\": \"" + msg.timestamp + "\"\n");
                file.write(" }" + (i < messages.size() - 1 ? "," : "") + "\n");
            }
            file.write("]");
            System.out.println("\n Messages successfully stored.");
        } catch (IOException e) {
            System.out.println("[ERROR] Failed to save file!");
        }
    }
    
    
 //NJABULO SHANDU ST 10518194 PROG POE   
// Method to save and exit
    public static void saveAndExit() {
        String save;
        while (true){
        System.out.print("Save before exit? (yes/no): "); // ask
        save = input.nextLine(); // read input
        if (save.equalsIgnoreCase("yes")) { // if yes
            storeMessage(); // save messages
            System.out.println("[SUCCESS] Messages saved before exit.");
            break;
        } else if (save.equalsIgnoreCase("no")) { // if no
            break;
        } else {
            System.out.println("[ERROR] Invalid input! Please type 'yes' or 'no'."); // handle invalid input
        }
    }
    System.out.println("Total messages sent: " + sentCount); // show total
    System.out.println("Goodbye!"); // exit msg
    return; // end program
    }
  
 
}
  
       
     // NJABULO SHANDU ST 10518194 PROG POE // NJABULO SHANDU ST 10518194 PROG POE // NJABULO SHANDU ST 10518194 PROG POE   
    
        
        

        
        
        
    

