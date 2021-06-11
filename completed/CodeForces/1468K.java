import java.io.*;
import java.util.*;

public class Main {
    private static int[] next(int[] cur, char dir, int[] block) {
        int[] res = {cur[0], cur[1]};
        if(dir == 'L') {
            res[0]--;
        } else if(dir == 'R') {
            res[0]++;
        } else if(dir == 'D') {
            res[1]--;
        } else {
            res[1]++;
        }
        if(res[0] == block[0] && res[1] == block[1]) {
            return cur;
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            char[] s = f.readLine().toCharArray();
            HashSet<String> set = new HashSet<>();
            int x = 0;
            int y = 0;
            for(char i: s) {
                int[] temp = next(new int[]{x, y}, i, new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE});
                x = temp[0];
                y = temp[1];
                set.add(x + " " + y);
            }
            boolean found = false;
            for(String i: set) {
                StringTokenizer st = new StringTokenizer(i);
                int[] block = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
                x = 0;
                y = 0;
                for(char j: s) {
                    int[] temp = next(new int[]{x, y}, j, block);
                    x = temp[0];
                    y = temp[1];
                }
                if(x == 0 && y == 0) {
                    found = true;
                    out.println(i);
                    break;
                }
            }
            if(!found) {
                out.println("0 0");
            }
        }
        f.close();
        out.close();
    }
}