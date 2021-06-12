import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("beads.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int k = Integer.parseInt(f.readLine());
        while(k-- > 0) {
            int n = Integer.parseInt(f.readLine());
            int[] occ = new int[26];
            char[] s = f.readLine().toCharArray();
            for(char i: s) {
                occ[i-'a']++;
            }
            char[] t = f.readLine().toCharArray();
            for(int i: t) {
                occ[i-'a']++;
            }
            boolean flag = false;
            for(int i: occ) {
                if(i%2 == 1) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                out.println("No");
                continue;
            }
            out.println("Yes");
            ArrayList<String> swaps = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if(s[i] != t[i]) {
                    for(int j = i+1; j < n; j++) {
                        if(s[j] == s[i]) {
                            swaps.add((j+1) + " " + (i+1));
                            char temp = s[j];
                            s[j] = t[i];
                            t[i] = temp;
                            break;
                        } else if(t[j] == s[i]) {
                            swaps.add((j+1) + " " + (j+1));
                            swaps.add((j+1) + " " + (i+1));
                            char temp = t[i];
                            t[i] = t[j];
                            t[j] = s[j];
                            s[j] = temp;
                            break;
                        }
                    }
                }
            }
            out.println(swaps.size());
            for(String i: swaps) {
                out.println(i);
            }
        }
        f.close();
        out.close();
    }
}
