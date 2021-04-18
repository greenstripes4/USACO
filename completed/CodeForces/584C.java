import java.io.*;
import java.util.*;

public class Main {
    private static char getDifferent(char flag1, char flag2) {
        for(int i = 'a'; i <= 'z'; i++) {
            if(i != flag1 && i != flag2) {
                return (char) i;
            }
        }
        return 'A';
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        char[] s1 = f.readLine().toCharArray();
        char[] s2 = f.readLine().toCharArray();
        int c = 0;
        for(int i = 0; i < n; i++) {
            if(s1[i] == s2[i]) {
                c++;
            }
        }
        int l = (n-c)/2+(n-c)%2;
        int r = n-c;
        int ans1 = -1;
        if((l <= t && r >= t-c) || (t-c <= r && t >= l)) {
            ans1 = t-Math.min(t, r);
        }
        if(ans1 < 0) {
            out.println(-1);
        } else {
            int[] suffixSum = new int[n];
            for(int i = n-1; i > 0; i--) {
                suffixSum[i-1] = suffixSum[i];
                if(s1[i] != s2[i]) {
                    suffixSum[i-1]++;
                }
            }
            char[] res = new char[n];
            int ans2 = t-ans1;
            int ans3 = t-ans1;
            for(int i = 0; i < n; i++) {
                if(s1[i] == s2[i]) {
                    if(ans1 > 0) {
                        res[i] = getDifferent(s1[i], s2[i]);
                        ans1--;
                    } else {
                        res[i] = s1[i];
                    }
                } else {
                    if(suffixSum[i] < ans2) {
                        res[i] = getDifferent(s1[i], s2[i]);
                        ans2--;
                        ans3--;
                    } else {
                        if(ans2 < ans3) {
                            res[i] = s1[i];
                            ans3--;
                        } else {
                            res[i] = s2[i];
                            ans2--;
                        }
                    }
                }
            }
            out.println(res);
        }
        f.close();
        out.close();
    }
}