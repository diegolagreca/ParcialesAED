/**
 *
 * @author ernesto
 */
public interface IOrdenar<E> {
    /**
     * Retorna lista ordenada
     * @return lista
     */
    public Lista<E> insercionDirecta();
    
    /**
     * Retorna lista ordenada
     * @return lista ordenada
     */
    public Lista<E> seleccionDirecta();
}
