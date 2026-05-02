/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen.pkgfinal.ipc1.pkg202500268;

/**
 *
 * @author vqzjo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Cancion cancion1 = new Cancion("Blinding Lights", 200, "The Weeknd");
        Cancion cancion2 = new Cancion("Viva La Vida", 242, "Coldplay");
        Cancion cancion3 = new Cancion("Bohemian Rhapsody", 354, "Queen");

        Playlist playlist = new Playlist();

        playlist.agregarCancion(cancion1);
        playlist.agregarCancion(cancion2);
        playlist.agregarCancion(cancion3);

        System.out.println("=== LISTA INICIAL ===");
        playlist.mostrarPlaylist();

        System.out.println();
        System.out.println("=== SIGUIENTE ===");
        playlist.siguiente();

        System.out.println();
        System.out.println("=== SIGUIENTE ===");
        playlist.siguiente();

        System.out.println();
        System.out.println("=== ANTERIOR ===");
        playlist.anterior();

        System.out.println();
        System.out.println("=== ELIMINAR ACTUAL ===");
        playlist.eliminarActual();

        System.out.println();
        System.out.println("=== LISTA FINAL ===");
        playlist.mostrarPlaylist();
    }
    
}
