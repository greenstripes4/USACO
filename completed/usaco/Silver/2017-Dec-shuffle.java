import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        int[] a = new int[N];
        int[] parents = new int[N];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken())-1;
            parents[a[i]]++;
        }
        int positions = N;
        Queue<Integer> checkCanReach = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            if(parents[i] == 0) {
                positions--;
                checkCanReach.add(i);
            }
        }
        while(!checkCanReach.isEmpty()) {
            int temp = checkCanReach.poll();
            if(--parents[a[temp]] == 0) {
                positions--;
                checkCanReach.add(a[temp]);
            }
        }
        out.println(positions);
        f.close();
        out.close();
    }
}
