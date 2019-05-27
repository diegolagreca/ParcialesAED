
import java.util.LinkedList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TArbolBBU ucu = new TArbolBBU();
        // cargar los alumnos en el árbol "ucu" desde el archivo de datos "datos.csv"
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/datos.csv");

        for (String datosAlumno : lineas) {
            String[] alumno = datosAlumno.split(",");
            Alumno nuevoAlumno = new Alumno(Integer.parseInt(alumno[0]), alumno[1], alumno[2]);
            ucu.insertar(new TNodoAlumnoAB(nuevoAlumno.getCodigo(), nuevoAlumno));
        }

        String listaAlumnos = ucu.inOrden();
        // System.out.println(listaAlumnos);

        TArbolBBU ucuInformatica = ucu.armarIndiceCarrera("Ing. Informática");
        String listaAlumnosInformatica = ucuInformatica.inOrden();
       // System.out.println(listaAlumnosInformatica);

        TArbolBBU uku = new TArbolBBU();

        uku.insertar(new TNodoAlumnoAB(10, new Alumno(10, "abc", "cls")));
        uku.insertar(new TNodoAlumnoAB(5, new Alumno(5, "asc", "cls")));
        uku.insertar(new TNodoAlumnoAB(2, new Alumno(2, "aaa", "cls")));
        uku.insertar(new TNodoAlumnoAB(15, new Alumno(15, "agf", "cls")));
        uku.insertar(new TNodoAlumnoAB(19, new Alumno(19, "aac", "cls")));
        uku.insertar(new TNodoAlumnoAB(14, new Alumno(14, "acc", "cls")));
        uku.insertar(new TNodoAlumnoAB(11, new Alumno(11, "azc", "cls")));

        TArbolBBU arbolPrueba = new TArbolBBU();
        arbolPrueba.insertar(new TNodoAlumnoAB(7, new Alumno(4, "4", "Informática")));
        arbolPrueba.insertar(new TNodoAlumnoAB(2, new Alumno(5, "5", "Informática")));
        arbolPrueba.insertar(new TNodoAlumnoAB(15, new Alumno(0, "", "Informática")));
        arbolPrueba.insertar(new TNodoAlumnoAB(1, new Alumno(4, "4", "Informática")));
        arbolPrueba.insertar(new TNodoAlumnoAB(4, new Alumno(3, "3", "Informática")));
        arbolPrueba.insertar(new TNodoAlumnoAB(3, new Alumno(1, "1", "Informática")));
        arbolPrueba.insertar(new TNodoAlumnoAB(10, new Alumno(3, "3", "Informática")));
        arbolPrueba.insertar(new TNodoAlumnoAB(8, new Alumno(24, "24", "Informática")));
        arbolPrueba.insertar(new TNodoAlumnoAB(19, new Alumno(19, "", "Informática")));
        arbolPrueba.insertar(new TNodoAlumnoAB(12, new Alumno(9, "9", "Informática")));

        /*
        String a = arbolPrueba.mayorValor(3, 8);
        String b = arbolPrueba.mayorValor(1, 3);
        String c = arbolPrueba.mayorValor(19, 55);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
         */
        Comparable resultado1 = arbolPrueba.mayorValor(3, 8);
        Comparable resultado2 = arbolPrueba.mayorValor(1, 3);
//        Comparable resultado3 = arbolPrueba.mayorValor(19, 55);

        //System.out.println(arbolPrueba.inOrden());
        System.out.println("Mayor valor entre 3 y 8: " + resultado1);
        System.out.println("Mayor valor entre 1 y 3: " + resultado2);

        /* 
        TArbolBBU porCarrera = ucu.armarIndiceCarrera(laCarrera);
        
        String xCarrera = porCarrera.inOrden();
        String [] salida = xCarrera.split("-");
        ManejadorArchivosGenerico.escribirArchivo("src/salida.txt",salida);*/
        // escribir en el archivo "salida.txt" el listado emitido de los alumnos
        // de la carrera indicada, en orden alfabético ascendente
    }
}
