package EjePresestencia;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiplicarMatrices {


    public static void main(String[] args) {
        String f1 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "EjePresestencia" + File.separator + "Matriz1.txt";
        String f2 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "EjePresestencia" + File.separator + "Matriz2.txt";
        int[][] matriz1 = readMatrixFromFile(f1);
        int[][] matriz2 = readMatrixFromFile(f2);

        int[][] matRes = multiplicarMatrizes(matriz1, matriz2);
        if (guardar(matRes)) {
            System.out.println("Se guardo correctamente");
        } else {
            System.out.println("No se guardo correctamente");
        }
    }


    public static int[][] multiplicarMatrizes(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        if (cols1 != rows2) {
            throw new IllegalArgumentException("Dimensiones incorrectas");
        }

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public static boolean guardar(int[][] mat) {
        String f1 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "EjePresestencia" + File.separator + "MatrizResultado.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f1))) {
            int rows = mat.length;
            int columns = mat[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    writer.write(mat[i][j] + " ");
                }
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static int[][] readMatrixFromFile(String filePath) {
        int[][] matrix = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<String> lines = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            int rows = lines.size();
            int columns = lines.get(0).trim().split("\\s+").length;
            matrix = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                String[] elements = lines.get(i).trim().split("\\s+");
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = Integer.parseInt(elements[j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matrix;
    }


}
