class FindConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0, j = 0, max = 0;
        while (i < nums.length && j < nums.length) {
            if (nums[i] == 0) {
                i++;j++;
            } else if(nums[i] == 1) {
                while(j < nums.length) {
                    if(nums[j] == 1) {
                        j++;
                    } else {
                        break;
                    }
                }
                max = Math.max(max, (j - i));
                System.out.println(String.format("Running Else If: i = %s, j = %s, max = %s",i,j,max));
                i = j;
            }
        }
        max = Math.max(max, j-i);
        System.out.println(String.format("Max: %s", max));
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,0,1,0,1,1,1,1,1,1,1};
        System.out.println(new FindConsecutiveOnes().findMaxConsecutiveOnes(nums));
        for(int i = 0; i < nums.length; i++) {

        }
    }
}