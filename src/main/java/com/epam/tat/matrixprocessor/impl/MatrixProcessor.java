package com.epam.tat.matrixprocessor.impl;

import com.epam.tat.matrixprocessor.IMatrixProcessor;

import java.util.Scanner;

public class MatrixProcessor implements IMatrixProcessor {


	private int i;
	private int j;
	private int row;
	private int column;
	private double[][] array;



	@Override
	public double[][] transpose(double[][] matrix) {
		//todo throw new UnsupportedOperationException("You need to implement this method");

		for (i = 0; i < column; i++) {
			for (j = 0; j < row; j++) {
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
		throw new UnsupportedOperationException("You need to implement this method");


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

		int i, j;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter rows number (minimum=1, maximum=9):");
		int row = s.nextInt();
		while (row <= 0 || row > 9) {
			System.out.println("Invalid row number (minimum=1, maximum=9). Enter again:");
			row = s.nextInt();
		}

		System.out.println("Enter columns number (minimum=1, maximum=9):");
		int column = s.nextInt();
		while (column <= 0 || column > 9) {
			System.out.println("Invalid column number (minimum=1, maximum=9). Enter again:");
			column = s.nextInt();
		}

		double[][] array = new double[row][column];

		System.out.println("Enter numbers for matrix:");
		for (i = 0; i < row; i++) {
			for (j = 0; j < column; j++) {
				array[i][j] = s.nextDouble();
				System.out.print(" ");
			}
		}

		System.out.println("The original matrix is:");
		for (i = 0; i < row; i++) {
			for (j = 0; j < column; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println(" ");
		}

	}
}
