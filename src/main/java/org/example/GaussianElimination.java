package org.example;

import java.util.Arrays;

public class GaussianElimination{
    public void solveMatrix(double[][] m, double [] s){
        int matrixSize = s.length;

        for (int k = 0; k < matrixSize; k++){
//            Find pivot row
            int max = k;
            for (int i = k + 1; i < matrixSize; i++){
                if (Math.abs(m[i][k]) > Math.abs(m[max][k])){
                    max = i;
                }
            }

            double[] mem = m[k];
            m[k] = m[max];
            m[max] = mem;

            double t = s[k];
            s[k] = s[max];
            s[max] = t;

            for (int i = k + 1; i < matrixSize; i++){
                double factor = m[i][k]/ m[k][k];
                s[i] -= factor * s[k];
                for (int j = k;  j < matrixSize; j++){
                    m[i][j] -= factor * m[k][j];
                }
            }
        }

//        substitution
        double[] solution = new double[matrixSize];

        for (int i = matrixSize - 1; i >= 0; i--){
            double sum = 0.0;
            for (int j = i; j < matrixSize; j++){
                sum += m[i][j] * solution[j];
            }
            solution[i] = (s[i] - sum) / m[i][i];
        }

        System.out.println(Arrays.toString(solution));
    }
}