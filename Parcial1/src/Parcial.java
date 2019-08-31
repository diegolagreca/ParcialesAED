
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Parcial {

    /**
     * Constante posición del ID alumno
     */
    private static final int ID = 0;

    /**
     * Constante posición del nombre del alumno
     */
    private static final int NOMBRE = 1;

    /**
     * Constante separador de los campos
     */
    private static final String SEPARADOR = ",";

    public static void main(String[] args) throws IOException {
        BufferedReader lector;
        BufferedWriter escritor;
        String campos[];
        Facultad facu = new Facultad();

        Nodo<Alumno> nodoActual;

        // instanciar conjunto basico ingeniería...
        Conjunto<Alumno> basicoIng = new Conjunto<>();

        // cargar alumnos del curso BasicoIng desde el archivo “basico-ing.txt”
        lector = new BufferedReader(new FileReader("src/basico-ing.txt"));
        for (String linea = ""; (linea = lector.readLine()) != null;) {
            campos = linea.split(SEPARADOR);
            basicoIng.insertar(new Nodo<>(Integer.valueOf(campos[ID]), new Alumno(Integer.valueOf(campos[ID]), campos[NOMBRE])));
        }
        lector.close();

        // Verifico que estén todos en el output
        System.out.println("*** Alumnos Básico Ingeniería ***\n");

        facu.getListaOrdenadaPorNombre(basicoIng).imprimir();
        //basicoIng.imprimir();

        // instanciar conjunto básico empresarial...
        Conjunto<Alumno> basiscoEmp = new Conjunto<>();
        // cargar alumnos del curso basicoEmp desde el archivo “basico-emp.txt”
        lector = new BufferedReader(new FileReader("src/basico-emp.txt"));
        for (String linea = ""; (linea = lector.readLine()) != null; /**/) {
            campos = linea.split(SEPARADOR);
            basiscoEmp.insertar(new Nodo<>(Integer.valueOf(campos[ID]), new Alumno(Integer.valueOf(campos[ID]), campos[NOMBRE])));
        }
        lector.close();

        // Verifico que estén todos en el output
        System.out.println("\n*** Alumnos Básico Empresarial ***\n");
        facu.getListaOrdenadaPorNombre(basiscoEmp).imprimir();

        // basiscoEmp.imprimir();
        // generar el curso "integrador101" con los alumnos que están en condiciones de cursarlo  
        // guardar en un archivo "integrador101.txt"  - IDEALMENTE ordenados por código de alumno -
        Conjunto<Alumno> integrador101 = basicoIng.union(basiscoEmp);
        escritor = new BufferedWriter(new FileWriter("src/integrador101.txt"));
        nodoActual = integrador101.getPrimero();
        while (nodoActual != null) {
            escritor.write(nodoActual.getDato().getCodigo() + SEPARADOR + nodoActual.getDato().getNombre() + "\n");
            nodoActual = nodoActual.getSiguiente();
        }
        escritor.close();

        // generar el curso "exigente102" con los alumnos que están en condiciones de cursarlo 
        // guardar en un archivo "exigente102.txt" - IDEALMENTE ordenados por código de alumno -
        Conjunto<Alumno> exigente102 = basicoIng.interseccion(basiscoEmp);
        escritor = new BufferedWriter(new FileWriter("src/exigente102.txt"));
        nodoActual = exigente102.getPrimero();
        while (nodoActual != null) {
            escritor.write(nodoActual.getDato().getCodigo() + SEPARADOR + nodoActual.getDato().getNombre() + "\n");
            nodoActual = nodoActual.getSiguiente();
        }
        escritor.close();

        System.out.println("\n*** Alumnos Integrador 101 ***\n");

        integrador101.imprimir();

        System.out.println("\n*** Alumnos Exigente 102 ***\n");

        exigente102.quitarMayor();
        exigente102.quitarMenor();

        exigente102.imprimir();

    }

}
