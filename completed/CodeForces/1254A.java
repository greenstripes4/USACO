import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            char[][] arr = new char[r][];
            int total = 0;
            for(int i = 0; i < r; i++) {
                arr[i] = f.readLine().toCharArray();
                for(char j: arr[i]) {
                    if(j == 'R') {
                        total++;
                    }
                }
            }
            char[][] res = new char[r][c];
            for(int i = 0; i < r; i++) {
                Arrays.fill(res[i], ' ');
            }
            int average = total/k;
            char[] ids = new char[62];
            for(int i = 0; i < 26; i++) {
                ids[i] = (char) ('a'+i);
            }
            for(int i = 26; i < 52; i++) {
                ids[i] = (char) ('A'+i-26);
            }
            for(int i = 52; i < 62; i++) {
                ids[i] = (char) ('0'+i-52);
            }
            int count = k-total%k;
            int i = 0;
            int j = 0;
            int dir = 1;
            int idx = 0;
            while(count-- > 0) {
                int target = average;
                while(target > 0) {
                    res[i][j] = ids[idx];
                    if(arr[i][j] == 'R') {
                        target--;
                    }
                    j += dir;
                    if(j < 0 || j >= c) {
                        j -= dir;
                        i++;
                        dir = -dir;
                    }
                }
                idx++;
            }
            average++;
            count = total%k;
            while(count-- > 0) {
                int target = average;
                while(target > 0) {
                    res[i][j] = ids[idx];
                    if(arr[i][j] == 'R') {
                        target--;
                    }
                    j += dir;
                    if(j < 0 || j >= c) {
                        j -= dir;
                        i++;
                        dir = -dir;
                    }
                }
                idx++;
            }
            idx--;
            while(i < r) {
                res[i][j] = ids[idx];
                j += dir;
                if(j < 0 || j >= c) {
                    j -= dir;
                    i++;
                    dir = -dir;
                }
            }
            for(char[] l: res) {
                out.println(l);
            }
        }
        f.close();
        out.close();
    }
}