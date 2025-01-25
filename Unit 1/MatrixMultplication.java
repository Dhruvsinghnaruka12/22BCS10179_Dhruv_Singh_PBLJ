package First_Unit;

import java.util.*;

public class MatrixMultplication {



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
    
            System.out.println("Enter dimensions of the first matrix (rows and columns): ");
            int rows1 = sc.nextInt();
            int cols1 = sc.nextInt();
    
            System.out.println("Enter dimensions of the second matrix (rows and columns): ");
            int rows2 = sc.nextInt();
            int cols2 = sc.nextInt();
    
            // Input the matrices
            System.out.println("Enter elements of the first matrix:");
            int[][] matrix1 = inputMatrix(rows1, cols1, sc);
    
            System.out.println("Enter elements of the second matrix:");
            int[][] matrix2 = inputMatrix(rows2, cols2, sc);
    
            // Perform matrix operations
            System.out.println("\nAddition of matrices (if possible):");
            addMatrices(matrix1, matrix2);
    
            System.out.println("\nSubtraction of matrices (if possible):");
            subtractMatrices(matrix1, matrix2);
    
            System.out.println("\nMultiplication of matrices (if possible):");
            multiplyMatrices(matrix1, matrix2);
    
            sc.close();
        }
    
        // Method to input a matrix
        public static int[][] inputMatrix(int rows, int cols, Scanner sc) {
            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            return matrix;
        }
    
        // Method for matrix addition
        public static void addMatrices(int[][] matrix1, int[][] matrix2) {
            if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
                int rows = matrix1.length;
                int cols = matrix1[0].length;
                int[][] result = new int[rows][cols];
    
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        result[i][j] = matrix1[i][j] + matrix2[i][j];
                    }
                }
                printMatrix(result);
            } else {
                System.out.println("Addition not possible. Matrices dimensions do not match.");
            }
        }
    
        // Method for matrix subtraction
        public static void subtractMatrices(int[][] matrix1, int[][] matrix2) {
            if (matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length) {
                int rows = matrix1.length;
                int cols = matrix1[0].length;
                int[][] result = new int[rows][cols];
    
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        result[i][j] = matrix1[i][j] - matrix2[i][j];
                    }
                }
                printMatrix(result);
            } else {
                System.out.println("Subtraction not possible. Matrices dimensions do not match.");
            }
        }
    
        // Method for matrix multiplication
        public static void multiplyMatrices(int[][] matrix1, int[][] matrix2) {
            if (matrix1[0].length == matrix2.length) {
                int rows = matrix1.length;
                int cols = matrix2[0].length;
                int common = matrix1[0].length;
    
                int[][] result = new int[rows][cols];
    
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        result[i][j] = 0;
                        for (int k = 0; k < common; k++) {
                            result[i][j] += matrix1[i][k] * matrix2[k][j];
                        }
                    }
                }
                printMatrix(result);
            } else {
                System.out.println("Multiplication not possible. Columns of the first matrix must equal rows of the second matrix.");
            }
        }
    
        // Method to print a matrix
        public static void printMatrix(int[][] matrix) {
            for (int[] row : matrix) {
                for (int element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        }
}
