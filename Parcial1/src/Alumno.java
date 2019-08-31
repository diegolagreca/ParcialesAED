/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 */
public class Alumno {
    private final int codigo;
    private final String nombre;

    public Alumno(int codigo, String Nombre) {
        this.codigo = codigo;
        this.nombre = Nombre;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public String toString(){
        return "Alumno de código " + codigo + " y nombre " + nombre;
    }
    
}
