/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Nodo {
    private String elem;
    private ArrayList<Nodo> ady;

    public Nodo() {
    }

    public String getElem() {
        return elem;
    }

    public void setElem(String elem) {
        this.elem = elem;
    }

    public ArrayList<Nodo> getLink() {
        return ady;
    }

    public void setLink(ArrayList<Nodo> link) {
        this.ady = link;
    }
    
    public void add(Nodo nodo){
        this.add(nodo);
    }
    
    public Nodo generateGraph(int Matriz[][], NodoList list[]){
        Nodo root = null;
        
        return root;
    }
}
