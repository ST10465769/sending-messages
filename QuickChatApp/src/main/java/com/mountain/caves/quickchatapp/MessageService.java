package com.mountain.caves.quickchatapp;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MessageService {
    // List to store all sent messages
    private List<Message> messages = new ArrayList<>();

    /**
     * Adds a message to the list and displays a confirmation dialog.
     * @param message The Message object to be sent/stored.
     */
    public void sendMessage(Message message) {
        messages.add(message);
        // Show a pop-up dialog to confirm message was sent successfully
        JOptionPane.showMessageDialog(null,
                "Message sent successfully!\n\n" +
                "Sender: " + message.getSender() +
                "\nRecipient: " + message.getRecipient() +
                "\nMessage: " + message.getContent() +
                "\nHash: " + message.getHash());
    }

    /**
     * Returns the total number of messages sent.
     * @return The size of the messages list.
     */
    public int returnTotalMessages() {
        return messages.size();
    }

    /**
     * Retrieves the list of all messages sent.
     * @return List containing all Message objects.
     */
    public List<Message> getAllMessages() {
        return messages;
    }

    /**
     * Replaces the current list of messages with the provided list.
     * @param msgs New list of Message objects to set.
     */
    public void setMessages(List<Message> msgs) {
        this.messages = msgs;
    }

    /**
     * Simple validation method to check if the message string is not null or empty.
     * @param message The message string to validate.
     * @return True if message is not null and not empty after trimming; otherwise false.
     */
    public boolean isValidMessage(String message) {
        return message != null && !message.trim().isEmpty();
    }
}
