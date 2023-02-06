import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<Integer> next = new HashSet<>();
        int[] x = new int[n+1];
        int[] index = new int[n+2];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            x[i+1] = Integer.parseInt(st.nextToken());
            index[x[i+1]] = i+1;
            next.remove(x[i]-1);
            next.add(x[i]);
        }
        index[n+1] = n+1;
        int rounds = next.size();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if(a < index[x[a]+1] && b > index[x[a]+1]) {
                rounds++;
            }
            if(a < index[x[a]-1] && b > index[x[a]-1]) {
                rounds--;
            }
            if(b > index[x[b]-1] && a < index[x[b]-1]) {
                rounds++;
            }
            if(b > index[x[b]+1] && a < index[x[b]+1]) {
                rounds--;
            }
            if(b == index[x[a]+1] || a == index[x[b]-1]) {
                rounds++;
            }
            if(x[a] == x[b]+1) {
                rounds--;
            }
            out.println(rounds);
            index[x[a]] = b;
            index[x[b]] = a;
            int temp = x[a];
            x[a] = x[b];
            x[b] = temp;
        }
        f.close();
        out.close();
    }
}