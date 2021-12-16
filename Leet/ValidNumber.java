import java.util.ArrayList;
import java.util.List;

class ValidNumber {
    public boolean isNumber(String s) {
        boolean hasSign = s.charAt(0) == '+' || s.charAt(0) == '-';
        boolean hasDecimal = false;
        boolean hasExponent = false;
        boolean hasNumber = false;
        String num = "0123456789";

        for(int i = hasSign?1:0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(temp == '+' || temp == '-'){
                if(hasSign || !hasExponent)return false;
                hasSign = true;
            }else if(temp == 'e' || temp == 'E') {
                if (!exponentHelper(s.substring(i+1)))
                    return false;
                else
                    break;
            }else if(temp == '.'){
                if(hasDecimal)return false;
                hasDecimal = true;
            }else if(num.indexOf(temp) >= 0){
                hasNumber = true;
            }else {
                return false;
            }
        }
        return hasNumber;
    }

    public boolean exponentHelper(String s){
        if(s.length() == 0)return false;
        boolean hasSign = s.charAt(0) == '+' || s.charAt(0) == '-';
        boolean hasNumber = false;
        String num = "0123456789";

        for(int i = hasSign?1:0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(temp == '+' || temp == '-'){
                return false;
            }else if(temp == 'e') {
                return false;
            }else if(temp == '.'){
                return false;
            }else if(num.indexOf(temp) >= 0){
                hasNumber = true;
            }else {
                return false;
            }
        }
        return hasNumber;
    }

    public static void main(String[] args) {
        String[] trueArr = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        String[] falseArr = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53", "6+1", "6+1e15", "459277e38+15"};
        for (String str : falseArr){
            System.out.println(str + " " + new Scratch().isNumber(str));
        }
    }
}