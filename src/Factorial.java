//Problem Statement: http://lordmaximus.duckdns.org/data-structures/practice/-/issues/87
public class Factorial {

    // Recursive Method
    public Integer findFactorialRecursive(Integer n) {
        if(n == 1) { return 1;}
        return n*findFactorialRecursive(n-1);
    }

    // Iterative Method
    public Integer findFactorialIterative(Integer n) {
        int fact = n;
        while(n > 1) {
            fact*= n-1;
            n--;
        }
        return fact;
    }

    public static void main(String a[]) {
        Factorial s = new Factorial();
        System.out.println(s.findFactorialIterative(3));
        System.out.println(s.findFactorialRecursive(3));
    }
}
