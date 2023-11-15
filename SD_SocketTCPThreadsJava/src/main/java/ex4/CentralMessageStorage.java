package ex4;

import java.util.ArrayList;
import java.util.List;

public class CentralMessageStorage {
    private static final List<String> messages = new ArrayList<>();

    public static void storeMessage(String message) {
        messages.add(message);
    }

    public static List<String> getAllMessages() {
        return new ArrayList<>(messages);
    }
}
