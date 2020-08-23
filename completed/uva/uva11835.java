import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int G = f.nextInt();
            int P = f.nextInt();
            if(G == 0 && P == 0) {
                break;
            }
            int[][] grandPrix = new int[G][P];
            for(int i = 0; i < G; i++) {
                for(int j = 0; j < P; j++) {
                    grandPrix[i][f.nextInt()-1] = j;
                }
            }
            int S = f.nextInt();
            for(int i = 0; i < S; i++) {
                int K = f.nextInt();
                int[] k = new int[K];
                for(int j = 0; j < K; j++) {
                    k[j] = f.nextInt();
                }
                int[] scores = new int[P];
                for(int j = 0; j < G; j++) {
                    for(int l = 0; l < P; l++) {
                        scores[grandPrix[j][l]] += l < K ? k[l] : 0;
                    }
                }
                int maxScore = 0;
                for(int j: scores) {
                    maxScore = Math.max(maxScore,j);
                }
                ArrayList<Integer> worldChampions = new ArrayList<>();
                for(int j = 0; j < P; j++) {
                    if(scores[j] == maxScore) {
                        worldChampions.add(j+1);
                    }
                }
                out.print(worldChampions.get(0));
                for(int j = 1; j < worldChampions.size(); j++) {
                    out.print(" " + worldChampions.get(j));
                }
                out.println();
            }
        }
        f.close();
        out.close();
    }
}