package com.epam.tat.matrixprocessor.impl;

import com.epam.tat.matrixprocessor.exception.MatrixProcessorException;

public class Main {

    public static void main(String args[]) {
        MatrixProcessor matrixProcessor = new MatrixProcessor();

        double[][] matrix = {{-3.1244, 15.5}, {5.01, -7.14}, {-2.12, 3.4}};
        double[][] firstMatrix = {{1.1, 0}, {-2.12, 3.4}};
        double[][] secondMatrix = {{-3.1244, 15.5}, {5.01, -7.14}};
        int maxRows = 10;
        int maxColumns = 10;
        int minRows = 1;
        int minColumns = 1;

        if (matrix.length < maxRows & matrix[0].length > minRows &
                matrix[0].length < maxColumns &  matrix[0].length > minColumns) {
            System.out.println("\n\tThe original matrix is:\n" +
                    matrixProcessor.displayMatrix(matrix));

            System.out.println("\tThe transposed matrix is:\n" +
                    matrixProcessor.displayMatrix(matrixProcessor.transpose(matrix)));

            System.out.println("\tThe turned clockwise matrix is:\n" +
                    matrixProcessor.displayMatrix(matrixProcessor.turnClockwise(matrix)));

            System.out.println("\tThe multiplication of matrices is:\n" +
                    matrixProcessor.displayMatrix(matrixProcessor.multiplyMatrices(firstMatrix, secondMatrix)));


            System.out.println("\tThe inversed matrix is:\n" +
                    matrixProcessor.displayMatrix(matrixProcessor.getInverseMatrix(matrix)));

            System.out.println("\tThe matrix determinant is:\n" +
                    matrixProcessor.getMatrixDeterminant(matrix));
        }
        else System.out.println("Error: Number of rows and columns in matrix should be from 1 to 9."); {
            throw new MatrixProcessorException();
        }

    }

}
