/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class Facultad {

    public Lista<Alumno> getListaOrdenadaPorNombre(Lista<Alumno> listaAlumnos) {
        Lista<Alumno> listaOrdenada;
        Nodo<Alumno> actual;
        Alumno alumnoActual;

        // Si la lista de productos está vacía, no imprimo.
        if (listaAlumnos.esVacia()) {
            return null;
        }
        // Debo recorrer manualmente la lista de nodos 
        actual = listaAlumnos.getPrimero();
        alumnoActual = actual.getDato();

        // Creo lista ordenada y agrego el primero
        listaOrdenada = new Lista();
        listaOrdenada.insertarOrdenado(new Nodo<>(alumnoActual.getNombre(), alumnoActual));
        // Recorro cada elemento y voy agregando de forma ordenada cada uno
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
            alumnoActual = actual.getDato();
            listaOrdenada.insertarOrdenado(new Nodo<>(alumnoActual.getNombre(), alumnoActual));
        }
        // Imprimo la lista con saltos de línea
        
        //System.out.print(listaOrdenada.imprimir("\n"));
        
        return listaOrdenada;
    }

        public Lista<Alumno> getListaOrdenadaPorCodigo(Lista<Alumno> listaAlumnos) {
        Lista<Alumno> listaOrdenada;
        Nodo<Alumno> actual;
        Alumno alumnoActual;

        // Si la lista de productos está vacía, no imprimo.
        if (listaAlumnos.esVacia()) {
            return null;
        }
        // Debo recorrer manualmente la lista de nodos 
        actual = listaAlumnos.getPrimero();
        alumnoActual = actual.getDato();

        // Creo lista ordenada y agrego el primero
        listaOrdenada = new Lista();
        listaOrdenada.insertarOrdenado(new Nodo<>(alumnoActual.getCodigo(), alumnoActual));
        // Recorro cada elemento y voy agregando de forma ordenada cada uno
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
            alumnoActual = actual.getDato();
            listaOrdenada.insertarOrdenado(new Nodo<>(alumnoActual.getCodigo(), alumnoActual));
        }
        // Imprimo la lista con saltos de línea
        
        //System.out.print(listaOrdenada.imprimir("\n"));
        
        return listaOrdenada;
    }
}
