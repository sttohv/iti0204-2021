package ee.ttu.algoritmid.fibonacci;

import java.math.BigInteger;

public class AL01B {
    /**
     * Estimate or find the exact time required to compute the n-th Fibonacci number.
     * @param n The n-th number to compute.
     * @return The time estimate or exact time in YEARS.
     */
    public String timeToComputeRecursiveFibonacci(int n) {
        // TODO
        // F() - rida programmi
        // t(F(42))=t(F(40))*kuldlõige astmel 2  goden ratio = 1.61803398875
        //t(F(n)) = t(f(40)) * (goldenRatio)^(n-40)
        // f(40) == rowBig
        //BigDecimal

        long start = System.nanoTime();
        BigInteger rowsBig = recursiveF(40).multiply(BigInteger.valueOf(3)).subtract(BigInteger.TWO);
        long end = System.nanoTime();
        long time = end - start;


        BigInteger goldenRatio = new BigInteger("1.618");

        BigInteger power = BigInteger.valueOf(goldenRatio.longValue()).pow(n-40);
        BigInteger dif = rowsBig.multiply(goldenRatio);



        return "";
    }

    /**
     * Compute the Fibonacci sequence number recursively.
     * (You need this in the timeToComputeRecursiveFibonacci(int n) function!)
     * @param n The n-th number to compute.
     * @return The n-th Fibonacci number as a string.
     */
    public BigInteger recursiveF(int n) {
        if (n <= 1)
            return BigInteger.valueOf(n);
        return recursiveF(n - 1).add(recursiveF(n - 2));
    }


    public static void main(String[] args) {

    }
}
