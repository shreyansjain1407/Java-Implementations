public class FindNumbers {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            // Another better time solution online
            // int digits = (int) Math.log10(num) + 1;

            // My Solution
            int curCount = 0;
            while(num != 0) {
                num /= 10;
                curCount++;
            }

            // Common in both solutions
            if (curCount % 2 == 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,11,111,1111,11111};
        System.out.println(new FindNumbers().findNumbers(nums));
        System.out.println((int)Math.log(10) + 1);
        double x = 2.99;
        System.out.println((int) x);
    }
}
