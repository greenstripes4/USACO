import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] arr = f.readLine().toCharArray();
        int s = -1;
        ArrayList<Integer> c = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(arr[i] == '0' && i-s >= b) {
                s = i;
                c.add(i+1);
            } else if(arr[i] == '1') {
                s = i;
            }
        }
        out.println(c.size()-a+1);
        out.print(c.get(0));
        for(int i = 1; i <= c.size()-a; i++) {
            out.print(" " + c.get(i));
        }
        out.println();
        f.close();
        out.close();
    }
}