import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] s = f.readLine().toCharArray();
        int[] occ = new int[26];
        for(char i: s) {
            occ[i-'a']++;
        }
        int ans = 0;
        for(int i = 0; i < 26; i++) {
            if(occ[i] > 0) {
                ans++;
            }
        }
        out.println(ans%2 == 0 ? "CHAT WITH HER!" : "IGNORE HIM!");
        f.close();
        out.close();
    }
}