
public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(Nodo<T> unNodo) {
        if (esVacia()) {
            primero = unNodo;
        } else {
            Nodo<T> aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(unNodo);
        }
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            Nodo<T> aux = primero;
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        Nodo<T> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            Nodo<T> temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                Nodo<T> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            Nodo<T> temp = primero;
            while (temp != null) {
                temp.imprimir();
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } else {
            Nodo<T> temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;
    }

    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            INodo aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = unNodo;
    }

    public INodo quitarPrimero2() {
        INodo aux;
        INodo x = null;
        aux = getPrimero();
        if (!esVacia()) {
            x = getPrimero();
            eliminar((Comparable) aux);
        }
        return x;
    }

    public INodo quitarPrimero() {
        INodo<T> aux = this.getPrimero().clonar();
        setPrimero(getPrimero().getSiguiente());
        return aux;
    }

    public INodo<T> obtenerMayor() {
        INodo aux = getPrimero();
        INodo mayor = getPrimero();
        while (aux != null) {
            if (mayor.getEtiqueta().compareTo(aux.getEtiqueta()) < 1) {
                mayor = aux;
            }
            aux = aux.getSiguiente();
        }
        return mayor;
    }

    public INodo<T> obtenerMenor() {
        INodo aux = getPrimero();
        INodo menor = getPrimero();
        while (aux != null) {
            if (menor.getEtiqueta().compareTo(aux.getEtiqueta()) > 1) {
                menor = aux;
            }
            aux = aux.getSiguiente();
        }
        return menor;
    }

    public void quitarMenor2() {
        INodo menor = obtenerMenor();
        eliminar(menor.getEtiqueta());
    }

    public Nodo<T> quitarMenor() {
        Nodo<T> anterior, actual, menor, auxMenor;

        if (this.esVacia()) {
            return null;
        }

        actual = this.getPrimero();
        menor = this.getPrimero();
        anterior = null;
        auxMenor = null;

        while (actual != null) {
            if (actual.compareTo(menor.getEtiqueta()) < 0) {
                menor = actual;
                auxMenor = anterior;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }

        if (auxMenor == null) {
            this.setPrimero(menor.getSiguiente());
        } else {
            auxMenor.setSiguiente(menor.getSiguiente());
        }
        menor.setSiguiente(null);

        // Retorno nodo menor
        return menor;
    }

    public void quitarMayor() {
        INodo mayor = obtenerMayor();
        eliminar(mayor.getEtiqueta());
    }

    public Lista insercionDirecta() {
        Lista<T> nuevaLista = new Lista<T>();
        INodo<T> aux;
        aux = getPrimero();
        if (aux == null) {
            return nuevaLista;
        }
        while (aux != null) {
            INodo<T> x = quitarPrimero();
            nuevaLista.insertarOrdenado((Nodo<T>) x);
            aux = aux.getSiguiente();
        }
        return nuevaLista;
    }

    public Lista<T> seleccionDirecta() {
        ListaOrdenada<T> nuevaLista;

        nuevaLista = new ListaOrdenada<>();

        if (this.esVacia()) {
            return nuevaLista;
        }

        while (!this.esVacia()) {
            nuevaLista.insertar(this.quitarMenor().clonar());
        }

        return nuevaLista;
    }

    public void insertarOrdenado(Nodo<T> nodo) {
        Nodo<T> actual;
        Nodo<T> siguiente;

        // Si la lista está vacía, lo defino como primero
        if (this.esVacia()) {
            setPrimero(nodo);
        } else {
            // Valido que no exista ya el nodo
            if (this.buscar(nodo.getEtiqueta()) == null) {
                actual = this.getPrimero();
                siguiente = actual.getSiguiente();

                // Caso primer elemento ya es mayor
                if (actual.compareTo(nodo.getEtiqueta()) > 0) {
                    // Lo agrego primero a la lista
                    nodo.setSiguiente(actual);
                    this.primero = nodo;
                } // Caso de un sólo elemento y es menor
                else if (siguiente == null) {
                    // Lo agrego como siguiente y último
                    actual.setSiguiente(nodo);
                    nodo.setSiguiente(null);
                } // Caso sólo dos elementos y estamos entre medio
                else if (actual.compareTo(nodo.getEtiqueta()) < 0 && siguiente.compareTo(nodo.getEtiqueta()) > 0) {
                    actual.setSiguiente(nodo);
                    nodo.setSiguiente(siguiente);
                } else {
                    // Recorro la lista y voy comparando hasta encontrar un hueco o llegar al final
                    while (actual.getSiguiente() != null) {
                        actual = actual.getSiguiente();
                        siguiente = actual.getSiguiente();
                        // Llegué al final de la lista, lo inserto al final
                        if (siguiente == null) {
                            actual.setSiguiente(nodo);
                            nodo.setSiguiente(null);
                            break;
                        } // Si actual es menor y el siguiente es mayor, encontré un hueco
                        else if (actual.compareTo(nodo.getEtiqueta()) < 0 && siguiente.compareTo(nodo.getEtiqueta()) > 0) {
                            // Se inserta nodo en el hueco encontrado y dejo de recorrer la lista
                            actual.setSiguiente(nodo);
                            nodo.setSiguiente(siguiente);
                            break;
                        }
                    }
                }
            }
        }
    }

}
