import java.util.*;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
//                System.out.print(matrix[i][j] + "");
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
//            System.out.println("");
        }
//        System.out.println(" ");
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
//                System.out.print(matrix[i][j] + "");
            }
//            System.out.println("");
        }

    }

    public static void main(String[] args) {
        SetMatrixZeroes x = new SetMatrixZeroes();
//        [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        int[][] arr = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        x.setZeroes(arr);
    }
}
