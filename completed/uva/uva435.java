import java.io.*;
import java.util.*;

public class Main {
    private static int[] powerIndices;
    private static boolean[] takenParties;
    private static void getPowerIndices(int[] parties, int index, int votes, int half) {
        for(int i = 0; i < parties.length; i++) {
            if(!takenParties[i]) {
                takenParties[i] = true;
                if(votes+parties[i] > half) {
                    powerIndices[i]++;
                } else if(i >= index) {
                    getPowerIndices(parties,i,votes+parties[i],half);
                }
                takenParties[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int P = Integer.parseInt(st.nextToken());
            powerIndices = new int[P];
            takenParties = new boolean[P];
            int[] parties = new int[P];
            int totalVotes = 0;
            for(int i = 0; i < P; i++) {
                parties[i] = Integer.parseInt(st.nextToken());
                totalVotes += parties[i];
            }
            getPowerIndices(parties,0,0,totalVotes/2);
            for(int i = 1; i <= P; i++) {
                out.println("party " + i + " has power index " + powerIndices[i-1]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
