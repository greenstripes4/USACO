import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            int[] leaderIds = new int[26];
            int[] groupSizes = new int[26];
            for(int i = 0; i < 26; i++) {
                leaderIds[i] = i;
                groupSizes[i] = 1;
            }
            String union;
            while((union = f.readLine()).charAt(0) != '*') {
                char a = union.charAt(1);
                char b = union.charAt(3);
                int rootA = a-'A';
                while(rootA != leaderIds[rootA]){
                    leaderIds[rootA] = leaderIds[leaderIds[rootA]];
                    rootA = leaderIds[rootA];
                }
                int rootB = b-'A';
                while(rootB != leaderIds[rootB]){
                    leaderIds[rootB] = leaderIds[leaderIds[rootB]];
                    rootB = leaderIds[rootB];
                }
                if(groupSizes[rootA] < groupSizes[rootB]){
                    leaderIds[rootA] = rootB;
                    groupSizes[rootB] += groupSizes[rootA];
                } else {
                    leaderIds[rootB] = rootA;
                    groupSizes[rootA] += groupSizes[rootB];
                }
            }
            boolean[] exists = new boolean[26];
            String[] verifiedExistances = f.readLine().split(",");
            for(String i: verifiedExistances) {
                exists[i.charAt(0)-'A'] = true;
            }
            int trees = 0;
            int acorns = 0;
            for(int i = 0; i < 26; i++) {
                if(exists[i]) {
                    int root = i;
                    while(root != leaderIds[root]){
                        leaderIds[root] = leaderIds[leaderIds[root]];
                        root = leaderIds[root];
                    }
                    if(groupSizes[root] > 1) {
                        trees++;
                    } else {
                        acorns++;
                    }
                    for(int j = 0; j < 26; j++) {
                        int rootJ = j;
                        while(rootJ != leaderIds[rootJ]){
                            leaderIds[rootJ] = leaderIds[leaderIds[rootJ]];
                            rootJ = leaderIds[rootJ];
                        }
                        if(rootJ == root) {
                            exists[j] = false;
                        }
                    }
                }
            }
            out.println("There are " + trees + " tree(s) and " + acorns + " acorn(s).");
        }
        f.close();
        out.close();
    }
}
