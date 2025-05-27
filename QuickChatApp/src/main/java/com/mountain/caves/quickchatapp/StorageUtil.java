package com.mountain.caves.quickchatapp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.List;

class StorageUtil {
    // Path to the JSON file where messages will be saved and loaded from
    private static final String FILE_PATH = "messages.json";

    /**
     * Saves a list of Message objects to a JSON file.
     * Uses Gson to convert the list to JSON format and writes it to the specified file.
     *
     * @param messages List of Message objects to be saved.
     */
    public static void saveMessages(List<Message> messages) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            // Convert list of messages to JSON and write to file
            new Gson().toJson(messages, writer);
        } catch (IOException e) {
            // Print stack trace if saving fails
            e.printStackTrace();
        }
    }

    /**
     * Loads a list of Message objects from the JSON file.
     * Uses Gson to read and parse the JSON back into a List<Message>.
     *
     * @return List of Message objects loaded from file, or null if an error occurs.
     */
    public static List<Message> loadMessages() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            // Read JSON from file and convert it to List<Message> using TypeToken
            return new Gson().fromJson(reader, new TypeToken<List<Message>>() {}.getType());
        } catch (IOException e) {
            // Return null if loading fails (e.g., file not found)
            return null;
        }
    }
}
