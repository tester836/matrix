package com.epam.tat.matrixprocessor;


public interface IMatrixProcessor {

    double[][] transpose(double[][] matrix);

    double[][] turnClockwise(double[][] matrix);

    double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix);

    double[][] getInverseMatrix(double[][] matrix);

    double getMatrixDeterminant(double[][] matrix);
}