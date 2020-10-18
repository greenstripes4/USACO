import java.io.*;
import java.util.*;

public class Main{
    private static int cnt;
    private static boolean solve(TreeSet<Character>[] result, char[] permutation, int ind, int K, PrintWriter out) {
        if(ind == 5) {
            cnt++;
            if(cnt == K) {
                out.println(permutation);
                return true;
            }
            return false;
        }
        boolean found = false;
        for(char i: result[ind]) {
            permutation[ind] = i;
            found |= solve(result, permutation, ind+1, K, out);
        }
        return found;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            int K = Integer.parseInt(f.readLine());
            char[][] first = new char[6][];
            for(int i = 0; i < 6; i++) {
                first[i] = f.readLine().toCharArray();
            }
            char[][] second = new char[6][];
            for(int i = 0; i < 6; i++) {
                second[i] = f.readLine().toCharArray();
            }
            TreeSet<Character>[] result = new TreeSet[5];
            for(int i = 0; i < 5; i++) {
                result[i] = new TreeSet<>();
                for(int j = 0; j < 6; j++) {
                    for(int k = 0; k < 6; k++) {
                        if(first[j][i] == second[k][i]) {
                            result[i].add(first[j][i]);
                            break;
                        }
                    }
                }
            }
            cnt = 0;
            if(!solve(result, new char[5], 0, K, out)) {
                out.println("NO");
            }
        }
        f.close();
        out.close();
    }
}
