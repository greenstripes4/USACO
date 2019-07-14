import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
//O(n log n)
//5
//1000 2000 3000
//3000 2500 1500
//1500 1200 1800
//1000 1000 1000
//1000 10000 1000
//10000 10000 10000

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int numcases = Integer.parseInt(f.readLine());
        for(int i = 0; i < numcases; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());
            int[] comps = {n1,n2,n3};
            Arrays.sort(comps);
            System.out.println("Case " + (i+1) + ": " + comps[1]);
        }
    }
}
