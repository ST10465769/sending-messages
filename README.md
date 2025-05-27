# sending-messages

Here's your README content in proper Markdown format:

```markdown
# QuickChatApp

QuickChatApp is a simple Java-based messaging application that allows users to create, validate, hash, send, and persist messages. The app leverages JSON for data storage and uses basic GUI dialogs to provide user feedback.

## Features

- Create messages with sender, recipient, and content.
- Validate message ID and recipient phone number format.
- Generate SHA-256 hash of message content for integrity.
- Send messages and show confirmation dialogs.
- Store and retrieve messages from a JSON file.
- Simple message validation utilities.

## Technologies Used

- Java 8+
- Gson library for JSON serialization/deserialization
- Swing for simple GUI dialogs
- SHA-256 for message content hashing

## Project Structure

```

com.mountain.caves.quickchatapp
│
├── Main.java           # Main application entry point
├── Message.java        # Message model with validation and hashing
├── MessageService.java # Service class for managing messages
├── JsonHelper.java     # Helper class for JSON conversion
├── StorageUtil.java    # Utility for saving/loading messages to/from JSON file

````

## How to Run

1. Clone or download the project source.
2. Ensure you have Java 8 or higher installed.
3. Compile the project classes.
4. Run `Main` class to start the application.

```bash
javac com/mountain/caves/quickchatapp/*.java
java com.mountain.caves.quickchatapp.Main
````

## Usage

* The app creates a sample message inside `Main`.
* It validates the message ID and recipient phone number.
* If valid, it generates a hash for the message content and sends the message.
* A confirmation dialog will display the message details.
* The total count of sent messages is printed in the console.

## Saving and Loading Messages

* Messages are automatically saved in JSON format to `messages.json` file.
* Use `StorageUtil.saveMessages(List<Message>)` and `StorageUtil.loadMessages()` to persist and retrieve messages.

## Notes

* Recipient phone numbers must be between 10 to 15 digits.
* Hash is created using SHA-256 for message content security.
* GUI dialogs use Swing's `JOptionPane` for simple user interaction.

## Dependencies

* [Gson](https://github.com/google/gson) - JSON serialization/deserialization library

Add Gson to your project classpath before compiling/running.

## License

This project is open source and free to use.
