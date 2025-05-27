package com.mountain.caves.quickchatapp;

public class Main {
    public static void main(String[] args) {
        // Instantiate the MessageService which handles sending messages
        MessageService service = new MessageService();

        // Create a new message object with sender ID, recipient cell number, and message content
        Message msg = new Message("senderID123", "0123456789", "Hello World");

        // Check if the message ID and recipient cell number are valid before sending
        if (msg.checkMessageID() && msg.checkRecipientCell()) {
            // Optionally create a message hash (if not already created in constructor)
            msg.createMessageHash();

            // Send the message using the service
            service.sendMessage(msg);
        } else {
            // Print error if message ID or recipient cell number is invalid
            System.out.println("Invalid message ID or recipient cell number.");
        }

        // Output the total number of messages sent so far
        System.out.println("Total messages sent: " + service.returnTotalMessages());
    }
}
