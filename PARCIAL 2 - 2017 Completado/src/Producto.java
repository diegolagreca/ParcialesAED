/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class Producto {

    private final int codigo;
    private final int valor;

    public Producto(int codigo, int valor) {

        this.codigo = codigo;
        this.valor = valor;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public int getValor() {
        return this.valor;
    }

    public String imprimir() {
        return ("Código: " + this.codigo + ", Valor: " + this.valor);

    }
}
