package com.epam.tat.matrixprocessor.impl;

public class Main {


    public static void main(String args[]) {
        MatrixProcessor matrixProcessor = new MatrixProcessor();

        double[][] matrix = {{1.1, 0.3}, {-2.03, 0.0}, {3.456, -33.6543}};

        System.out.println("\n\tThe original matrix is:");
        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }


        System.out.println("\tThe transposed matrix is:\n" +
                matrixProcessor.displayMatrix(matrixProcessor.transpose(matrix)));


        System.out.println("\tThe turned clockwise matrix is:");


        System.out.println("\tThe multiplication of matrices is:");


        System.out.println("\the inversed matrix is:");


        System.out.println("\tThe matrix determinant is:");

    }

}
