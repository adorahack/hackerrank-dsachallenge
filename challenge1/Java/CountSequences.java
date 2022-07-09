import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution {
    
    private static int countSequences(int idx, int currSum, int targetSum, List<List<Integer>> numRanges){
        if (idx >= numRanges.size()){
            if (currSum == targetSum){
                return 1;
            }
            
            return 0;
        }
        
        int l = numRanges.get(idx).get(0);
        int r = numRanges.get(idx).get(1);
        
        int cnt = 0;
        for(int i = l; i <= r; i++){
            // if currSum + i > targetSum then don't bother
            cnt += countSequences(idx + 1, currSum + i, targetSum, numRanges);
        }
        
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // n and S
        String[] firstLineInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstLineInput[0]);
        int s = Integer.parseInt(firstLineInput[1]);
        
        List<List<Integer>> numRanges = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> {
            try {
                numRanges.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        
        int result = countSequences(0, 0, s, numRanges);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}