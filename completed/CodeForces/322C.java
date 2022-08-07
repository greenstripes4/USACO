import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        char[] s = f.readLine().toCharArray();
        int[] cur = new int[2];
        int[][] res = new int[s.length+1][2];
        for(int i = 0; i < s.length; i++) {
            if(s[i] == 'U') {
                cur[1]++;
            } else if(s[i] == 'R') {
                cur[0]++;
            } else if(s[i] == 'D') {
                cur[1]--;
            } else {
                cur[0]--;
            }
            res[i][0] = a-cur[0];
            res[i][1] = b-cur[1];
        }
        res[s.length][0] = a;
        res[s.length][1] = b;
        boolean flag = false;
        for(int[] i: res) {
            int temp = cur[0] == 0 ? cur[1] == 0 ? 0 : i[1]/cur[1] : i[0]/cur[0];
            if(temp >= 0 && cur[0]*temp == i[0] && cur[1]*temp == i[1]) {
                flag = true;
                break;
            }
        }
        out.println(flag ? "Yes" : "No");
        f.close();
        out.close();
    }
}