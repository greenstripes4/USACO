import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int sum = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        int[][] lowestBit = new int[limit][2];
        for(int i = 1; i <= limit; i++) {
            lowestBit[i-1][0] = i;
            lowestBit[i-1][1] = i&-i;
        }
        Arrays.sort(lowestBit, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return t1[1]-ints[1];
            }
        });
        ArrayList<Integer> S = new ArrayList<>();
        for(int[] i: lowestBit) {
            if(sum == 0) {
                break;
            }
            if(i[1] <= sum) {
                S.add(i[0]);
                sum -= i[1];
            }
        }
        if(sum != 0) {
            out.println(-1);
        } else {
            out.println(S.size());
            out.print(S.get(0));
            for(int i = 1; i < S.size(); i++) {
                out.print(" " + S.get(i));
            }
            out.println();
        }
        f.close();
        out.close();
    }
}