import java.io.*;
import java.util.*;

public class Main{
    private static char[] elements = {'A','C','G','T'};
    private static TreeSet<String> mutations;
    private static void mutate(int N, int K, char[] DNA, int currentMutation) {
        mutations.add(new String(DNA));
        if(currentMutation == K) {
            return;
        }
        for(int i = 0; i < N; i++) {
            for(char j: elements) {
                if(DNA[i] != j) {
                    char original = DNA[i];
                    DNA[i] = j;
                    mutate(N, K, DNA, currentMutation+1);
                    DNA[i] = original;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            char[] originalDNA = f.readLine().toCharArray();
            mutations = new TreeSet<>();
            mutate(N, K, originalDNA, 0);
            out.println(mutations.size());
            for(String i: mutations) {
                out.println(i);
            }
        }
        f.close();
        out.close();
    }
}
