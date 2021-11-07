class Solution {
    public String longestPalindrome(String s) {
        int max = 0, x = 0;
        for(int i = 0; i < s.length(); i++){
            int curMax = palindromeLength(i,s);
            
            if(curMax > max){
                max = curMax;
                x = i;
                // System.out.println(curMax + " " + x);
            }
        }
        // System.out.println("Max: " + max + " Index: " + x);
        
        if(max % 2 == 0){
            // System.out.println("Left " + (x - (max/2) + 1) + " Right " + (x + (max/2) + 1));
            String out = s.substring(x - (max/2) + 1,x + (max/2) + 1);
            return out;
        }else{
            // System.out.println("Left " + (x - (max/2)) + " Right " + (x + (max/2) + 1));
            String out = s.substring(x - (max/2),x + (max/2) + 1);
            return out;
        }
    }
    
    public int palindromeLength(int i, String s){
        int maxOdd = 1, maxEven = 0, left = i-1, right = i+1;
        while(left >= 0 && right < s.length()){
            if(s.charAt(left) == s.charAt(right))
                maxOdd += 2;
            else
                break;
            left--;right++;
        }
        if(s.length() > i+1){
            left = i;right = i+1;
            while(left >= 0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right))
                    maxEven += 2;
                else
                    break;
                left--;right++;
            }
        }
        return (maxOdd > maxEven)? maxOdd : maxEven;
    }
}