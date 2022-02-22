package com.epam.tat.matrixprocessor.impl;

import com.epam.tat.matrixprocessor.IMatrixProcessor;
import com.epam.tat.matrixprocessor.exception.MatrixProcessorException;

import java.util.Scanner;

public class MatrixProcessor implements IMatrixProcessor {

	private int i;
	private int j;
	private double[][] array;



	@Override
	public double[][] transpose(double[][] matrix) {
		//throw new MatrixProcessorException("Illegal operation.");

		for (i = 0; i < matrix.length; i++) {
			for (j = 0; j <  matrix[matrix.length].length; j++) {
				System.out.print(array[j][i] + " ");
			}
			System.out.println(" ");
		}
		return matrix;
	}


	@Override
	public double[][] turnClockwise(double[][] matrix) {
		throw new UnsupportedOperationException("You need to implement this method");
	}


	/**
	 * This method multiplies matrix firstMatrix by matrix secondMatrix
	 * <p>
	 * See {https://en.wikipedia.org/wiki/Matrix_multiplication}
	 *
	 * @param firstMatrix  - first matrix to multiply
	 * @param secondMatrix - second matrix to multiply
	 * @return result matrix
	 */
	@Override
	public double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
		throw new MatrixProcessorException("Illegal operation.");



	}

	/**
	 * This method returns the inverse of the matrix
	 * <p>
	 * See {https://en.wikipedia.org/wiki/Invertible_matrix}
	 *
	 * @param matrix - input matrix
	 * @return inverse matrix for input matrix
	 */
	@Override
	public double[][] getInverseMatrix(double[][] matrix) {
		throw new UnsupportedOperationException("You need to implement this method");
	}

	/**
	 * This method returns the determinant of the matrix
	 * <p>
	 * See {https://en.wikipedia.org/wiki/Determinant}
	 *
	 * @param matrix - input matrix
	 * @return determinant of input matrix
	 */
	@Override
	public double getMatrixDeterminant(double[][] matrix) {
		throw new UnsupportedOperationException("You need to implement this method");
	}



	public static void main(String args[]) {

		double[][] matrix = {{1.1, 0.3}, {-2.03, 3.67}};

		System.out.println("\tThe original matrix is:");
		for (int i=0; i < matrix.length; i++){
			for(int j=0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}


		System.out.println("\tThe transposed matrix is:");


		System.out.println("\tThe turned clockwise matrix is:");


		System.out.println("\tThe multiplication of matrices is:");


		System.out.println("\the inversed matrix is:");


		System.out.println("\tThe matrix determinant is:");

	}

}
