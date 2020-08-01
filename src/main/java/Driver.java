import java.util.Arrays;
import java.util.HashSet;

public class Driver {
    public boolean detectCapitalUse(String word) {
        HashSet<Character> uppercaseLetters = new HashSet<Character>(28);
        HashSet<Character> lowercaseLetters = new HashSet<Character>(28);

        for(char tmp = 'a'; tmp <= 'z'; tmp++){
            lowercaseLetters.add(tmp);
            uppercaseLetters.add(Character.toUpperCase(tmp));
        }

        if(word.length() <= 1){
            return true;
        }

        if(uppercaseLetters.contains(word.charAt(0))){
            Character tmp = word.charAt(1);
            if (lowercaseLetters.contains(tmp)) {
                // or only first letter is uppercase and all the other letters have to be lowercase
                for(int i =1;i<word.length();i++){
                    Character tmp2 = word.charAt(i);
                    if(!lowercaseLetters.contains(tmp2)){
                        return false;
                    }
                }
            }else{
                // all have to be capitalized
                for(int i =0;i<word.length();i++){
                    Character tmp2 = word.charAt(i);
                    if(!uppercaseLetters.contains(tmp2)){
                        return false;
                    }
                }
            }
        }else{
            // or all have to be lowercase
            for(int i =0;i<word.length();i++){
                Character tmp = word.charAt(i);
                if(!lowercaseLetters.contains(tmp)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        {
            Driver d = new Driver();
            String tmp = "USA";
            boolean answer = d.detectCapitalUse(tmp);
            System.out.println(answer); // true
        }
        {
            Driver d = new Driver();
            String tmp = "leetcode";
            boolean answer = d.detectCapitalUse(tmp);
            System.out.println(answer); // true
        }
        {
            Driver d = new Driver();
            String tmp = "Google";
            boolean answer = d.detectCapitalUse(tmp);
            System.out.println(answer); // true
        }
        {
            Driver d = new Driver();
            String tmp = "FlaG";
            boolean answer = d.detectCapitalUse(tmp);
            System.out.println(answer); // false
        }
        {
            Driver d = new Driver();
            String tmp = "T";
            boolean answer = d.detectCapitalUse(tmp);
            System.out.println(answer); // true
        }
    }
}
