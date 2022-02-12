package com.rodri.learn;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer player1 = 3;
        Integer player2 = 2;

        Integer[][] matrix = new Integer[3][3];
        // inizializzo la matrice mettendo tutto a zero
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <3; j++) {
                matrix[i][j] = 0 ;
            }
        }

        matrix[0][2]=3;
        matrix[1][1]=3;
        matrix[2][0]=3;

        Integer integer = checkVittory(matrix);
        System.out.println(integer);
    }

    /**
     *  per analizzare la matrice userò questo algoritmo:
     *  se vado a moltiplicare l'intera riga se il risultato è 9 ha vinto il player 1
     *  se invece il risultato è 6 ha vinto il 2
     *  invece se viene zero nessuno ne esce vittorioso
     * @param matrix
     * @return
     */
    private static Integer checkVittory(Integer[][] matrix) {
        List<Integer> winnerList = new ArrayList<Integer>();
        winnerList.add(27);
        winnerList.add(8);

        int d1 = matrix[0][0];
        int d2 = matrix[0][2];
        for (int i = 0; i < 3; i++) {
            if(i>0) {
                d1*=matrix[i][i];
                d2*=matrix[i][2-i];
            }
            int x = matrix[i][0];
            int y = matrix[0][i];
            for (int j = 1; j < 3; j++) {
                x *= matrix[i][j];
                y *= matrix[j][i];

            }
            if(winnerList.contains(x)||winnerList.contains(y)){
                double v = x > 0 ? Math.pow(x, (double) 1 / 3) : Math.pow(y, (double) 1 / 3);
                return (int)v;
            }
        }
        if(winnerList.contains(d1)||winnerList.contains(d2)){
            double v = d1 > 0 ? Math.pow(d1, (double) 1 / 3) : Math.pow(d2, (double) 1 / 3);
            return (int)v;
        }
        return 0;
    }
}
