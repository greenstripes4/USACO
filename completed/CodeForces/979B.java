import java.io.*;
import java.util.*;

public class Main {
    private static int getMaxOcc(char[] arr) {
        int[] occ = new int[52];
        for(char i: arr) {
            if(i >= 'a' && i <= 'z') {
                occ[i-'a']++;
            } else {
                occ[i-'A'+26]++;
            }
        }
        int max = 0;
        for(int i: occ) {
            max = Math.max(max, i);
        }
        return max;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        char[] a = f.readLine().toCharArray();
        char[] b = f.readLine().toCharArray();
        char[] c = f.readLine().toCharArray();
        int tempA = getMaxOcc(a);
        int tempB = getMaxOcc(b);
        int tempC = getMaxOcc(c);
        int kuro = Math.min(a.length, tempA == a.length && n == 1 ? a.length-1 : tempA+n);
        int shiro = Math.min(b.length, tempB == b.length && n == 1 ? b.length-1 : tempB+n);
        int katie = Math.min(c.length, tempC == c.length && n == 1 ? c.length-1 : tempC+n);
        int max = Math.max(kuro, Math.max(shiro, katie));
        if((max == kuro && max == shiro) || (max == kuro && max == katie) || (max == shiro && max == katie)) {
            out.println("Draw");
        } else {
            out.println(max == kuro ? "Kuro" : max == shiro ? "Shiro" : "Katie");
        }
        f.close();
        out.close();
    }
}