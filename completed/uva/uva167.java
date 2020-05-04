import java.io.*;
import java.util.*;

public class Main{
    private static int[][] values;
    private static int[] rows;
    private static int solve(int r, int score){
        if(r == 8){
            return score;
        }
        int maxScore = 0;
        for(int c = 0; c < 8; c++){
            if(isValid(r,c)){
                rows[r] = c;
                score += values[r][c];
                maxScore = Math.max(maxScore,solve(r+1,score));
                rows[r] = -1;
                score -= values[r][c];
            }
        }
        return maxScore;
    }
    private static boolean isValid(int r, int c){
        for(int i = 0; i < 8; i++){
            if(rows[i] >= 0 && (rows[i] == c || Math.abs(r-i) == Math.abs(c-rows[i]))){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int k = f.nextInt();
        for(int i = 0; i < k; i++){
            values = new int[8][8];
            for(int r = 0; r < 8; r++){
                for(int c = 0; c < 8; c++){
                    values[r][c] = f.nextInt();
                }
            }
            rows = new int[8];
            Arrays.fill(rows,-1);
            out.printf("%1$5s\n", solve(0,0));
        }
        f.close();
        out.close();
    }
}
