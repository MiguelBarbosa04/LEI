/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parte2_ex5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class MediaLibrary<T> {

    private List<T> mediaList;

    public MediaLibrary() {
        mediaList = new ArrayList<>();
    }

    public void addMedia(T media) {
        mediaList.add(media);
    }

    public T getMedia(int index) {
        if (index >= 0 && index < mediaList.size()) {
            return mediaList.get(index);
        }
        return null; 
    }

    public List<T> getAllMedia() {
        return mediaList;
    }

    public int getTotalMediaCount() {
        return mediaList.size();
    }

    public static void main(String[] args) {
        // Criando uma biblioteca de mídia
        MediaLibrary<Book> bookLibrary = new MediaLibrary<>();
        MediaLibrary<Video> videoLibrary = new MediaLibrary<>();
        MediaLibrary<CD> musicLibrary = new MediaLibrary<>();

        // Adicionando itens à biblioteca de mídia
        bookLibrary.addMedia(new Book("Livro 1"));
        bookLibrary.addMedia(new Book("Livro 2"));

        videoLibrary.addMedia(new Video("Vídeo 1"));
        videoLibrary.addMedia(new Video("Vídeo 2"));

        musicLibrary.addMedia(new CD("CD 1"));
        musicLibrary.addMedia(new CD("CD 2"));

        // Obtendo informações da biblioteca de mídia
        System.out.println("Total de livros na biblioteca: " + bookLibrary.getTotalMediaCount());
        System.out.println("Total de vídeos na biblioteca: " + videoLibrary.getTotalMediaCount());
        System.out.println("Total de CDs de música na biblioteca: " + musicLibrary.getTotalMediaCount());
    }
}
