import java.io.*;
import java.util.*;

public class Main{
    private static int[] curFormation;
    private static int[] rows;
    private static int ind;
    private static int[][] allSolutions;
    private static int getMoves(int[] transformation){
        int moves = 0;
        for(int i = 0; i < 8; i++){
            if(curFormation[i] != transformation[i]){
                moves++;
            }
        }
        return moves;
    }
    private static void getSolutions(int r){
        if(r == 8){
            allSolutions[ind] = rows.clone();
            ind++;
            return;
        }
        for(int c = 0; c < 8; c++){
            if(isValid(r,c)){
                rows[r] = c;
                getSolutions(r+1);
                rows[r] = -1;
            }
        }
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
        ind = 0;
        rows = new int[8];
        Arrays.fill(rows,-1);
        allSolutions = new int[92][8];
        getSolutions(0);
        int caseNumber = 1;
        while(f.hasNext()){
            curFormation = new int[]{f.nextInt()-1,f.nextInt()-1,f.nextInt()-1,f.nextInt()-1,f.nextInt()-1,f.nextInt()-1,f.nextInt()-1,f.nextInt()-1};
            int minMoves = Integer.MAX_VALUE;
            for(int[] i: allSolutions){
                minMoves = Math.min(minMoves,getMoves(i));
            }
            out.println("Case " + caseNumber + ": " + minMoves);
            caseNumber++;
        }
        f.close();
        out.close();
    }
}
