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
			double[][] transMatrix = new double[matrix.length][matrix[0].length];

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					transMatrix[i][j] = matrix[j][i];
				}
			}
			return transMatrix;
		} catch (MatrixProcessorException ex){
			throw new MatrixProcessorException("Illegal operation.");
		}
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

}
