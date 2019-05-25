
import java.util.LinkedList;

public class TArbolBBU implements IArbolBBU {

    private  TNodoAlumnoAB raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBBU() {
        raiz = null;
    }

   
    /**
     * @param unaEtiqueta
     * @return
     */
   
    @Override
    public TNodoAlumnoAB buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    /**
     * @return recorrida en inorden del arbol, null en caso de ser vacío
     */
    @Override
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }

    public boolean esVacio() {
        return (raiz == null);
    }

    @Override
    public LinkedList<Comparable> inorden() {
        LinkedList<Comparable> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new LinkedList<>();
            raiz.inOrden(listaInorden);
        }
        return listaInorden;

    }

    /**
     *
     * @return
     */
    public TNodoAlumnoAB getraiz() {
        return this.raiz;
    }

    @Override
    public boolean insertar(TNodoAlumnoAB unElemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TArbolBBU armarIndiceCarrera(Comparable laCarrera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
