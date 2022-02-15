package com.epam.tat.matrixprocessor.impl;

import com.epam.tat.matrixprocessor.IMatrixProcessor;

import java.util.Scanner;

/**
 * Function Description:
 * Complete the functions below. All methods must work with matrices of the double type.
 *
 * Constraints:
 * 0 < m < 10
 * 0 < n < 10
 * where m - number of rows in matrix
 * where n - number of columns in matrix
 *
 * In case of incorrect input values or inability to perform a calculation, the method should throw an appropriate
 * exception.
 *
 */
public class MatrixProcessor implements IMatrixProcessor {

	public static void main(String args[]) {
		int i, j;
		Scanner s = new Scanner(System.in);
			System.out.println("Enter rows number (minimum=1, maximum=10): ");
			int row = s.nextInt();
				while (row <= 0 || row > 10) {
					System.out.println("Invalid row number (minimum=1, maximum=10). Enter again: ");
					row = s.nextInt();
				}

			System.out.println("Enter columns number (minimum=1, maximum=10): ");
			int column = s.nextInt();
				while (column <= 0 || column > 10) {
					System.out.println("Invalid column number (minimum=1, maximum=10). Enter again: ");
					column = s.nextInt();
				}



		int array[][] = new int[row][column];
		System.out.println("Enter matrix:");
		for(i = 0; i < row; i++)
		{
			for(j = 0; j < column; j++)
			{
				array[i][j] = s.nextInt();
				System.out.print(" ");
			}
		}
		System.out.println("Original matrix is ");
		for(i = 0; i < row; i++)
		{
			for(j = 0; j < column; j++)
			{
				System.out.print(array[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
	/**
	 * Matrix transpose is an operation on a matrix where its rows become columns with the same numbers.
	 * Ex.:
	 * |1 2|			|1 3 5|
	 * |3 4|   ====>	|2 4 6|
	 * |5 6|
	 *
	 * @param matrix - matrix for transposition
	 * @return the transposed matrix
	 */
	@Override
	public double[][] transpose(double[][] matrix) {
		throw new UnsupportedOperationException("You need to implement this method");


	}

	/**
	 * The method flips the matrix clockwise.
	 * Ex.:
	 * * |1 2|			|5 3 1|
	 * * |3 4|   ====>	|6 4 2|
	 * * |5 6|
	 *
	 * @param matrix - rotation matrix
	 * @return rotated matrix
	 */
	@Override
	public double[][] turnClockwise(double[][] matrix) {
		throw new UnsupportedOperationException("You need to implement this method");
	}

	/**
	 * This method multiplies matrix firstMatrix by matrix secondMatrix
	 *
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
	 *
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
	 *
	 * See {https://en.wikipedia.org/wiki/Determinant}
	 *
	 * @param matrix - input matrix
	 * @return determinant of input matrix
	 */
	@Override
	public double getMatrixDeterminant(double[][] matrix) {
		throw new UnsupportedOperationException("You need to implement this method");
	}


}
