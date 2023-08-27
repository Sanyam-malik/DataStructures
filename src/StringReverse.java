// Problem Statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/176

public class StringReverse {

    // Quick Approach
    public String reverseUsingSB(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }

    // Old Approach
    public String reverseUsingArray(String s){
        StringBuilder sb = new StringBuilder();
        char chArray[] = s.toCharArray();
        for(int index = chArray.length-1; index >=0 ; index--){
            sb.append(chArray[index]);
        }
        return sb.toString();
    }

    public static void main(String args[]){
        StringReverse sr = new StringReverse();
        System.out.println(sr.reverseUsingSB("hello"));
        System.out.println(sr.reverseUsingArray("hello"));
    }

}