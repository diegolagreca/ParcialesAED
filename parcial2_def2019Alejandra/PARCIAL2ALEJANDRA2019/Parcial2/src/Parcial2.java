
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;


public class Parcial2 {

    public static void main(String[] args) throws IOException {

        /**
         *
         * LEER ATENTAMENTE LAS INDICACIONES.
         *
         * Paso 1:
         *
         * 1.1 - instanciar un árbol de piezas (desciende de árbol binario de
         * búsqueda)
         *
         * 1.2 - cargar las piezas del archivo "piezas.txt" e insertarlas en el
         * árbol
         *
         */
        /**
         * Paso 2:
         *
         * 2.1 - Invocar al método “cantYvalorStock” del árbol y mostrar por
         * pantalla los valores de cantidad total de piezas existentes y valor
         * total del stock.
         *
         */
        /**
         * Paso 3:
         *
         * guardar un archivo "deposito.txt" conteniendo el listado - ordenado
         * ascendentemente por código de pieza - de todas las piezas del stock.
         * en cada línea debe aparecer: CODIGO, VALOR MONETARIO de la pieza en
         * stock - cantidad * precio
         *
         */
        /**
         * Paso 4:
         *
         * crear un nuevo arbol de piezas que contenga solamente las piezas del
         * rubro indicado en el pizarron, y luego emitir un archivo
         * "porRubro.txt" conteniendo el listado - ordenado ascendentemente por
         * código de pieza - de todas las piezas contenidas en este árbol, con
         * el mismo formato que el archivo "deposito.txt"
         *
         */
        /* por último, imprimir por consola la cantidad de piezas y el valor de stock
        de las piezas del rubro indicado
         */
        TArbolPiezas arbol = new TArbolPiezas();
        String[] lineasPiezas = obtenerLineas("src/piezas.txt");
      
        Pieza pieza;
        for (String l : lineasPiezas) {
            String[] datos = l.split(",");
            pieza = new Pieza(datos[0], datos[1], datos[2], Integer.valueOf(datos[3]),Integer.valueOf(datos[4]));
            TElementoAB<Pieza> nuevoNodo = new TElementoAB<>(pieza.getCodigoPieza(), pieza);
            arbol.insertar(nuevoNodo);
            //System.out.println(nuevoNodo.imprimir());
        }
        int[] result0 = arbol.cantYvalorStock();
        System.out.println("Arbol original - Cantidad: "+result0[0]+" / Monto: "+result0[1]);
        String[] lineaspie0 = new String[arbol.obtenerTamanio()-1];
        int x = 0;
         Lista listArbol = arbol.inorden();
         Nodo primero0 = listArbol.getPrimero();
         while( primero0.getSiguiente()!= null)
        {
           Pieza piezaa = (Pieza) primero0.getDato();
           lineaspie0[x] = piezaa.imprimir();
           x++;
           primero0 = primero0.getSiguiente();
        }
         //System.out.println("Cantidad: "+result[0]+" / Monto: "+result[1]);
        escribirArchivo("src/deposito.txt", lineaspie0);
        
        TArbolPiezas piezasRubro = arbol.piezasPorRubro("10");
        // ESCRIBIR EN ARCHIVO ALFABETICAMENTE X NOMBRE ( ES EL DATO CON EL CUAL SE CARGO EL ARBOL EN OBTENER DIRECTORIO)
        
        
        
        /*
        Nodo nodoactual = listapiezas.getPrimero();
        while(nodoactual.getSiguiente() != null){
            
        }
        */
        String[] lineaspie = new String[piezasRubro.obtenerTamanio()-1];
        int[] result = piezasRubro.cantYvalorStock();
        System.out.println("Arbol Piezas- Cantidad: "+result[0]+" / Monto: "+result[1]);
        int i = 0;
         Lista list = piezasRubro.inorden();
         Nodo primero = list.getPrimero();
         while( primero.getSiguiente()!= null)
        {
           Pieza piezaa = (Pieza) primero.getDato();
           lineaspie[i] = piezaa.imprimir();
           i++;
           primero = primero.getSiguiente();
        }
         //System.out.println("Cantidad: "+result[0]+" / Monto: "+result[1]);
        escribirArchivo("src/porrubro.txt", lineaspie);

      
        
        
        
    }
    public static void escribirArchivo(String nombreCompletoArchivo,
			String[] listaLineasArchivo) {
		FileWriter fw;
		try {
			fw = new FileWriter(nombreCompletoArchivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < listaLineasArchivo.length; i++) {
				String lineaActual = listaLineasArchivo[i];
				bw.write(lineaActual);
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Error al escribir el archivo "
					+ nombreCompletoArchivo);
			e.printStackTrace();
		}
	}

	public static int cantLineas(String archivo) throws FileNotFoundException, IOException{
        
        File file = new File (archivo); 
        FileReader fr = new FileReader (file); 
        BufferedReader br = new BufferedReader (fr);
        
        int contador = 0;
        String linea = br.readLine(); 
        while (linea != null){  
            contador += 1; 
            linea = br.readLine(); 
        } 
        
        fr.close();
        
        return contador;
        
    }
    public static String[] obtenerLineas(String archivo) throws FileNotFoundException, IOException{
        
        int contador = cantLineas(archivo);
        
        String[] lineaActual = new String[contador];
       
        
        File file2 = new File (archivo); 
        FileReader fr2 = new FileReader (file2); 
        BufferedReader br2 = new BufferedReader (fr2); 
        
        String linea2 = br2.readLine(); 
        for(int i = 0; i < contador; i++){
            lineaActual[i] = linea2; 
            linea2 = br2.readLine(); 
        } 
        
        return lineaActual;
 
    }
}
