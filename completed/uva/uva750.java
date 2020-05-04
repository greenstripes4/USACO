import java.io.*;
import java.util.*;

public class Main{
    private static int[] rows;
    private static int solutionNumber;
    private static void solve(int r, PrintWriter out){
        if(r == 9){
            if(solutionNumber < 10){
                out.print(" ");
            }
            out.print(solutionNumber + "      ");
            for(int i = 1; i <= 8; i++){
                if(i > 1){
                    out.print(" ");
                }
                out.print(rows[i]);
            }
            out.println();
            solutionNumber++;
            return;
        }
        if(rows[r] > 0){
            solve(r+1,out);
            return;
        }
        for(int c = 1; c <= 8; c++){
            if(isValid(r,c)){
                rows[r] = c;
                solve(r+1,out);
                rows[r] = 0;
            }
        }
    }
    private static boolean isValid(int r, int c){
        for(int i = 1; i <= 8; i++){
            if(rows[i] > 0 && (rows[i] == c || Math.abs(r-i) == Math.abs(c-rows[i]))){
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
            if(i > 0){
                out.println();
            }
            int c = f.nextInt();
            int r = f.nextInt();
            rows = new int[9];
            solutionNumber = 1;
            rows[r] = c;
            out.println("SOLN       COLUMN");
            out.println(" #      1 2 3 4 5 6 7 8");
            out.println();
            solve(1,out);
        }
        f.close();
        out.close();
    }
}
