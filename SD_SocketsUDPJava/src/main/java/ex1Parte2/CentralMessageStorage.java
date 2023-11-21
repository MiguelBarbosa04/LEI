/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1Parte2;

/**
 *
 * @author Miguel
 */
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
