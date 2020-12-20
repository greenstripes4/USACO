import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("triangles.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
        int N = Integer.parseInt(f.readLine());
        HashMap<Integer, HashSet<Integer>> x = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> y = new HashMap<>();
        int[][] points = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            if(!x.containsKey(X)) {
                x.put(X, new HashSet<>());
            }
            if(!y.containsKey(Y)) {
                y.put(Y, new HashSet<>());
            }
            x.get(X).add(Y);
            y.get(Y).add(X);
            points[i][0] = X;
            points[i][1] = Y;
        }
        int totalArea = 0;
        for(int[] i: points) {
            int X1 = i[0];
            int Y1 = i[1];
            if(x.get(X1).size() == 1 || y.get(Y1).size() == 1) {
                continue;
            }
            int totalXAbsDiff = 0;
            int totalYAbsDiff = 0;
            for(int Y2: x.get(X1)) {
                totalXAbsDiff += Math.abs(Y1-Y2);
            }
            for(int X2: y.get(Y1)) {
                totalYAbsDiff += Math.abs(X1-X2);
            }
            totalXAbsDiff %= 1000000007;
            totalYAbsDiff %= 1000000007;
            totalArea += (((long) totalXAbsDiff)*totalYAbsDiff)%1000000007;
            totalArea %= 1000000007;
        }
        out.println(totalArea);
        f.close();
        out.close();
    }
}
