package com.epam.tat.matrixprocessor.impl;

import com.epam.tat.matrixprocessor.IMatrixProcessor;
import com.epam.tat.matrixprocessor.exception.MatrixProcessorException;

import java.util.Arrays;


public class MatrixProcessor implements IMatrixProcessor {

	public String displayMatrix(double[][] matrix){
		StringBuilder sb = new StringBuilder();
		for (double[] row : matrix){
			sb.append(Arrays.toString(row)).append("\n");
		}
		return sb.toString();
	}


	@Override
	public double[][] transpose(double[][] matrix) {
		try {
			double[][] transposedMatrix = new double[matrix[0].length][matrix.length];
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					transposedMatrix[j][i] = matrix[i][j];
				}
			}
			return transposedMatrix;
		} catch (MatrixProcessorException ex){
			throw new MatrixProcessorException("Illegal operation.");
		}
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


	@Override
	public double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
		try {
			double[][] resultMatrix = new double[firstMatrix.length][secondMatrix[0].length];
			for (int i = 0; i < resultMatrix[0].length; i++)
				for (int j = 0; j < resultMatrix.length; j++)
					for (int k = 0; k < firstMatrix[0].length; k++)
						resultMatrix[i][j] = resultMatrix[i][j] + firstMatrix[i][k] * secondMatrix[k][j];

			return resultMatrix;
		} catch (MatrixProcessorException ex) {
			throw new MatrixProcessorException("Illegal operation.");
		}
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

}
