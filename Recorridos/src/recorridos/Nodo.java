/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recorridos;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Nodo {

    public String elem;
    public ArrayList<Nodo> ady;

    public Nodo() {
    }
    
    public void add(Nodo nodo){
        this.ady.add(nodo);
    }
}
