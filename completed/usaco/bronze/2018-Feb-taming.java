import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("taming.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
        int N = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] entries = new int[N];
        for(int i = 0; i < N; i++){
            entries[i] = Integer.parseInt(st.nextToken());
        }
        boolean valid = true;
        if(entries[0] > 0){
            out.println(-1);
            valid = false;
        }
        entries[0] = 0;
        int t = -1;
        int req = 0;
        int pos = 0;
        for(int i = N - 1; i >= 0; i--){
            if(t != -1 && entries[i] != -1 && entries[i] != t) {
                out.println(-1);
                valid = false;
                break;
            }
            if(t == -1)
                t = entries[i];
            if(entries[i] == -1)
                entries[i] = t;
            if(entries[i] == 0)
                req++;
            if(entries[i] == -1)
                pos++;
            if(t > -1)
                t--;
        }
        if(valid) {
            out.println(req + " " + (req + pos));
        }
        f.close();
        out.close();
    }
}
