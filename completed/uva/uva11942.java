import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
//O(n log n)
//6
//13 25 39 40 55 62 68 77 88 95
//88 62 77 20 40 10 99 56 45 36
//91 78 61 59 54 49 43 33 26 18
//99 99 99 99 99 99 99 99 99 99
//0 0 0 0 0 0 0 0 0 0
//99 0 99 0 99 0 99 0 99 0

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int testCases = Integer.parseInt(f.readLine());
        System.out.println("Lumberjacks:");
        for (int i = 0; i < testCases; i++) {
            int[] l = new int[10];
            StringTokenizer st = new StringTokenizer(f.readLine());
            int ind = 0;
            while(st.hasMoreTokens()){
                l[ind] = Integer.parseInt(st.nextToken());
                ind++;
            }
            int[] lcopy = l.clone();
            Arrays.sort(lcopy);
            int[] lcopy2 = new int[10];
            for(int j = 0; j < lcopy.length; j++){
                lcopy2[j] = lcopy[9-j];
            }
            if(Arrays.equals(l,lcopy) || Arrays.equals(l,lcopy2)){
                System.out.println("Ordered");
            }
            else{
                System.out.println("Unordered");
            }
        }
    }
}
