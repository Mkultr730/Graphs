/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import static graphs.view.Form.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Usuario
 */
public class Archivo {

    public Archivo() {
    }
    
    public int[][] loadMatriz() throws FileNotFoundException, IOException{
        File matriz = new File("matriz.txt");
        FileReader fr = new FileReader(matriz);
        BufferedReader br = new BufferedReader(fr);
        int size = tam(matriz);
        int m[][] = new int[size][size];
        n = size;
        String line;
        int i = 0;
        while((line = br.readLine()) != null){
            String v[] = line.split(",");
            for (int j = 0; j < v.length; j++) {
                m[i][j] = Integer.parseInt(v[j]);
            }
            i += 1;
        }
        br.close();
        return m;
    }
    
    public void saveMatriz(int matriz[][]) throws IOException{
        File archivo = new File("matriz.txt");
        FileWriter fw = new FileWriter(archivo);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("");
        for (int i = 0; i < n; i++) {
            String line = "";
            for (int j = 0; j < n; j++) {
                line = line + "," + String.valueOf(matriz[i][j]);
            }
            bw.write(line.substring(1));
            bw.newLine();
        }
        bw.close();
    }
    public int tam(File matriz) throws IOException{
        FileReader fr = new FileReader(matriz);
        BufferedReader br = new BufferedReader(fr);
        int size = 0;
        String line;
        while((line = br.readLine()) != null){
            size += 1;
        }
        br.close();
        return size;
    }
    
    public NodoList[] loadList() throws FileNotFoundException, IOException{
        NodoList[] lista;
        File l = new File("lista.txt");
        FileReader fr = new FileReader(l);
        BufferedReader br = new BufferedReader(fr);
        String line;
        n = tam(l);
        lista = new NodoList[n];
        int c = 0;
        while((line = br.readLine())!= null){
            String v[] = line.split("->");
            NodoList ptr = null;
            for (int i = 0; i < v.length; i++) {
                if (i == 0) {
                    ptr = new NodoList(v[i]+"",0);
                }else{
                    char elem = v[i].charAt(0);
                    int size = Integer.parseInt(v[i].substring(2, v[i].length()-1));
                    NodoList p = new NodoList(v[i]+"", size);
                    NodoList q = ptr;
                    while(q.getLink() != null){
                        q = q.getLink();
                    }
                    q.setLink(p);
                }
            }
            lista[c] = ptr;
            c += 1;
        }
        br.close();
        return lista;
    }
}
