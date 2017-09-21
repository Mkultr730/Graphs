/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recorridos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Usuario
 */
public class Recorridos {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Nodo> visitados;
    public static void main(String[] args) {
        Nodo n1 = new Nodo();
        n1.elem = "1";
        Nodo n2 = new Nodo();
        n2.elem = "2";
        n1.add(n2);
        DFS(n1);
    }
    static void DFS(Nodo nodo){
        visitados.add(nodo);
        for(Nodo n : nodo.ady){
            if (!visitados.contains(n)) {
                System.out.println(n.elem);
                DFS(n);
            }
        }
    }
    
    static void BFS(Nodo nodo){
        Queue<Nodo> cola = new LinkedList();
        visitados.add(nodo);
        cola.add(nodo);
        while(!cola.isEmpty()){
            Nodo v = cola.poll();
            for(Nodo s : v.ady){
                if (!visitados.contains(s)) {
                    visitados.add(s);
                    cola.add(s);
                }
            }
        }
        
        
    }
    
}
