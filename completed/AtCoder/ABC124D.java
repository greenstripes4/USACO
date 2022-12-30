import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("moop.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moop.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] S = f.readLine().toCharArray();
        int[] map = new int[N];
        char tar = S[0];
        int alt = 0;
        for(int i = 0; i < N; i++) {
            if(S[i] != tar) {
                tar = S[i];
                alt++;
            }
            map[i] = alt;
        }
        int low = 1;
        int high = N;
        int ans = 0;
        while(low <= high) {
            int mid = (low+high)/2;
            boolean flag = false;
            for(int i = 0; i <= N-mid; i++) {
                if((map[i+mid-1]-map[i]+1+(S[i] == '0' ? 1 : 0))/2 <= K) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}