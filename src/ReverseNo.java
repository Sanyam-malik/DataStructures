//Problem Statment: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/470

public class ReverseNo {
    
    public Integer reverseNumber(Integer n) {
        int reverse = 0;
        int temp = n;
        while(temp > 0){
            // temp%10 gives us remainder;
            reverse=reverse*10+(temp%10);
            // Removes last element;
            temp = temp/10;
        }
        return reverse;
    }

    public static void main(String a[]) {
        ReverseNo s = new ReverseNo();
        System.out.println(s.reverseNumber(248));
    }

}