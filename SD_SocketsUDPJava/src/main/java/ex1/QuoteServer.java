/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author migue
 */
import java.io.IOException;

public class QuoteServer {

    public static void main(String[] args) throws IOException {
        new QuoteServerThread().start();
    }
}
