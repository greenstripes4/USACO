import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("cereal.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] preferences = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            preferences[i][0] = Integer.parseInt(st.nextToken())-1;
            preferences[i][1] = Integer.parseInt(st.nextToken())-1;
        }
        int[] taken = new int[M];
        Arrays.fill(taken, -1);
        int[] removed = new int[N];
        int count = 0;
        for(int i = N-1; i >= 0; i--) {
            int change = preferences[i][0];
            int replacement = i;
            boolean lastChange = true;
            while(taken[change] >= 0) {
                int old = taken[change];
                if(old < replacement) {
                    lastChange = false;
                    break;
                }
                taken[change] = replacement;
                if(change == preferences[old][0]) {
                    change = preferences[old][1];
                    replacement = old;
                } else {
                    count--;
                    break;
                }
            }
            if(lastChange) {
                taken[change] = replacement;
                count++;
            }
            removed[i] = count;
        }
        for(int i: removed) {
            out.println(i);
        }
        f.close();
        out.close();
    }
}
