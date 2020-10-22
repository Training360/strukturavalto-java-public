package arrayofarrays;

public class ArrayOfArraysMain {

    public void printArrayOfArrays(int[][] a) {
        for (int i[] : a) {
            for (int j : i) {
                if (j < 10) {
                    System.out.print("  ");
                } else if (j < 100) {
                    System.out.print(" ");
                }
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public int[][] multiplicationTable(int size) {
        int[][] multiplicationTable = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                multiplicationTable[i][j] = (i + 1) * (j + 1);
            }
        }
        return multiplicationTable;
    }

    public int[][] triangularMatrix(int size) {
        int[][] triangularMatrix = new int[size][];
        for (int i = 0; i < triangularMatrix.length; i++) {
            triangularMatrix[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                triangularMatrix[i][j] = i;
            }
        }
        return triangularMatrix;
    }

    public int[][] getValues() {
        int[][] values = new int[12][];
        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < numberOfDays.length; i++) {
            values[i] = new int[numberOfDays[i]];
        }
        return values;
    }

    public static void main(String[] args) {
        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();

        System.out.println("Multiplication table");
        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.multiplicationTable(10));


        System.out.println("Triangular matrix");
        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.triangularMatrix(3));

        System.out.println("Values per days");
        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.getValues());
    }
}
