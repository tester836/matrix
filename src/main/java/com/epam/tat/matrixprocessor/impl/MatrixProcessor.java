package com.epam.tat.matrixprocessor.impl;

import com.epam.tat.matrixprocessor.IMatrixProcessor;
import com.epam.tat.matrixprocessor.exception.MatrixProcessorException;

import java.text.DecimalFormat;
import java.util.Arrays;


public class MatrixProcessor implements IMatrixProcessor {

	private int precision = 3;
	double scale = Math.pow(10.0, precision);

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

	@Override
	public double[][] turnClockwise(double[][] matrix) {

		try {
		double[][] rotatedMatrix = transpose(matrix);
			for (int i = 0; i < rotatedMatrix.length; i++) {
				int lowRow = 0, highRow = rotatedMatrix[0].length - 1;
				while (lowRow < highRow) {
					double temp = rotatedMatrix[i][lowRow];
					rotatedMatrix[i][lowRow] = rotatedMatrix[i][highRow];
					rotatedMatrix[i][highRow] = temp;
					lowRow++;
					highRow--;
				}
			}
			return rotatedMatrix;
		} catch (MatrixProcessorException ex){
			throw new MatrixProcessorException("Illegal operation.");
		}
	}


	@Override
	public double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
		try {
			double[][] resultMatrix = new double[firstMatrix.length][secondMatrix[0].length];

			for (int i = 0; i < resultMatrix[0].length; i++)
				for (int j = 0; j < resultMatrix.length; j++)
					for (int k = 0; k < firstMatrix[0].length; k++) {
						resultMatrix[i][j] = Math.round((resultMatrix[i][j] + firstMatrix[i][k] * secondMatrix[k][j]) * scale) / scale;
					}
			return resultMatrix;
		} catch (MatrixProcessorException ex) {
			throw new MatrixProcessorException("Illegal operation.");
		}
	}

	@Override
	public double[][] getInverseMatrix(double[][] matrix) {
		try {
			double determinant = getMatrixDeterminant(matrix);
			matrix = getAdjoint(matrix);
			double[][] inversedMatrix = new double[matrix.length][matrix.length];

			for (int row = 0; row < matrix.length; row++) {
				for (int col = 0; col < matrix[0].length; col++) {
					inversedMatrix[row][col] = Math.round((matrix[row][col] / determinant) * scale) / scale;

				}
			}

			return inversedMatrix;
		} catch (MatrixProcessorException ex) {
			throw new MatrixProcessorException("Illegal operation.");
		}
	}

	@Override
	public double getMatrixDeterminant(double[][] matrix) {
		try {
			if (matrix.length == 2) {
				return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
			} else {
				double determinant = 0;

				for (int rows = 0; rows < matrix.length; rows++) {
					matrix = arrayOfRange(matrix, 0, rows);

					if (rows % 2 == 0) {
						determinant += matrix[0][rows] * getMatrixDeterminant(matrix);
					} else {
						determinant -= matrix[0][rows] * getMatrixDeterminant(matrix);
					}
				}
				return determinant;
			}

		} catch (MatrixProcessorException ex) {
			throw new MatrixProcessorException("Illegal operation.");
		}

	}

	private double[][] arrayOfRange(double[][] matrix, int rows, int columns) {

		matrix = new double[matrix.length - 1][matrix[0].length - 1];
		int row_sub = 0;

		for (int row = 0; row < matrix.length; row++) {

			int col_sub = 0;
			if (row != rows) {

				for (int col = 0; col < matrix[row].length; col++) {

					if (col != columns) {
						matrix[row - row_sub][col - col_sub] = matrix[row][col];
					} else {
						col_sub = 1;
					}

				}

			} else {
				row_sub = 1;
			}

		}

		return matrix;
	}

	public double[][] getAdjoint(double[][] matrix) {
		double[][] adj = getDeterminantOfMinors(matrix);
		int i = 1;

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				adj[row][col] *= i;
				i *= -1;
			}
		}
		return adj;
	}

	public double[][] getDeterminantOfMinors(double[][] matrix) {
		matrix = transpose(matrix);
		double[][] resultMatrix = new double[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix = arrayOfRange(matrix, i, j);
				resultMatrix[i][j] = getMatrixDeterminant(matrix);
			}
		}

		return resultMatrix;
	}

}
