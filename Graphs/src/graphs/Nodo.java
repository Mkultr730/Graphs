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
    private ArrayList<Nodo> link;

    public Nodo() {
    }

    public String getElem() {
        return elem;
    }

    public void setElem(String elem) {
        this.elem = elem;
    }

    public ArrayList<Nodo> getLink() {
        return link;
    }

    public void setLink(ArrayList<Nodo> link) {
        this.link = link;
    }
    
    public void add(Nodo nodo){
        this.link.add(nodo);
    }
}
