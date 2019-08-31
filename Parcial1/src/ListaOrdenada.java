/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 * @param <T>
 */
public class ListaOrdenada<T> extends Lista<T> {

    /**
     * Inserta un nodo de forma ordenada a la lista
     * @param unNodo nodo a insertar
     */
    @Override
    public void insertar(Nodo<T> unNodo) {
        Nodo<T> actual;
        Nodo<T> siguiente;

        // Si la lista está vacía, lo defino como primero
        if (this.esVacia()) {
           this.setPrimero(unNodo);
        }
        else {
            // Valido que no exista ya el nodo
            actual = this.getPrimero();
            siguiente = actual.getSiguiente();

            // Caso primer elemento ya es mayor
            if (actual.compareTo(unNodo.getEtiqueta()) > 0) {
                // Lo agrego primero a la lista
                unNodo.setSiguiente(actual);
            }
            // Caso de un sólo elemento y es menor
            else if (siguiente == null) {
                // Lo agrego como siguiente y último
                actual.setSiguiente(unNodo);
                unNodo.setSiguiente(null);
            }
            // Caso sólo dos elementos y estamos entre medio
            else if (actual.compareTo(unNodo.getEtiqueta()) < 0 && siguiente.compareTo(unNodo.getEtiqueta()) > 0) {
                actual.setSiguiente(unNodo);
                unNodo.setSiguiente(siguiente);
            }
            else {
                // Recorro la lista y voy comparando hasta encontrar un hueco o llegar al final
                while(actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                    siguiente = actual.getSiguiente();
                    // Llegué al final de la lista, lo inserto al final
                    if (siguiente == null) {
                        actual.setSiguiente(unNodo);
                        unNodo.setSiguiente(null);
                    }
                    // Si actual es menor y el siguiente es mayor, encontré un hueco
                    else if (actual.compareTo(unNodo.getEtiqueta()) < 0 && siguiente.compareTo(unNodo.getEtiqueta()) > 0) {
                        // Se inserta unNodo en el hueco encontrado y dejo de recorrer la lista
                        actual.setSiguiente(unNodo);
                        unNodo.setSiguiente(siguiente);
                        break;
                    }
                }
            }
        }
    }
}