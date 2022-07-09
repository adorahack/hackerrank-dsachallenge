import java.io.*;
import java.util.*;

public class Solution {
    
    private static String canFindBob(String[][] grid){
        int[] alicePos = findAlicePos(grid);
        return canFindBob(alicePos[0], alicePos[1], grid) ? "YES" : "NO";
    }
    
    private static int[] findAlicePos(String[][] grid){
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if ("A".equals(grid[i][j])){
                    return new int[]{i, j};
                }
            }
        }
        
        return new int[]{-1, -1};
    }
    
    private static boolean canFindBob(int r, int c, String[][] grid){
        if (r < 0 || r >= grid.length){
            return false;
        }
        
        if (c < 0 || c >= grid[r].length){
            return false;
        }
        
        if ("#".equals(grid[r][c])){
            return false;
        }
        
        if ("B".equals(grid[r][c])){
            return true;
        }
        
        return canFindBob(r + 1, c, grid) || canFindBob(r, c + 1, grid);
    }
    
    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //n = rows, m = cols
        String[] firstLineInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstLineInput[0]);
        int m = Integer.parseInt(firstLineInput[1]);
        
        String[][] grid = new String[n][m];
        for(int i = 0; i < n; i++){
            grid[i] = bufferedReader.readLine().replaceAll("\\s+$", "").split("");
        }
        
        String result = canFindBob(grid);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

    }
}