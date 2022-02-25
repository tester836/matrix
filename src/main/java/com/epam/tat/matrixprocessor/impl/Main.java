package com.epam.tat.matrixprocessor.impl;

import java.util.Arrays;

public class Main {


    public static void main(String args[]) {
        MatrixProcessor matrixProcessor = new MatrixProcessor();

        double[][] matrix = {{1.1, 0.3}, {-2.03, 0.0}, {3.456, 33.6543}};
        double[][] firstMatrix = {{1, 0}, {-2, 3}};
        double[][] secondMatrix = {{-3, 15}, {5, -7}};

        System.out.println("\n\tThe original matrix is:\n" +
                Arrays.deepToString(matrix));
//        for (int i = 0; i < matrix.length; i++){
//            for(int j = 0; j < matrix[0].length; j++){
//                System.out.print(matrix[i][j] + "  ");
//            }
//            System.out.println();
//        }


        System.out.println("\tThe transposed matrix is:\n" +
                matrixProcessor.displayMatrix(matrixProcessor.transpose(matrix)));

        System.out.println("\tThe turned clockwise matrix is:\n" );

        System.out.println("\tThe multiplication of matrices is:");

        System.out.println("\the inversed matrix is:");

        System.out.println("\tThe matrix determinant is:");

    }

}
