/*public class PROG56121PART1IT {
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog56121part1;

// NJABULO SHANDU ST10518194 — PROG5121 POE PART 3 — Unit Tests
// JUnit 5 test class covering all required test cases from the rubric
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class PROG56121PART1IT {

    // Setup: fresh arrays + 5 test messages before every test
    @BeforeEach
    public void setUp() {
        // Clear all parallel arrays and master list
        PROG56121PART1.messages.clear();
        PROG56121PART1.sentMessages.clear();
        PROG56121PART1.disregardMessages.clear();
        PROG56121PART1.storedMessages.clear();
        PROG56121PART1.messageHashes.clear();
        PROG56121PART1.messageIDs.clear();
        PROG56121PART1.sentCount = 0;

        // Load the 5 POE-specified test messages (no hard-coding)
        PROG56121PART1.addMessageToArrays("0000000001", "+27834557896",
                "Did you get the cake?", "Sent");
        PROG56121PART1.addMessageToArrays("0000000002", "+27838884567",
                "Where are you? You are late! I have asked you to be on time.", "Stored");
        PROG56121PART1.addMessageToArrays("0000000003", "+27834484567",
                "Yohoooo, I am at your gate.", "Disregard");
        PROG56121PART1.addMessageToArrays("0000000004", "0838884567",
                "It is dinner time!", "Sent");
        PROG56121PART1.addMessageToArrays("0000000005", "+27838884567",
                "Ok, I am leaving without you.", "Stored");
    }
//NJABULO SHANDU ST 10518194 POE PART 1,2 AND 3 ALL IN ONE                                                                                                           //NJABULO SHANDU ST 10518194 POE PART 1,2 AND 3 ALL IN ONE                                                                                                               

    //  TEST 1 — Sent Messages Array Correctly Populated
    //  Expected: "Did you get the cake?", "It is dinner time!"

    @Test
    @DisplayName("Sent messages array contains correct entries")
    public void testSentMessagesContainsCorrectEntries() {
        assertTrue(PROG56121PART1.sentMessages.contains("Did you get the cake?"),
                "sentMessages must contain 'Did you get the cake?'");
        assertTrue(PROG56121PART1.sentMessages.contains("It is dinner time!"),
                "sentMessages must contain 'It is dinner time!'");
    }

    @Test
    @DisplayName("Sent messages array has exactly 2 entries")
    public void testSentMessagesSize() {
        assertEquals(2, PROG56121PART1.sentMessages.size(),
                "Only 2 messages are flagged Sent");
    }

    @Test
    @DisplayName("Stored messages are NOT in the sent array")
    public void testStoredNotInSentArray() {
        assertFalse(PROG56121PART1.sentMessages.contains(
                "Where are you? You are late! I have asked you to be on time."),
                "Stored messages must not appear in sentMessages");
        assertFalse(PROG56121PART1.sentMessages.contains("Ok, I am leaving without you."),
                "Stored messages must not appear in sentMessages");
    }

    @Test
    @DisplayName("Disregarded messages are NOT in the sent array")
    public void testDisregardedNotInSentArray() {
        assertFalse(PROG56121PART1.sentMessages.contains("Yohoooo, I am at your gate."),
                "Disregarded messages must not appear in sentMessages");
    }

    @Test
    @DisplayName("sentCount matches size of sentMessages array")
    public void testSentCountMatchesArray() {
        assertEquals(PROG56121PART1.sentMessages.size(), PROG56121PART1.sentCount,
                "sentCount must equal sentMessages.size()");
    }


    //  TEST 2 — Display the Longest Message
    //  Expected: "Where are you? You are late! I have asked you to be on time."

    @Test
    @DisplayName("Longest message is correctly identified")
    public void testLongestMessageIsCorrect() {
        String result = PROG56121PART1.displayLongestMessage();
        assertEquals("Where are you? You are late! I have asked you to be on time.", result,
                "Longest message must be message 2");
    }

    @Test
    @DisplayName("Longest message is longer than all others")
    public void testLongestMessageIsActuallyLongest() {
        String longest = PROG56121PART1.displayLongestMessage();
        for (Message m : PROG56121PART1.messages) {
            assertTrue(longest.length() >= m.content.length(),
                    "Returned message must be >= all other messages in length");
        }
    }

    @Test
    @DisplayName("Longest message returns empty string when no messages exist")
    public void testLongestMessageEmptyList() {
        PROG56121PART1.messages.clear();
        String result = PROG56121PART1.displayLongestMessage();
        assertEquals("", result, "Should return empty string when no messages exist");
    }


    //  TEST 3 — Search for Message ID
    //  Test Data: "0838884567"  →  Expected: "It is dinner time!"

    @Test
    @DisplayName("Search by developer number returns correct message")
    public void testSearchByDeveloperNumber() {
        String result = PROG56121PART1.searchByMessageIDLogic("0838884567");
        assertEquals("It is dinner time!", result,
                "Searching '0838884567' must return 'It is dinner time!'");
    }

    @Test
    @DisplayName("Search by message ID (0000000001) returns correct message")
    public void testSearchByMessageId() {
        String result = PROG56121PART1.searchByMessageIDLogic("0000000001");
        assertEquals("Did you get the cake?", result,
                "Searching ID '0000000001' must return 'Did you get the cake?'");
    }

    @Test
    @DisplayName("Search for unknown ID returns empty string")
    public void testSearchByMessageIdNotFound() {
        String result = PROG56121PART1.searchByMessageIDLogic("NOTEXISTS");
        assertEquals("", result, "Unknown ID must return empty string");
    }


    //  TEST 4 — Search All Messages for a Particular Recipient
    //  Test Data: +27838884567  →  Expected: messages 2 and 5

    @Test
    @DisplayName("Recipient search returns 2 results for +27838884567")
    public void testSearchByRecipientResultCount() {
        ArrayList<String> results =
                PROG56121PART1.searchByRecipientLogic("+27838884567");
        assertEquals(2, results.size(),
                "Recipient +27838884567 should have exactly 2 messages");
    }

    @Test
    @DisplayName("Recipient search returns correct message content")
    public void testSearchByRecipientContent() {
        ArrayList<String> results =
                PROG56121PART1.searchByRecipientLogic("+27838884567");
        assertTrue(results.contains(
                "Where are you? You are late! I have asked you to be on time."),
                "Message 2 must be in results");
        assertTrue(results.contains("Ok, I am leaving without you."),
                "Message 5 must be in results");
    }

    @Test
    @DisplayName("Unknown recipient returns empty result list")
    public void testSearchByRecipientNotFound() {
        ArrayList<String> results =
                PROG56121PART1.searchByRecipientLogic("+27000000000");
        assertTrue(results.isEmpty(), "Unknown recipient must return empty list");
    }


    //  TEST 5 — Delete a Message Using the Message Hash
    //  Test Data: Message 2 hash  →  deletion must succeed; arrays must shrink

    @Test
    @DisplayName("Delete by hash returns true for a valid hash")
    public void testDeleteByHashReturnsTrue() {
        String hash = getHashForContent(
                "Where are you? You are late! I have asked you to be on time.");
        assertNotNull(hash, "Message 2 hash must exist");
        assertTrue(PROG56121PART1.deleteByHashLogic(hash),
                "deleteByHashLogic must return true on success");
    }

    @Test
    @DisplayName("Delete by hash reduces messages list size by 1")
    public void testDeleteByHashReducesMessageCount() {
        String hash = getHashForContent(
                "Where are you? You are late! I have asked you to be on time.");
        int before = PROG56121PART1.messages.size();
        PROG56121PART1.deleteByHashLogic(hash);
        assertEquals(before - 1, PROG56121PART1.messages.size(),
                "messages list must shrink by 1 after deletion");
    }

    @Test
    @DisplayName("Delete by hash reduces storedMessages array by 1")
    public void testDeleteByHashReducesStoredArray() {
        String hash = getHashForContent(
                "Where are you? You are late! I have asked you to be on time.");
        int before = PROG56121PART1.storedMessages.size();
        PROG56121PART1.deleteByHashLogic(hash);
        assertEquals(before - 1, PROG56121PART1.storedMessages.size(),
                "storedMessages must shrink by 1 after deleting a Stored message");
    }

    @Test
    @DisplayName("Deleted message no longer appears in messages list")
    public void testDeletedMessageIsGone() {
        String hash = getHashForContent(
                "Where are you? You are late! I have asked you to be on time.");
        PROG56121PART1.deleteByHashLogic(hash);
        for (Message m : PROG56121PART1.messages) {
            assertNotEquals(
                "Where are you? You are late! I have asked you to be on time.",
                m.content, "Deleted message must not remain in the list");
        }
    }

    @Test
    @DisplayName("Delete by hash returns false for an unknown hash")
    public void testDeleteByHashReturnsFalse() {
        assertFalse(PROG56121PART1.deleteByHashLogic("BADHASH"),
                "deleteByHashLogic must return false for unknown hash");
    }

    @Test
    @DisplayName("Delete with unknown hash does not change message count")
    public void testDeleteByHashUnknownNoChange() {
        int before = PROG56121PART1.messages.size();
        PROG56121PART1.deleteByHashLogic("BADHASH");
        assertEquals(before, PROG56121PART1.messages.size(),
                "Message count must not change for unknown hash");
    }


    //  TEST 6 — Display Report (all arrays correctly populated)

    @Test
    @DisplayName("Report: total message count is 5")
    public void testReportTotalMessages() {
        assertEquals(5, PROG56121PART1.messages.size(),
                "Should be 5 messages total after setup");
    }

    @Test
    @DisplayName("Report: messageHashes array has 5 entries")
    public void testReportHashCount() {
        assertEquals(5, PROG56121PART1.messageHashes.size(),
                "Every message must have a corresponding hash");
    }

    @Test
    @DisplayName("Report: messageIDs array has 5 entries")
    public void testReportIDCount() {
        assertEquals(5, PROG56121PART1.messageIDs.size(),
                "Every message must have a corresponding ID");
    }

    @Test
    @DisplayName("Report: array distribution is 2 Sent, 2 Stored, 1 Disregarded")
    public void testReportArrayDistribution() {
        assertEquals(2, PROG56121PART1.sentMessages.size(),      "2 Sent");
        assertEquals(2, PROG56121PART1.storedMessages.size(),    "2 Stored");
        assertEquals(1, PROG56121PART1.disregardMessages.size(), "1 Disregarded");
    }

    @Test
    @DisplayName("Report: no message has null or empty hash/id/recipient/content")
    public void testReportNoNullFields() {
        for (Message m : PROG56121PART1.messages) {
            assertNotNull(m.id,        "ID must not be null");
            assertNotNull(m.hash,      "Hash must not be null");
            assertNotNull(m.recipient, "Recipient must not be null");
            assertNotNull(m.content,   "Content must not be null");
            assertFalse(m.id.isEmpty(),        "ID must not be empty");
            assertFalse(m.hash.isEmpty(),      "Hash must not be empty");
            assertFalse(m.recipient.isEmpty(), "Recipient must not be empty");
            assertFalse(m.content.isEmpty(),   "Content must not be empty");
        }
    }


    //  VALIDATION TESTS (Part 1 carry-over — support overall app marks)

    @Test
    @DisplayName("Valid SA number passes validateNumber")
    public void testValidateNumberValid() {
        assertEquals("Recipient number entered successfully",
                PROG56121PART1.validateNumber("+27834557896"));
    }

    @Test
    @DisplayName("Number without +27 fails validateNumber")
    public void testValidateNumberNoPrefix() {
        assertTrue(PROG56121PART1.validateNumber("0834557896").contains("incorrect"));
    }

    @Test
    @DisplayName("Too-short number fails validateNumber")
    public void testValidateNumberTooShort() {
        assertTrue(PROG56121PART1.validateNumber("+2783455").contains("incorrect"));
    }

    @Test
    @DisplayName("Valid username passes checkUserName")
    public void testCheckUserNameValid() {
        assertTrue(PROG56121PART1.checkUserName("Us_er"));
    }

    @Test
    @DisplayName("Username without underscore fails")
    public void testCheckUserNameNoUnderscore() {
        assertFalse(PROG56121PART1.checkUserName("UserA"));
    }

    @Test
    @DisplayName("Username over 5 chars fails")
    public void testCheckUserNameTooLong() {
        assertFalse(PROG56121PART1.checkUserName("User_Name"));
    }

    @Test
    @DisplayName("Valid password passes checkPasswordComplexity")
    public void testPasswordValid() {
        assertTrue(PROG56121PART1.checkPasswordComplexity("Password1!"));
    }

    @Test
    @DisplayName("Password without uppercase fails")
    public void testPasswordNoUppercase() {
        assertFalse(PROG56121PART1.checkPasswordComplexity("password1!"));
    }

    @Test
    @DisplayName("Password without digit fails")
    public void testPasswordNoDigit() {
        assertFalse(PROG56121PART1.checkPasswordComplexity("Password!!"));
    }

    @Test
    @DisplayName("Password without special character fails")
    public void testPasswordNoSpecial() {
        assertFalse(PROG56121PART1.checkPasswordComplexity("Password1A"));
    }

    @Test
    @DisplayName("Hash format starts with correct ID prefix and sequence number")
    public void testCreateMessageHashFormat() {
        String hash = PROG56121PART1.createMessageHash("0000000001", 0,
                "Did you get the cake?");
        assertTrue(hash.startsWith("00:0:"), "Hash must start with '00:0:'");
        assertTrue(hash.contains("DID"),     "Hash must contain first word (DID)");
        assertTrue(hash.contains("CAKE?"),   "Hash must contain last word (CAKE?)");
    }


    //  HELPER

    /** Returns the hash for a message with the given content, or null if not found. */
    private String getHashForContent(String content) {
        for (Message m : PROG56121PART1.messages) {
            if (m.content.equals(content)) return m.hash;
        }
        return null;
    }
}