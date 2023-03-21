package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GaussianElimination ge = new GaussianElimination();

        System.out.println("Introduzca el numero de vairables:");
        int n = scanner.nextInt();

        double[] s = new double[n];
        double[][] m = new double[n][n];

        System.out.println("\n Introduzca " + n + " ecuaciones con sus coeficientes");

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                m[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Introduzca " + n + " soluciones");
        for (int i = 0; i < n; i++){
            s[i] = scanner.nextDouble();
        }

        ge.solveMatrix(m, s);

    }
}