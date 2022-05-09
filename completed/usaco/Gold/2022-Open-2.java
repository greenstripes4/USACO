import java.io.*;
import java.util.*;

public class Main {
    private static String solve(char[] ex) {
        TreeMap<Character, Integer> occ = new TreeMap<>();
        char cur = 'a';
        for(char i: ex) {
            if(i == '+') {
                occ.put(cur++, 1);
            } else {
                for(char j: occ.keySet()) {
                    occ.replace(j, occ.get(j)*(i-'0'));
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for(char i: occ.keySet()) {
            if(occ.get(i) > 0) {
                res.append(occ.get(i));
                res.append(i);
                res.append("+");
            }
        }
        return res.toString();
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(f.readLine());
            char[] b = f.readLine().toCharArray();
            char[] e = f.readLine().toCharArray();
            HashSet<String> set = new HashSet<>();
            for(int i = 0; i < (1 << (N << 1)); i++) {
                if(Integer.bitCount(i) == N) {
                    char[] res = new char[N << 1];
                    int idx1 = 0;
                    int idx2 = 0;
                    for(int j = 0; j < (N << 1); j++) {
                        res[j] = (i&(1 << j)) == 0 ? b[idx1++] : e[idx2++];
                    }
                    set.add(solve(res));
                }
            }
            out.println(set.size());
        }
        f.close();
        out.close();
    }
}