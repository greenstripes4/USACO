import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken())-1;
        char[] str = f.readLine().toCharArray();
        if(p >= n/2) {
            p = n-p-1;
        }
        int l = -1;
        for(int i = 0; i <= p; i++) {
            if(str[i] != str[n-i-1]) {
                l = i;
                break;
            }
        }
        int r = -1;
        for(int i = n/2-1; i >= p; i--) {
            if(str[i] != str[n-i-1]) {
                r = i;
                break;
            }
        }
        if(l < 0 && r < 0) {
            out.println(0);
        } else if(l == -1) {
            int moves = r-p;
            for(int i = p; i <= r; i++) {
                int position1 = str[i]-'a';
                int position2 = str[n-i-1]-'a';
                int distance = Math.abs(position1-position2);
                moves += Math.min(distance, 26-distance);
                str[n-i-1] = str[i];
            }
            out.println(moves);
        } else if(r == -1) {
            int moves = p-l;
            for(int i = p; i >= l; i--) {
                int position1 = str[i]-'a';
                int position2 = str[n-i-1]-'a';
                int distance = Math.abs(position1-position2);
                moves += Math.min(distance, 26-distance);
                str[n-i-1] = str[i];
            }
            out.println(moves);
        } else if(r-p < p-l) {
            int moves = r-p+r-l;
            for(int i = p; i <= r; i++) {
                int position1 = str[i]-'a';
                int position2 = str[n-i-1]-'a';
                int distance = Math.abs(position1-position2);
                moves += Math.min(distance, 26-distance);
                str[n-i-1] = str[i];
            }
            for(int i = r; i >= l; i--) {
                int position1 = str[i]-'a';
                int position2 = str[n-i-1]-'a';
                int distance = Math.abs(position1-position2);
                moves += Math.min(distance, 26-distance);
                str[n-i-1] = str[i];
            }
            out.println(moves);
        } else {
            int moves = p-l+r-l;
            for(int i = p; i >= l; i--) {
                int position1 = str[i]-'a';
                int position2 = str[n-i-1]-'a';
                int distance = Math.abs(position1-position2);
                moves += Math.min(distance, 26-distance);
                str[n-i-1] = str[i];
            }
            for(int i = l; i <= r; i++) {
                int position1 = str[i]-'a';
                int position2 = str[n-i-1]-'a';
                int distance = Math.abs(position1-position2);
                moves += Math.min(distance, 26-distance);
                str[n-i-1] = str[i];
            }
            out.println(moves);
        }
        f.close();
        out.close();
    }
}