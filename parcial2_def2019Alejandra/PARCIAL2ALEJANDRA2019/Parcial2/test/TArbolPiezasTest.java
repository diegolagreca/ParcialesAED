/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.oracle.nio.BufferSecrets.instance;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gianluca
 */
public class TArbolPiezasTest {
    
    public TArbolPiezasTest() {
    }

    /**
     * Test of piezasPorRubro method, of class TArbolPiezas.
     */
    @Test
    public void testPiezasPorRubro() {
    }

    /**
     * Test of cantYvalorStock method, of class TArbolPiezas.
     */
    @Test
    public void testCantYvalorStock1() {
        System.out.println("cantYvalorStock");
        Pieza pieza1 = new Pieza("1111", "11.11.11", "uno", 1, 1);
        Pieza pieza2 = new Pieza("2222", "22.22.22", "uno", 2, 2);
        Pieza pieza3 = new Pieza("3333", "33.33.33", "uno", 3, 3);
        Pieza pieza4 = new Pieza("4444", "44.44.44", "uno", 4, 4);
        Pieza pieza5 = new Pieza("5555", "55.55.55", "uno", 5, 5);
        TElementoAB nodo1= new TElementoAB("1111", pieza1);
        TElementoAB nodo2= new TElementoAB("2222", pieza2);
        TElementoAB nodo3= new TElementoAB("3333", pieza3);
        TElementoAB nodo4= new TElementoAB("4444", pieza4);
        TElementoAB nodo5= new TElementoAB("5555", pieza5);
        TArbolPiezas arbolCantYvalor = new TArbolPiezas();
        arbolCantYvalor.insertar(nodo1);
        arbolCantYvalor.insertar(nodo2);
        arbolCantYvalor.insertar(nodo3);
        arbolCantYvalor.insertar(nodo4);
        arbolCantYvalor.insertar(nodo5);
        int[] expResult = {15,55};
        int[] result = new int[2];        
        
        result = arbolCantYvalor.cantYvalorStock();
                
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
     @Test
    public void testCantYvalorStock2() {
        System.out.println("cantYvalorStock");
        Pieza pieza1 = new Pieza("1111", "11.11.11", "uno", 1, 1);
        Pieza pieza2 = new Pieza("2222", "22.22.22", "uno", 2, 2);
        Pieza pieza3 = new Pieza("3333", "33.33.33", "uno", 3, 3);
        Pieza pieza4 = new Pieza("4444", "44.44.44", "uno", 5, 5);
        Pieza pieza5 = new Pieza("5555", "55.55.55", "uno", 5, 5);
        TElementoAB nodo4= new TElementoAB("1111", pieza1);
        TElementoAB nodo5= new TElementoAB("2222", pieza2);
        TElementoAB nodo3= new TElementoAB("3333", pieza3);
        TElementoAB nodo1= new TElementoAB("4444", pieza4);
        TElementoAB nodo2= new TElementoAB("5555", pieza5);
        TArbolPiezas arbolCantYvalor = new TArbolPiezas();
        arbolCantYvalor.insertar(nodo1);
        arbolCantYvalor.insertar(nodo2);
        arbolCantYvalor.insertar(nodo3);
        arbolCantYvalor.insertar(nodo4);
        arbolCantYvalor.insertar(nodo5);
               
        
        int[] expResult = {16,64};
        int[] result = new int[2];        
        
        result = arbolCantYvalor.cantYvalorStock();
                
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    @Test
    public void testCantYvalorStock3() {
        System.out.println("cantYvalorStock");
        Pieza pieza1 = new Pieza("1111", "11.11.11", "uno", 1, 1);
        Pieza pieza2 = new Pieza("2222", "22.22.22", "uno", 2, 2);
        Pieza pieza3 = new Pieza("3333", "33.33.33", "uno", 3, 3);
        Pieza pieza4 = new Pieza("4444", "44.44.44", "uno", 5, 5);
        Pieza pieza5 = new Pieza("5555", "55.55.55", "uno", 5, 5);
        TElementoAB nodo5= new TElementoAB("1111", pieza1);
        TElementoAB nodo4= new TElementoAB("2222", pieza2);
        TElementoAB nodo3= new TElementoAB("3333", pieza3);
        TElementoAB nodo2= new TElementoAB("4444", pieza4);
        TElementoAB nodo1= new TElementoAB("5555", pieza5);
        TArbolPiezas arbolCantYvalor = new TArbolPiezas();
        arbolCantYvalor.insertar(nodo1);
        arbolCantYvalor.insertar(nodo2);
        arbolCantYvalor.insertar(nodo3);
        arbolCantYvalor.insertar(nodo4);
        arbolCantYvalor.insertar(nodo5);
               
        
        int[] expResult = {16,64};
        int[] result = new int[2];        
        
        result = arbolCantYvalor.cantYvalorStock();
                
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    @Test
    public void piezasPorRubro1(){
        Pieza pieza1 = new Pieza("1111", "11.11.11", "uno", 1, 1);
        Pieza pieza2 = new Pieza("2222", "22.22.22", "uno", 2, 2);
        Pieza pieza3 = new Pieza("3333", "11.33.33", "uno", 3, 3);
        Pieza pieza4 = new Pieza("4444", "44.44.44", "uno", 4, 4);
        Pieza pieza5 = new Pieza("5555", "55.55.55", "uno", 5, 5);
        TElementoAB nodo1= new TElementoAB("1111", pieza1);
        TElementoAB nodo2= new TElementoAB("2222", pieza2);
        TElementoAB nodo3= new TElementoAB("3333", pieza3);
        TElementoAB nodo4= new TElementoAB("4444", pieza4);
        TElementoAB nodo5= new TElementoAB("5555", pieza5);
        TArbolPiezas arbolCantYvalor = new TArbolPiezas();
        arbolCantYvalor.insertar(nodo1);
        arbolCantYvalor.insertar(nodo2);
        arbolCantYvalor.insertar(nodo3);
        arbolCantYvalor.insertar(nodo4);
        arbolCantYvalor.insertar(nodo5);
               
        
        int expResult = 2;
        int result = arbolCantYvalor.piezasPorRubro("11").obtenerTamanio();
                
        assertEquals(expResult, result);
    
    }
    
    @Test
    public void piezasPorRubroSinCoincidencias(){
        Pieza pieza1 = new Pieza("1111", "11.11.11", "uno", 1, 1);
        Pieza pieza2 = new Pieza("2222", "22.22.22", "uno", 2, 2);
        Pieza pieza3 = new Pieza("3333", "11.33.33", "uno", 3, 3);
        Pieza pieza4 = new Pieza("4444", "44.44.44", "uno", 4, 4);
        Pieza pieza5 = new Pieza("5555", "55.55.55", "uno", 5, 5);
        TElementoAB nodo4= new TElementoAB("1111", pieza1);
        TElementoAB nodo2= new TElementoAB("2222", pieza2);
        TElementoAB nodo5= new TElementoAB("3333", pieza3);
        TElementoAB nodo1= new TElementoAB("4444", pieza4);
        TElementoAB nodo3= new TElementoAB("5555", pieza5);
        TArbolPiezas arbolCantYvalor = new TArbolPiezas();
        arbolCantYvalor.insertar(nodo1);
        arbolCantYvalor.insertar(nodo2);
        arbolCantYvalor.insertar(nodo3);
        arbolCantYvalor.insertar(nodo4);
        arbolCantYvalor.insertar(nodo5);
               
        
        int expResult = 0;
        int result = arbolCantYvalor.piezasPorRubro("0").obtenerTamanio();
                
        assertEquals(expResult, result);        
    }
    
    @Test
    public void piezasPorRubroVacio(){
        TArbolPiezas arbolCantYvalor = new TArbolPiezas();
        int expResult = 0;
        int result = arbolCantYvalor.piezasPorRubro("11").obtenerTamanio();
                
        assertEquals(expResult, result);        
    }
    
    
}
