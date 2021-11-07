class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0)return 0;
        long x = 0;
        String numeric = "0123456789";
        
        int i = 0;
        boolean negative = false;
        if(s.charAt(0) == '-'){
            negative = true;
            i++;
        }else if(s.charAt(0) == '+'){
            i++;
        }
        while(i < s.length()){
            if(numeric.indexOf(s.charAt(i))>=0){
                x = x*10 + (s.charAt(i) - '0');
            }else{
                break;
            }
            if(x > Integer.MAX_VALUE){
                if(negative)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
            i++;
        }
        if(x > Integer.MAX_VALUE){
            if(negative)
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }else{
            if(negative)
                return (int)(x * -1);
            else
                return (int) x;
        }
    }
}