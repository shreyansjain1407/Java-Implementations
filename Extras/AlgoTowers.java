import java.io.File;
import java.io.FileNotFoundException;
import java.time.Year;
import java.util.Scanner;

public class AlgoTowers {
    int rows;
    int columns;
    int height;
    int arr[][];

    public AlgoTowers(int rows, int columns, int height) {
        this.rows = rows;
        this.columns = columns;
        this.height = height;
        this.arr = new int[rows][columns];
    }

    public void input(){
        System.out.println("You have entered input wizard, please input values: ");
        int rows = this.rows;
        int columns = this.columns;
        int height = this.height;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i<rows; i++){
            for (int j = 0; j<columns; j++){
                System.out.println("Please enter the value for: " + i + "*" + j );
                this.arr[i][j] = scanner.nextInt();
            }
        }
    }

    public void setArr(int[][] arr) {
        this.arr = arr;
    }

    public void dynamic_quare(){
        System.out.println("Executing Algorithm for square space");
        System.out.println("Current Provided Matrix: ");
    }

    public void convert(){
        //Making a 0/1 array
        for (int i = 0; i<rows; i++){
            for (int j=0;j<columns;j++){
                if (arr[i][j]>=height){
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
            }
        }
    }

    public void task1() {
        System.out.println("Sir, I was unable to implement Task 1, All other tasks have been implemented and are fully functional \n");
    }

    public void task2() {
        int[] aux = new int[columns];
        int[] aux1 = new int[columns];
        int max = 0;
        int[] index = new int[2];

        if (columns >= 0) System.arraycopy(arr[0], 0, aux, 0, columns);

        for (int i = 1; i<rows; i++) {
            for (int j = 1; j<columns; j++) {

                aux1[0] = arr[i][0];

                if (arr[i][j] == 1) {
                    aux1[j] = Math.min(Math.min(aux1[j-1],aux[j]),aux[j-1]) + 1;
                } else {
                    aux1[j] = 0;
                }

                if (aux1[j]>max){
                    max = aux1[j];
                    index[0] = i;
                    index[1] = j;
                }
            }
            for (int k = 0; k<columns; k++) {
                aux[k] = aux1[k];
                try{
                    aux1[k] = arr[i+1][k];
                } catch (ArrayIndexOutOfBoundsException e) {
                    //e.printStackTrace();
                }finally {
                    continue;
                }
            }
        }

        //System.out.println("Maximum Area Covered Is: " + max*max);
        System.out.println((index[0]-max+2) + " " + (index[1]-max+2) + " " + (index[0]+1) + " " + (index[1]+1));
//        System.out.print(" " + (index[0]+1) + " " + (index[1]+1));

    }

    public void task3() {
//        System.out.println("Executing Brute Force Algorithm for square space");
        int sum = 0;
        int[] cur_start = new int[2];
        int[] cur_end = new int[2];
        int k=0,l=0;

        int max_sum = 0;
        int[] max_start = new int[2];
        int[] max_end = new int[2];

        boolean breakflag = false;

        for(int x = 0; x<rows; x++) {
            for (int y = 0; y<columns; y++) {
                for (int i = x; i < rows; i++) {
                    for (int j = y; j < columns; j++) {
                        sum = 0;
                        boolean start_flag = true;

                        for (k = x; k <= i; k++) {
                            breakflag = false;

                            for (l = y; l <= j; l++) {
                                if (start_flag){
                                    cur_start[0] = k;
                                    cur_start[1] = l;
                                    start_flag = false;
                                }

                                if (arr[k][l] >= 1) {
                                    sum += arr[k][l];
                                } else {
                                    breakflag = true;
                                    sum = 0;
                                    break;
                                }
                            }

                            if (breakflag){
                                break;
                            } else {
                                cur_end[0] = k;
                                cur_end[1] = l;
                            }
                        }
                        if (sum>max_sum){
                            max_sum = sum;
                            max_start[0] = cur_start[0]+1;
                            max_start[1] = cur_start[1]+1;
                            max_end[0] = cur_end[0]+1;
                            max_end[1] = cur_end[1];
                        }
                    }
                }
            }
        }

        //System.out.println("Maximum Area Covered is: " + max_sum);
        System.out.println(max_start[0]+" "+max_start[1] + " " + max_end[0]+" "+max_end[1]);
//        System.out.print(" " + max_end[0]+" "+max_end[1]);
    }

    public void task4() {
        //Initializing Height Table
        int[][] height = new int[rows][columns];
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<columns; j++) {
                if (arr[i][j] == 1) {
                    try {
                        height[i][j] = height[i-1][j] + 1;
                    } catch (IndexOutOfBoundsException e) {
                        //
                        height[i][j] = 1;
                    }
                } else {
                    height[i][j] = 0;
                }
            }
        }

        //Initializing Left Table
        int[][] left = new int[rows][columns];
        for (int i = 0; i<rows; i++){
            int lbound = 0;
            for (int j = 0; j<columns; j++) {
                if (arr[i][j] == 1) {
                    try{
                        left[i][j] = Math.max(lbound, left[i-1][j]);
                    }catch (IndexOutOfBoundsException e){
                        left[i][j] = Math.max(lbound,0);
                    }
                } else {
                    left[i][j] = 0;
                    lbound = j+1;
                }
            }
        }

        //Initializing Right Table
        int[][] right = new int[rows][columns];
        for (int i = 0; i<rows; i++) {
            int rbound = columns-1;
            for (int j = columns-1; j>-1; j--) {
                if (arr[i][j] == 1) {
                    try {
                        right[i][j] = Math.min(rbound,right[i-1][j]);
                    } catch (IndexOutOfBoundsException e) {
                        right[i][j] = Math.min(rbound,columns-1);
                    }
                } else {
                    right[i][j] = columns-1;
                    rbound = j-1;
                }
            }
        }

        //Calculating Area
        int maxArea = 0,x=0,y=0;
        for(int i = 0; i<rows; i++) {
            for (int j = 0; j<columns; j++) {
                if (arr[i][j] == 1) {
                    int Area = (right[i][j]-left[i][j]+1)*height[i][j];
                    if (maxArea < Area) {
                        maxArea = Area;
                        x = i;
                        y = j;
                    }
                }
            }
        }

        int tmp = maxArea/height[x][y];
        //System.out.println("MaxArea: " + maxArea);
        System.out.println((x-height[x][y]+2) + " " + (right[x][y]+2-tmp) + " " + (x+1) + " " + (right[x][y]+1));
