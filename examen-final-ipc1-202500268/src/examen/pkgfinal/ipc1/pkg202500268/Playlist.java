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
            String marcadorActual = "";
            
            if(auxiliar == actual){
                marcadorActual = "<-- actual";
            }
            
            System.out.println(contador + ". " + auxiliar.getDato() + marcadorActual);
            
            auxiliar = auxiliar.getSiguiente();
            contador++;
        }

        System.out.println("Total de canciones: " + tamanio);
    }
    
    public Cancion siguiente() {
        if (actual == null) {
            System.out.println("No hay canción actual.");
            return null;
        }

        if (actual.getSiguiente() == null) {
            System.out.println("Ya estás en la última canción.");
            return null;
        }

        actual = actual.getSiguiente();
        actual.getDato().reproducir();

        return actual.getDato();
    }

    public Cancion anterior() {
        if (actual == null) {
            System.out.println("No hay canción actual.");
            return null;
        }

        if (actual.getAnterior() == null) {
            System.out.println("Ya estás en la primera canción.");
            return null;
        }

        actual = actual.getAnterior();
        actual.getDato().reproducir();

        return actual.getDato();
    }

    public Cancion eliminarActual() {
        if (actual == null) {
            System.out.println("No hay canción actual para eliminar.");
            return null;
        }

        Cancion cancionEliminada = actual.getDato();

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            actual = null;
        } else if (actual == cabeza) {
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
            actual = cabeza;
        } else if (actual == cola) {
            cola = cola.getAnterior();
            cola.setSiguiente(null);
            actual = cola;
        } else {
            NodoDoble nodoAnterior = actual.getAnterior();
            NodoDoble nodoSiguiente = actual.getSiguiente();

            nodoAnterior.setSiguiente(nodoSiguiente);
            nodoSiguiente.setAnterior(nodoAnterior);

            actual.setAnterior(null);
            actual.setSiguiente(null);

            actual = nodoSiguiente;
        }

        tamanio--;

        System.out.println("Canción eliminada: " + cancionEliminada);

        return cancionEliminada;
    }
    
}
