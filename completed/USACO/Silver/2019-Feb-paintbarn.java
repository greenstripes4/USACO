import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("paintbarn.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] differenceSum = new int[1000][1001];
        for(int i = 0; i < N; i++) {
            StringTokenizer rectangle = new StringTokenizer(f.readLine());
            int x1 = Integer.parseInt(rectangle.nextToken());
            int y1 = Integer.parseInt(rectangle.nextToken());
            int x2 = Integer.parseInt(rectangle.nextToken());
            int y2 = Integer.parseInt(rectangle.nextToken());
            for(int j = x1; j < x2; j++) {
                differenceSum[j][y1]++;
                differenceSum[j][y2]--;
            }
        }
        int area = 0;
        for(int[] i: differenceSum) {
            int layers = 0;
            for(int j: i) {
                layers += j;
                if(layers == K) {
                    area++;
                }
            }
        }
        out.println(area);
        f.close();
        out.close();
    }
}
/*
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("paintbarn.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] differenceSum = new int[1001][1001];
        for(int i = 0; i < N; i++) {
            StringTokenizer rectangle = new StringTokenizer(f.readLine());
            int x1 = Integer.parseInt(rectangle.nextToken());
            int y1 = Integer.parseInt(rectangle.nextToken());
            int x2 = Integer.parseInt(rectangle.nextToken());
            int y2 = Integer.parseInt(rectangle.nextToken());
            differenceSum[x1][y1]++;
            differenceSum[x1][y2]--;
            differenceSum[x2][y1]--;
            differenceSum[x2][y2]++;
        }
        int area = 0;
        for(int i = 0; i < 1000; i++) {
            for(int j = 0; j < 1000; j++) {
                if(i > 0) {
                    differenceSum[i][j] += differenceSum[i-1][j];
                }
                if(j > 0) {
                    differenceSum[i][j] += differenceSum[i][j-1];
                }
                if(i > 0 && j > 0) {
                    differenceSum[i][j] -= differenceSum[i-1][j-1];
                }
                if(differenceSum[i][j] == K) {
                    area++;
                }
            }
        }
        out.println(area);
        f.close();
        out.close();
    }
}
 */