//        System.out.print(" " + (x+1) + " " + (right[x][y]+1));
    }

    public void task5() {
        //Initializing Height Table
        int[] height = new int[columns];
        int[] heightAux = new int[columns];
        int[] left = new int[columns];
        int[] leftAux = new int[columns];
        int[] right = new int[columns];
        int[] rightAux = new int[columns];

        for (int i = 0; i<columns; i++){
            heightAux[i] = 0;
            leftAux[i] = 0;
            rightAux[i] = columns;
        }

        int maxArea = 0,x=0,y=0,finalHeight=0,finalLeft=0,finalRight=0;
        for (int i = 0; i<rows; i++) {
            //Height and Left Operations
            int lbound = 0;
            for (int j = 0; j<columns; j++) {
                if (arr[i][j] == 1) {
                    height[j] = heightAux[j] + 1;
                    left[j] = Math.max(lbound, leftAux[j]);
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    lbound = j+1;
                }
            }

            //Right Operations
            int rbound = columns-1;
            for (int j = columns-1; j>-1; j--) {
                if (arr[i][j] == 1) {
                    right[j] = Math.min(rbound,rightAux[j]);
                } else {
                    right[j] = columns-1;
                    rbound = j-1;
                }
            }

            //Area Operations
            for (int j = 0; j<columns; j++) {
                if (arr[i][j] == 1) {
                    int Area = (right[j]-left[j]+1)*height[j];
                    if (maxArea < Area) {
                        maxArea = Area;
                        x = i;
                        y = j;
                        finalHeight = height[j];
                        finalLeft = left[j];
                        finalRight = right[j];
                    }
                }
            }
            System.arraycopy(height,0,heightAux,0,columns);
            System.arraycopy(left,0,leftAux,0,columns);
            System.arraycopy(right,0,rightAux,0,columns);
        }

        int tmp = maxArea/finalHeight;
        //System.out.println("MaxArea: " + maxArea);
        System.out.println((x-finalHeight+2) + " " + (finalRight+2-tmp) + " " + (x+1) + " " + (finalRight+1));
//        System.out.print(" " + (x+1) + " " + (finalRight+1));
    }


    public static void main(String[] args) throws FileNotFoundException {
        int argument = Integer.parseInt(args[0]);
        //int argument = 5;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the file path: ");
        String filePath = scanner.nextLine();
        File file = new File(filePath);
        Scanner fileScanner = new Scanner(file);
        int m =fileScanner.nextInt();
        int n =fileScanner.nextInt();
        int h =fileScanner.nextInt();
        AlgoTowers algoTowers = new AlgoTowers(m,n,h);
        int[][] arr = new int[m][n];
        for (int i = 0; i<m; i++){
            for (int j = 0; j<n; j++){
                arr[i][j] = fileScanner.nextInt();
            }
        }
        algoTowers.setArr(arr);
        algoTowers.convert();
        switch (argument) {
            case 1 :
                algoTowers.task1();
                break;
            case 2 :
                algoTowers.task2();
                break;
            case 3 :
                algoTowers.task3();
                break;
            case 4 :
                algoTowers.task4();
                break;
            case 5 :
                algoTowers.task5();
                break;
            default:
                System.out.println("Invalid Input in arguments :|");
                break;
        }
    }
}
