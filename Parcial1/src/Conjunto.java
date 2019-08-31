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
public class Conjunto<T> extends ListaOrdenada<T> implements IConjunto {
    
    /**
     * Retorna la unión de dos conjuntos
     * @param otroConjunto conjunto a unir
     * @return conjunto unión
     */
    @Override
    public Conjunto union(Conjunto otroConjunto) {
        Conjunto<T> conjuntoUnion;
        Nodo<T> actual;
        
        // Nuevo conjunto vacío
        conjuntoUnion = new Conjunto<>();
        
        // Si están vacíos retorno conjunto vacío
        if (this.esVacia() && otroConjunto.esVacia())
            return conjuntoUnion;

        // Recorro este conjunto y voy agregando
        actual = this.getPrimero();
        // Recorro cada elemento y agrego
        while(actual != null) {
            conjuntoUnion.insertar(actual.clonar());
            actual = actual.getSiguiente();
        }
        
        // Recorro el segundo conjunto y agrego si ya no existe en conjunto union
        actual = otroConjunto.getPrimero();
        // Recorro cada elemento y agrego
        while(actual != null) {
            if (conjuntoUnion.buscar(actual.getEtiqueta()) == null)
                conjuntoUnion.insertar(actual.clonar());
            actual = actual.getSiguiente();
        }
        
        return conjuntoUnion;
    }

    /**
     * Retorna la intersección de dos conjuntos
     * @param otroConjunto conjunto a intersectar
     * @return conjunto intersección
     */
    @Override
    public Conjunto interseccion(Conjunto otroConjunto) {
        Conjunto<T> interseccion;
        Nodo<T> actual;
        
        // Nuevo conjunto vacío
        interseccion = new Conjunto<>();
        
        // Si están vacíos retorno conjunto vacío
        if (this.esVacia() && otroConjunto.esVacia())
            return interseccion;

        // Recorro este conjunto y busco en segundo
        actual = this.getPrimero();
        // Recorro cada elemento y agrego si existe en segundo
        while(actual != null) {
            if (otroConjunto.buscar(actual.getEtiqueta()) != null)
                interseccion.insertar(actual.clonar());
            actual = actual.getSiguiente();
        }
        
        return interseccion;
    }

    
}