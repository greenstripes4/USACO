import java.io.*;
import java.util.*;

public class Main {
    private static int getIdx(char c) {
        if(c >= 'a' && c <= 'z') {
            return c-'a';
        }
        return c-'A'+26;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] s = f.readLine().toCharArray();
        char[] t = f.readLine().toCharArray();
        int[] occ = new int[52];
        for(char i: t) {
            occ[getIdx(i)]++;
        }
        boolean[] visited = new boolean[s.length];
        int a = 0;
        for(int i = 0; i < s.length; i++) {
            if(occ[getIdx(s[i])] > 0) {
                visited[i] = true;
                a++;
                occ[getIdx(s[i])]--;
            }
        }
        int b = 0;
        for(int i = 0; i < s.length; i++) {
            if(!visited[i]) {
                if(occ[(getIdx(s[i])+26)%52] > 0) {
                    b++;
                    occ[(getIdx(s[i])+26)%52]--;
                }
            }
        }
        out.println(a + " " + b);
        f.close();
        out.close();
    }
}