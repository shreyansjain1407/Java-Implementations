import java.util.Arrays;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        for(int i = 0; i < arr.length; i++)
            if (arr[i] != 0)
                break;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                System.out.println("Before: " + Arrays.toString(arr));
                for(int j = arr.length-1; j > i; j--) {
                    arr[j] = arr[j-1];
                }
                System.out.println("After: " + Arrays.toString(arr));
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,0,2,3,0,4,5,0};
        new DuplicateZeros().duplicateZeros(nums);

        int ind = 0;
        for(int i = 0; i < 15; i++){
            System.out.println("I: " + i + " Ind: " + ind++);
        }
    }
}
