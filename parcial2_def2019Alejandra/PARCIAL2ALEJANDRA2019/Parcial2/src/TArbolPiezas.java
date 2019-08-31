
import java.util.LinkedList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernesto
 */
public class TArbolPiezas extends TArbolBB<Pieza> implements IArbolPiezas {

   

    @Override
    public TArbolPiezas piezasPorRubro(String unRubro) {
      Lista <Pieza> listapiezas = new Lista<>();
          if (this.getRaiz() != null) {
            this.getRaiz().inOrden(listapiezas);
        }
        TArbolPiezas arbolpieza = new TArbolPiezas();
        if(!listapiezas.esVacia()){
            Nodo <Pieza> nodoActual = listapiezas.getPrimero();
            while( nodoActual.getSiguiente()!= null)
            {
                if( nodoActual.getDato().obtenerRubro().equals(unRubro)){
                    arbolpieza.insertar(new TElementoAB(nodoActual.getDato().getCodigoCatalogo(), nodoActual.getDato()));

                }
               nodoActual = nodoActual.getSiguiente();
            }
        }
        return arbolpieza;
    }       
    
    

   

    @Override
    public int[] cantYvalorStock() {
        Nodo<Pieza> nodo = this.inorden().getPrimero();
        int monto = 0;
        int cant;
        int montoSolo;
        Pieza piezza = nodo.getDato();
        int [] resultado = new int [2];
        while (nodo != null){
            piezza = nodo.getDato();
            cant = 0;
            montoSolo=0;
            if(piezza!=null){
                cant=piezza.getCantidad();
                montoSolo=piezza.getPrecioUnitario();
            }
            //monto += nodo.getDato().getPrecioUnitario();
            resultado[0] += cant;
            resultado[1] += cant * montoSolo;
            nodo = nodo.getSiguiente();
        }
        return resultado;
    }
}
