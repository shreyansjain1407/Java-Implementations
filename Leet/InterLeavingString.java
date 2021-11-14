class Scratch {
    //90 test cases passed / 106
    //DP with memoization to be used
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())return false;
        if (s1.length() == 0)
            return s2.equals(s3);
        if (s2.length() == 0)
            return s1.equals(s3);

        int i = 0, j = 0, l = 0;
        while(i < s1.length() && j < s2.length()){
            System.out.println(i + " " + s1.charAt(i) + " " + j + " " + s2.charAt(j) + " " + l + " " + s3.charAt(l));
            if(s3.charAt(l) == s1.charAt(i) && s3.charAt(l) == s2.charAt(j)){
                int i_ini = i, j_ini = j, l_ini = l;
                while(i_ini < s1.length() && s1.charAt(i_ini) == s3.charAt(l_ini)){
                    i_ini++;l_ini++;
                }
                l_ini = l;
                while(j_ini < s2.length() && s2.charAt(j_ini) == s3.charAt(l_ini)){
                    j_ini++;l_ini++;
                }
                if((i_ini - i) >= (j_ini - j)){
//                    System.out.println("i is greater");
                    l = l + (i_ini - i);
                    i = i_ini;
                }else{
//                    System.out.println("j is greater");
                    l = l + (j_ini - j);
                    j = j_ini;
                }
            }else if(s1.charAt(i) == s3.charAt(l)){
                i++;l++;
            }else if(s2.charAt(j) == s3.charAt(l)){
                j++;l++;
            }else{
                return false;
            }

        }
        System.out.println(i);
        System.out.println(j);
        if(i == s1.length()){
            System.out.println(s2.substring(j));
            System.out.println(s3.substring(l));
            return s2.substring(j).equals(s3.substring(l));
        }else if (j == s2.length()){
            System.out.println(s1.substring(i));
            System.out.println(s3.substring(l));
            return s1.substring(i).equals(s3.substring(l));
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println((new Scratch()).isInterleave("aa", "ab", "aaba")); //Failed test case
    }
}