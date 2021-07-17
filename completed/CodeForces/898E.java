import java.io.*;
import java.util.*;

public class Main {
    private static int root(int z) {
        return (int) (Math.sqrt(z));
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        int x = 0;
        int y = 0;
        int nonZero = 0;
        ArrayList<Integer> moves = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            int temp = root(a[i]);
            if(temp*temp == a[i]) {
                x++;
                if(a[i] > 0) {
                    nonZero++;
                }
            } else {
                y++;
                int greater = (temp+1)*(temp+1);
                moves.add(Math.min(a[i]-temp*temp, greater-a[i]));
            }
        }
        if(x == y) {
            out.println(0);
        } else if(x > y) {
            if(nonZero >= (x-y)/2) {
                out.println((x-y)/2);
            } else {
                out.println(nonZero+((x-y)/2-nonZero)*2);
            }
        } else {
            Collections.sort(moves);
            long sum = 0;
            for(int i = 0; i < (y-x)/2; i++) {
                sum += moves.get(i);
            }
            out.println(sum);
        }
        f.close();
        out.close();
    }
}