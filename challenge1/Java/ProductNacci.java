import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.math.BigInteger;

public class Solution {

    private static BigInteger productNacci(BigInteger p0, BigInteger p1, int n, BigInteger x) {
        if (n == 0) {
            return p0;
        }

        if (n == 1) {
            return p1;
        }

        return productNacci(p0, p1, 2, n, x);
    }

    private static BigInteger productNacci(BigInteger prevPrev, BigInteger prev, int currN, int maxN, BigInteger x) {
        if (currN > maxN) {
            return prev;
        }

        BigInteger currVal = prev.multiply(prevPrev).mod(x);
        return productNacci(prev, currVal, currN + 1, maxN, x);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> intInput = new ArrayList<>();

        try {
            intInput = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                       .map(Integer::parseInt)
                       .collect(toList());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        BigInteger p0 = BigInteger.valueOf(intInput.get(0));
        BigInteger p1 = BigInteger.valueOf(intInput.get(1));
        int n = intInput.get(2);
        BigInteger x = BigInteger.valueOf(intInput.get(3));

        BigInteger result = productNacci(p0, p1, n, x);

        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}