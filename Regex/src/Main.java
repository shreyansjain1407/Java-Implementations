import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String string = "I am a string. Yes, I am";
        System.out.println(string);
        String another = string.replace("I", "You");
        System.out.println(another);

        // ^ Matches the starting of the string
        System.out.println(string.replaceAll("^Shre", "X"));

        String newString = "Abcdefghijklmnopqrstuvwxyz0123456789";
        System.out.println(newString.matches("Abcdefg"));
        System.out.println(newString.matches("A b c d e f g h i j k l m n o p q r s t u v w x y z 0 1 2 3 4 5 6 7 8 9"));

        // $ Matches the ending of the string
        System.out.println(newString.replaceAll("wxyz$", "The End"));

        // Checks for the alphabets that are given within the brackets individually and replaces with the replacement
        System.out.println(newString.replaceAll("[aei]", "X"));

        //To check for a certain character being followed by another
        System.out.println(newString.replaceAll("[aei][jk]", "X"));
        System.out.println(newString.replaceAll("[Hh]arry", "Harry"));

        //To change every letter except for a certain few
        System.out.println(newString.replaceAll("[^Aeiou]", "x"));

        //Replace all accourances of a-d and 0-9
        System.out.println(newString.replaceAll("[a-gA-G0-9]", "X"));

        //Ignore Case Sensitivity (?i)
        System.out.println(newString.replaceAll("(?i)[a-z]", "X"));

        //Replace all numbers in a string
        System.out.println(newString.replaceAll("\\d", "X"));

        //Replace all non-digits \\D
        System.out.println(newString.replaceAll("\\D","X"));

        String whiteSpace = "This is a string with whitespace, \t a tab and new line \n";
        //Replace all whitespaces
        System.out.println(whiteSpace.replaceAll("\\s", ""));
        //Replace all non-whitespaces
        System.out.println(whiteSpace.replaceAll("\\S", ""));

        //Match a-zA-Z0-9_ \\w This does not match any whitespaces
        System.out.println(whiteSpace.replaceAll("\\w", "X"));

        //Special, adds rplacement to the start and end of each word
        System.out.println(whiteSpace.replaceAll("\\b", "X"));

        //String followed by 1 or more e's
        System.out.println(whiteSpace.replaceAll("abcde+", "X"));

        //String followed by 0 or more e's
        System.out.println(whiteSpace.replaceAll("abcde*", "X"));

        //String followed by 2-5 e's
        System.out.println(whiteSpace.replaceAll("abcde{2,5}", "X"));

        StringBuilder stringBuilder = new StringBuilder("<h1> this is sample h1 text<h1>");
        stringBuilder.append("<h1> this is sample h1 text<h1>");
        stringBuilder.append("<h1> this is sample h1 text<h1>");
        stringBuilder.append("<p> this is sample p text<p>");
        stringBuilder.append("<h1> this is sample h1 text<h1>");
        stringBuilder.append("<h1> this is sample h1 text<h1>");

        Pattern pattern = Pattern.compile("<h1>");
        Matcher matcher = pattern.matcher(stringBuilder);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while(matcher.find()){
            count++;
            System.out.println(count + " " + matcher.start() + " " + matcher.end());
        }


    }
}
