package com.epam.tat.matrixprocessor.impl;

import com.epam.tat.matrixprocessor.IMatrixProcessor;
import com.epam.tat.matrixprocessor.exception.MatrixProcessorException;
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
			double determinantNumber = getMatrixDeterminant(matrix);
			int rowLength = matrix.length;
			int columnLength = matrix[0].length;
			double[][] temporaryInverseMatrix = new double[rowLength][columnLength];
			double[][] temp = new double[rowLength][columnLength];

			for (int row = 0; row < rowLength; row++) {
				for (int column = 0; column < rowLength; column++) {
					getCofactor(matrix, temp, row, column, rowLength);
					temporaryInverseMatrix[row][column] = Math.pow(-1, row + column)
							* getMatrixDeterminant(temp);
				}
			}

			double[][] finalInverseMatrix = new double[rowLength][columnLength];

			for (int i = 0; i < rowLength; i++) {
				for (int j = 0; j < columnLength; j++) {
					finalInverseMatrix[i][j] = Math.round((temporaryInverseMatrix[j][i] / determinantNumber) * scale) / scale;
				}
			}
			return finalInverseMatrix;
		} catch (MatrixProcessorException ex) {
			throw new MatrixProcessorException("Illegal operation.");
		}
	}

	@Override
	public double getMatrixDeterminant(double[][] matrix) {
		try {
			double determinant = 0;
			int rows = matrix.length;
			int columns = matrix[0].length;
			if (rows == 1) {
				return matrix[0][0];
			}

			double[][] temp = new double[rows][columns];
			int sign = 1;
			for (int row = 0; row < rows; row++) {
				getCofactor(matrix, temp, 0, row, rows);
				determinant += sign * matrix[0][row]
						* getMatrixDeterminant(temp);
				sign = -sign;
			}
			return determinant;
		} catch (MatrixProcessorException ex) {
			throw new MatrixProcessorException("Illegal operation.");
		}

	}
	private static void getCofactor(double[][] matrix, double[][] temp, int oldRow, int oldColumn, int rows) {
		int i = 0, j = 0;
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < rows; column++) {
				if (row != oldRow && column != oldColumn) {
					temp[i][j++] = matrix[row][column];
					if (j == rows - 1) {
						j = 0;
						i++;
					}
				}
			}
		}
	}

}
