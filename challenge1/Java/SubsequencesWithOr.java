import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution {
    
    private static int subsqWithOrCnt(List<Integer> integers, int idx, int xorVal, List<Integer> path) {
        if (idx >= integers.size()){
            // no point continuing. 
            // return 1 or 0;
            if (path.size() == 0) {
                return 0;
            }
            
            int accXorVal = path.get(0);
            for (int i = 1; i < path.size(); i++){
                accXorVal |= path.get(i);
            }
            
            return accXorVal == xorVal ? 1 : 0;
        }
        
        int cnt = subsqWithOrCnt(integers, idx + 1, xorVal, path);
        path.add(integers.get(idx));
        cnt += subsqWithOrCnt(integers, idx + 1, xorVal, path);
        path.remove(integers.get(idx));
        
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        // n and X
        String[] firstLineInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstLineInput[0]);
        int x = Integer.parseInt(firstLineInput[1]);
        
        List<Integer> integers = new ArrayList<>();

         try {
            integers = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
                       
        int result = subsqWithOrCnt(integers, 0, x, new ArrayList<>());
     
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}