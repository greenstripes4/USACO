import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        char[] s = f.readLine().toCharArray();
        int a = 0;
        int d = 0;
        for(int i = 0; i < n; i++) {
            if(s[i] == 'A') {
                a++;
            } else {
                d++;
            }
        }
        out.println(a > d ? "Anton" : a < d ? "Danik" : "Friendship");
        f.close();
        out.close();
    }
}