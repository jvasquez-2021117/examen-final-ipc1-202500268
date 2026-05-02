/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen.pkgfinal.ipc1.pkg202500268;

/**
 *
 * @author vqzjo
 */
public class Playlist {
    
    private NodoDoble cabeza;
    private NodoDoble cola;
    private NodoDoble actual;
    private int tamanio;

    public Playlist() {
        this.cabeza = null;
        this.cola = null;
        this.actual = null;
        this.tamanio = 0;
    }

    public NodoDoble getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDoble cabeza) {
        this.cabeza = cabeza;
    }

    public NodoDoble getCola() {
        return cola;
    }

    public void setCola(NodoDoble cola) {
        this.cola = cola;
    }

    public NodoDoble getActual() {
        return actual;
    }

    public void setActual(NodoDoble actual) {
        this.actual = actual;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public void agregarCancion(Cancion cancion) {
        NodoDoble nuevoNodo = new NodoDoble(cancion);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            actual = nuevoNodo;
        } else {
            cola.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(cola);
            cola = nuevoNodo;
        }

        tamanio++;
    }

    public void mostrarPlaylist() {
        if (cabeza == null) {
            System.out.println("La playlist está vacía.");
            return;
        }

        NodoDoble auxiliar = cabeza;
        int contador = 1;

        System.out.println("=== PLAYLIST ===");

        while (auxiliar != null) {
            System.out.println(contador + ". " + auxiliar.getDato());
            auxiliar = auxiliar.getSiguiente();
            contador++;
        }

        System.out.println("Total de canciones: " + tamanio);
    }
    
}
