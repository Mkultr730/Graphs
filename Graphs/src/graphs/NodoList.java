/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

/**
 *
 * @author Usuario
 */
public class NodoList {
    private String elem;
    private int size;
    private NodoList link;

    public NodoList(String elem, int size) {
        this.setElem(elem);
        this.setSize(size);
    }

    public String getElem() {
        return elem;
    }

    public void setElem(String elem) {
        this.elem = elem;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public NodoList getLink() {
        return link;
    }

    public void setLink(NodoList link) {
        this.link = link;
    }
    
}
