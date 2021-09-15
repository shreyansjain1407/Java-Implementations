import java.util.Scanner;
import java.util.*;

import java.util.Random;
// JAVA Code for Maximum size square
// sub-matrix with all 1s
public class GFG
{
    // method for Maximum size square sub-matrix with all 1s
    static void printMaxSubSquare(int M[][])
    {
        int i,j;
        int R = M.length;		 //no of rows in M[][]
        int C = M[0].length;	 //no of columns in M[][]
        int S[][] = new int[R][C];

        int max_of_s, max_i, max_j;

        /* Set first column of S[][]*/
        for(i = 0; i < R; i++)
            S[i][0] = M[i][0];

        /* Set first row of S[][]*/
        for(j = 0; j < C; j++)
            S[0][j] = M[0][j];

        /* Construct other entries of S[][]*/
        for(i = 1; i < R; i++)
        {
            for(j = 1; j < C; j++)
            {
                if(M[i][j] == 0)
                    S[i][j] = Math.max(S[i][j-1],
                            Math.max(S[i-1][j], S[i-1][j-1]))-1;

                else
                    S[i][j] = 1;
            }
        }


		System.out.println("matrix is: ");
		for(i = 0; i <R; i++)
		{
			for(j = 0; j <C; j++)
			{
				System.out.print(S[i][j] + " ");

			}
			System.out.println();

		}

		/* Find the maximum entry, and indexes of maximum entry
			in S[][] */
        max_of_s = S[0][0]; max_i = 0; max_j = 0;
        for(i = 0; i < R; i++)
        {
            for(j = 0; j < C; j++)
            {
                if(max_of_s > S[i][j])
                {
                    max_of_s = S[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
        }
        int x=0;

        //System.out.println(max_of_s);
        System.out.println(max_i);
        System.out.println(max_j);

        max_of_s = (max_of_s*-1)+1;

        System.out.println("Maximum 0's sub-matrix is: ");
        for(i = max_i; i > max_i - max_of_s; i--)
        {
            for(j = max_j; j > max_j - max_of_s; j--)
            {
                System.out.print(M[i][j] + " ");

            }
            System.out.println();
            x=x+1;
        }
        System.out.println("size of sub-matrix is: "+(x)+"*"+(x));
    }



    static void create_data(int choice)
    {
        int i=0;
        int j=0;
        if(choice==1)
        {
            i=10;
            j=10;

        }
        else if(choice==2)
        {
            i=10;
            j=100;
        }
        else if(choice==3)
        {
            i=10;
            j=1000;

        }
        else if(choice==4)
        {
            i=100;
            j=1000;
        }
        else if(choice==5)
        {
            i=1000;
            j=1000;
        }
        else
        {
            System.out.println("Invalid input");
        }
        int arr[][];    //declaring array
        arr = new int[i][j];  // allocating memory to array
        System.out.println( "\n\nMatrix is: ");
        for(int s=0;s<i;s++)
        {
            for(int t=0; t<j;t++)
            {
                // create random object
                Random randomno = new Random();

                // get next next boolean value
                Boolean value = randomno.nextBoolean();

                // check the value
                int val = (value) ? 1 : 0;
                arr[s][t]= val;
                System.out.print(arr[s][t] + " ");
            }
            System.out.println();

        }


        printMaxSubSquare(arr);

    }


    // Driver program
    public static void main(String[] args)
    {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("\n\n1.10 × 10 matrix\n2. 10 × 100 matrix\n3. 10 × 1000 matrix\n4. 100 × 1000 matrix\n5. 1000 × 1000 matrix \n\nEnter choice");
        int choice = myObj.nextInt();
        create_data(choice);

        myObj.close();
    }

}

