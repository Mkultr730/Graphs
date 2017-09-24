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
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class dijkstra {

    int nNodos;
    List conj_S = new ArrayList();
    List conjComp_S = new ArrayList();
    List caminos = new ArrayList();
    String tmp;
    InputStreamReader l1;
    BufferedReader l2;
    public int matrizAdy[][];

    public dijkstra(int matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] == 0) {
                    matriz[i][j] = -1;
                }
            }
        }
        this.matrizAdy = matriz;
        this.nNodos = matriz.length;
        int aux = 0;
        l1 = new InputStreamReader(System.in);
        l2 = new BufferedReader(l1);
        nNodos = 5;
        do {
            try {
                char r = JOptionPane.showInputDialog(null, "¿Cuál es el nodo origen?").charAt(0);
                aux = ((int) (r)) - 65;
            } catch (StringIndexOutOfBoundsException e3) {
                System.out.println("Error: " + e3);
                aux = -1;
            }
            System.out.println(aux);
        } while (aux < 0 || aux > nNodos - 1);
        matrizAdy[aux][aux] = 0;
        resuelve(aux);
    }

    public void resuelve(int origen) {
        int nod;
        int minimo;
        int aux;
        int nodCambio = 0;
        int intento;
        //Inicializando listas
        for (int i = 0; i < nNodos; i++) {
            if (i != origen) {
                conjComp_S.add("" + i);
            } else {
                conj_S.add("" + i);
            }
            caminos.add("");
        }
        //Aplicando ciclo i de diksjtra
        for (int i = 0; i < nNodos; i++) {
            minimo = -1;
            for (int j = 0; j < conjComp_S.size(); j++) {
                nod = Integer.valueOf((String) (conjComp_S.get(j))).intValue();
                aux = min(nod);
                if (minimo == -1 || (aux < minimo && aux != -1)) {
                    minimo = aux;
                    nodCambio = j;
                }
            }
            if (minimo != -1) {
                conj_S.add("" + (String) (conjComp_S.get(nodCambio)));
                conjComp_S.remove(nodCambio);
            }
        }
        //Imprimiendo resultados
        System.out.print("\n -> Resultados <-");
        for (int k = 0; k < caminos.size(); k++) {
            if (k != origen) {
                tmp = (String) (caminos.get(k)) + (char) (k + 65);
                caminos.set(k, tmp);
            }
        }
        for (int j = 0; j < caminos.size(); j++) {
            if (j != origen) {
                intento = 0;
                tmp = (String) (caminos.get(j));
                while (tmp.charAt(0) != (char) (origen + 65) && intento < 10) {
                    aux = tmp.charAt(0) - 65;
                    tmp = ((String) (caminos.get(aux))) + tmp.substring(1, tmp.length());
                    if (++intento == 10) {
                        tmp = "*" + tmp;
                    }
                };
                imprimeCamino(tmp, j, origen);
            }
        }
    }

    public int min(int dest) {
        int min = -1;
        int nod = 0;
        int nodOrig = -1;
        int aux;
        for (int i = 0; i < conj_S.size(); i++) {
            nod = Integer.valueOf((String) (conj_S.get(i))).intValue();
            if (matrizAdy[nod][nod] != -1 && matrizAdy[nod][dest] != -1) {
                aux = matrizAdy[nod][nod] + matrizAdy[nod][dest];
            } else {
                aux = -1;
            }
            if ((aux < min && aux != -1) || min == -1) {
                min = aux;
                nodOrig = nod;
            }
        }
        if (min != -1) {
            matrizAdy[dest][dest] = min;
            caminos.set(dest, "" + (char) (nodOrig + 65));
        }
        return min;
    }

    public void imprimeCamino(String cam, int nod, int o) {
        System.out.print("\nCamino: ");
        if (cam.charAt(0) == '*') {
            System.out.print("No hay camino de: " + (char) (o + 65) + " a: " + cam.charAt(cam.length() - 1) + "!!");
        } else {
            for (int i = 0; i < cam.length(); i++) {
                System.out.print("" + cam.charAt(i) + (i == cam.length() - 1 ? "" : "->"));
            }
            System.out.print(" costo: " + matrizAdy[nod][nod]);
        }
    }
}
