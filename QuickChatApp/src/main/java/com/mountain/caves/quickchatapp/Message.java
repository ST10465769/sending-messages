package com.mountain.caves.quickchatapp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class Message {
    // Unique identifier for the message
    private String id;
    // Sender's identifier (e.g., user ID)
    private String sender;
    // Recipient's phone number (as a string)
    private String recipient;
    // Content of the message
    private String content;
    // SHA-256 hash of the message content for integrity verification
    private String hash;

    // Constructor initializes message fields and generates a unique ID and hash
    public Message(String sender, String recipient, String content) {
        // Generate a unique UUID as the message ID
        this.id = UUID.randomUUID().toString();
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        // Create hash of the message content immediately upon construction
        this.hash = createMessageHash();
    }

    // Getter for the message ID
    public String getId() {
        return id;
    }

    // Getter for the sender ID
    public String getSender() {
        return sender;
    }

    // Getter for the recipient cell number
    public String getRecipient() {
        return recipient;
    }

    // Getter for the message content
    public String getContent() {
        return content;
    }

    // Getter for the message hash
    public String getHash() {
        return hash;
    }

    // Validate that the message ID is not null or empty
    public boolean checkMessageID() {
        return id != null && !id.isEmpty();
    }

    // Validate the recipient cell number matches a digit-only string with length 10-15
    public boolean checkRecipientCell() {
        return recipient != null && recipient.matches("\\d{10,15}");
    }

    // Generate SHA-256 hash of the message content and store it as a hex string
    public String createMessageHash() {
        try {
            // Get SHA-256 MessageDigest instance
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Compute hash bytes from the content string
            byte[] hashBytes = digest.digest(content.getBytes());
            // Convert hash bytes to hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                // Convert byte to hex (2 hex digits)
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0'); // pad with leading zero if needed
                hexString.append(hex);
            }
            // Save and return the computed hash string
            this.hash = hexString.toString();
            return this.hash;
        } catch (NoSuchAlgorithmException e) {
            // RuntimeException thrown if SHA-256 algorithm is not available
            throw new RuntimeException("Error creating hash", e);
        }
    }
}
