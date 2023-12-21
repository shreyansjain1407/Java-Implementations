import java.util.Arrays;

public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int[] output = new int[nums.length];
//        Naive Solution
//        for (int i = 0; i < nums.length; i++) {
//            output[i] = nums[i] * nums[i];
//        }
//        Arrays.sort(output);

        // 2 Pointer Solution
        int left = 0, right = nums.length - 1;
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                output[i] = nums[right]*nums[right];
                right--;
            } else {
                output[i] = nums[left]*nums[left];
                left++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {-8, -7, -2, 0, 1, 4, 9, 11};
        int[] output = new SortedSquares().sortedSquares(nums);
        System.out.print("[");
        for (int num: output) {
            System.out.print(" " + num + " ");
        }
        System.out.print("]");
    }
}
