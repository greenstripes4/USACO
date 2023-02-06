import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("maxcross.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] broken = new int[B];
        for(int i = 0; i < B; i++) {
            broken[i] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(broken);
        int index = 0;
        while(index < B && broken[index] <= K) {
            index++;
        }
        int min = index;
        for(int i = 0; i < B; i++) {
            if(broken[i]+K > N) {
                break;
            }
            while(index < B && broken[index] <= broken[i]+K) {
                index++;
            }
            min = Math.min(min,index-i-1);
        }
        out.println(min);
        f.close();
        out.close();
    }
}
