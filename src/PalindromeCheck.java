// Problem Statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/177

public class PalindromeCheck {

    // Quick Approach
    public boolean checkUsingSB(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return s.equalsIgnoreCase(sb.toString());
    }

    // Old Approach
    public boolean checkUsingArray(String s){
        char chArray[] = s.toCharArray();
        int startIdx = 0;
        int endIdx = chArray.length-1;
        while(startIdx < endIdx && endIdx > -1 && startIdx != endIdx){
            if(chArray[startIdx] != chArray[endIdx]) {
                return false;
            }
            startIdx++;
            endIdx--;
        }
        
        return true;
    }

    public static void main(String args[]){
        PalindromeCheck sr = new PalindromeCheck();
        String s= "c1 O$d@eeD o1c".replace(" ", "");
        System.out.println("Is palindrome: "+sr.checkUsingSB(s));
        System.out.println("Is palindrome: "+sr.checkUsingArray(s));
    }

}