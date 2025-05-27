package com.mountain.caves.quickchatapp;

// Import the Gson library for JSON serialization
import com.google.gson.Gson;

/**
 * Utility class to help with JSON conversion.
 */
public class JsonHelper {

    /**
     * Converts a given Java object into its JSON string representation.
     *
     * @param obj The Java object to be converted to JSON.
     * @return A JSON formatted string representing the object.
     */
    public static String toJson(Object obj) {
        // Create a new Gson instance
        Gson gson = new Gson();

        // Convert the object to JSON string and return it
        return gson.toJson(obj);
    }
}
