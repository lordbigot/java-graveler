import java.util.Random;
import java.math.BigInteger;
import java.lang.Math;
import java.time.Clock;

public class Project {

    static int ROLLS = 1000000000;

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Random r = new Random(startTime);

        BigInteger a = new BigInteger(462, r);
        for (int i=0;i<ROLLS-1;++i) {
            BigInteger b = new BigInteger(462, r);
            a = a.max(b);
        }

        BigInteger p = BigInteger.valueOf(0);
        BigInteger c = BigInteger.valueOf(1);
        int i = 0;

        for (;i<=231;++i) {
            p = p.add(c.multiply(BigInteger.valueOf(3).pow(231-i)));
            if (a.compareTo(p) <= 0) {break;}
            c = c.multiply(BigInteger.valueOf(231-i)).divide(BigInteger.valueOf(1+i));
        }

        System.out.println(String.format("Attempts made: %d", ROLLS));
        System.out.println(String.format("Most paralysis activations: %d", i));

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(String.format("%d ms", totalTime));
    }
}