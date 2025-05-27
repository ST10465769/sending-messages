package com.mountain.caves.quickchatapp;

import com.google.gson.Gson;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.UUID;

public class TestSuite {

    @Test
    public void testMessageCreation() {
        // Correct constructor args: sender, recipient, content
        Message message = new Message("Alice", "0123456789", "Hello");
        assertEquals("Alice", message.getSender());
        assertEquals("Hello", message.getContent());
    }

    @Test
    public void testMessageValidation() {
        MessageService service = new MessageService();
        assertTrue(service.isValidMessage("Hello World"));
        assertFalse(service.isValidMessage(""));
        assertFalse(service.isValidMessage("   "));
        assertFalse(service.isValidMessage(null));
    }

    @Test
    public void testHashGeneration() {
        Message message1 = new Message("Bob", "0123456789", "Test");
        Message message2 = new Message("Bob", "9876543210", "Test");
        assertNotNull(message1.getId());
        assertNotNull(message2.getId());
        assertNotEquals(message1.getId(), message2.getId());
    }

    @Test
    public void testJsonSerialization() {
        Message message = new Message("Eve", "0123456789", "Secret");
        String json = JsonHelper.toJson(message);
        assertTrue(json.contains("Eve"));
        assertTrue(json.contains("Secret"));
    }
}
