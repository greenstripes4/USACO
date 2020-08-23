import java.io.*;
import java.util.*;

public class Main {
    private static boolean inBetween(int kingRow, int kingCol, int queenRow, int queenCol, int nextQueenRow, int nextQueenCol) {
        if(kingCol == queenCol && kingCol == nextQueenCol && kingRow >= Math.min(queenRow,nextQueenRow) && kingRow <= Math.max(queenRow,nextQueenRow)) {
            return true;
        }
        return kingRow == queenRow && kingRow == nextQueenRow && kingCol >= Math.min(queenCol,nextQueenCol) && kingCol <= Math.max(queenCol,nextQueenCol);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(f.hasNext()) {
            int kingPos = f.nextInt();
            int queenPos = f.nextInt();
            int nextQueenPos = f.nextInt();
            int kingRow = kingPos/8;
            int kingCol = kingPos%8;
            int queenRow = queenPos/8;
            int queenCol = queenPos%8;
            int nextQueenRow = nextQueenPos/8;
            int nextQueenCol = nextQueenPos%8;
            if(kingRow == queenRow && kingCol == queenCol) {
                out.println("Illegal state");
            } else if((queenRow == nextQueenRow && queenCol == nextQueenCol) || (queenRow != nextQueenRow && queenCol != nextQueenCol) || inBetween(kingRow,kingCol,queenRow,queenCol,nextQueenRow,nextQueenCol)) {
                out.println("Illegal move");
            } else if((Math.abs(nextQueenRow-kingRow) == 1 && Math.abs(nextQueenCol-kingCol) == 0) || (Math.abs(nextQueenRow-kingRow) == 0 && Math.abs(nextQueenCol-kingCol) == 1)) {
                out.println("Move not allowed");
            } else if((kingRow == 0 && kingCol == 0 && nextQueenRow == 1 && nextQueenCol == 1) || (kingRow == 0 && kingCol == 7 && nextQueenRow == 1 && nextQueenCol == 6) || (kingRow == 7 && kingCol == 0 && nextQueenRow == 6 && nextQueenCol == 1) || (kingRow == 7 && kingCol == 7 && nextQueenRow == 6 && nextQueenCol == 6)) {
                out.println("Stop");
            } else {
                out.println("Continue");
            }
        }
        f.close();
        out.close();
    }
}
