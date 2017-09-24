/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Recorrido {

    public int Matriz[][];
    public NodoList list[];

    public Recorrido(int[][] Matriz) {
        this.Matriz = Matriz;
    }

    public Recorrido(NodoList[] list) {
        this.list = list;
    }

    public void DFSM() {
        Stack pila = new Stack();
        boolean visto[] = new boolean[this.Matriz.length];
        pila.add(0);
        String r = "";
        visto[0] = true;
        while (!pila.isEmpty()) {
            int d = (int) (pila.pop());
            r += (d + 1) + ",";

            for (int i = 0; i < this.Matriz.length; i++) {
                if (this.Matriz[d][i] != 0 && !visto[i]) {
                    pila.push(i);
                    visto[i] = true;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "El recorrido en DFS usando matriz es:\n" + r.substring(0, r.length() - 1));
    }

    public void BFSM() {
        Queue pila = new LinkedList();
        boolean visto[] = new boolean[this.Matriz.length];
        pila.add(0);
        String r = "";
        visto[0] = true;
        while (!pila.isEmpty()) {
            int d = (int) (pila.remove());
            r += (d + 1) + ",";
            for (int i = 0; i < this.Matriz.length; i++) {
                if (this.Matriz[d][i] != 0 && !visto[i]) {
                    pila.add(i);
                    visto[i] = true;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "El recorrido en BFS usando matriz es:\n" + r.substring(0, r.length() - 1));
    }

    public void DFSL() {
        Stack pila = new Stack();
        boolean visto[] = new boolean[this.Matriz.length];
        pila.add(this.list[0]);
        String r = "";
        visto[0] = true;
        while (!pila.isEmpty()) {
            int d = ((NodoList) pila.pop()).getElem();
            NodoList n = this.list[d - 1];
            visto[n.getElem() - 1] = true;
            r += (n.getElem()) + ",";
            n = n.getLink();
            while (n != null) {
                if (!visto[n.getElem() - 1]) {
                    pila.push(n);
                    visto[n.getElem() - 1] = true;
                }
                n = n.getLink();
            }
        }
        JOptionPane.showMessageDialog(null, "El recorrido en DFS usando Lista es:\n" + r.substring(0, r.length() - 1));
    }

    public void BFSL() {
        Queue pila = new LinkedList();
        boolean visto[] = new boolean[this.Matriz.length];
        pila.add(this.list[0]);
        String r = "";
        visto[0] = true;
        while (!pila.isEmpty()) {
            int d = ((NodoList) pila.remove()).getElem();
            NodoList n = list[d - 1];
            visto[n.getElem() - 1] = true;
            r += (n.getElem()) + ",";
            n = n.getLink();
            while (n != null) {
                if (!visto[n.getElem() - 1]) {
                    pila.add(n);
                    visto[n.getElem() - 1] = true;
                }
                n = n.getLink();
            }
        }
        JOptionPane.showMessageDialog(null, "El recorrido en BFS usando Lista es:\n" + r.substring(0, r.length() - 1));
    }
}
