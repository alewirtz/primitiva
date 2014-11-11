package com.example.primitiva;

import java.util.ArrayList;

public class Primitiva {
    static ArrayList<Integer> aux;


    public static ArrayList<Integer> generarNumeros() {
        boolean ok = false;
        int num, numAux;
        aux = new ArrayList();
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                num = (int)(Math.random() * 49 + 1);
                aux.add(num);
            } else {
                do {
                    numAux = (int)(Math.random() * 49 + 1);
                    ok = comprobarNumeros(numAux);
                    if (ok == false) {
                        aux.add(numAux);
                    }
                } while (ok == true);
                {
                }
            }
        }
        return aux;
    }


    public static boolean comprobarNumeros(int numero) {
        boolean flag = false;
        for (int j = 0; j < aux.size(); j++) {
            if ((Integer.valueOf(numero).equals(aux.get(j)))) {
                flag = true;
            } 
            System.out.println(flag);
        }
        System.out.println(flag);
        return flag;
    }
}