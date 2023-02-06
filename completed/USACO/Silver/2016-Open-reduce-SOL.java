import java.io.*;
import java.util.*;

public class Main{
    private static boolean validRectangle(int minX, int maxX, int minY, int maxY, int[][] points) {
        int outside = 0;
        for(int[] i: points) {
            if(i[0] < minX || i[0] > maxX || i[1] < minY || i[1] > maxY) {
                outside++;
            }
        }
        return outside <= 3;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("reduce.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        int[][] sortedByX = new int[N][2];
        int[][] sortedByY = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sortedByX[i][0] = x;
            sortedByX[i][1] = y;
            sortedByY[i][0] = x;
            sortedByY[i][1] = y;
        }
        Arrays.sort(sortedByX, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if(ints[0] == t1[0]) {
                    return ints[1]-t1[1];
                }
                return ints[0]-t1[0];
            }
        });
        Arrays.sort(sortedByY, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if(ints[1] == t1[1]) {
                    return ints[0]-t1[0];
                }
                return ints[1]-t1[1];
            }
        });
        HashSet<Integer> possibleMinX = new HashSet<>();
        HashSet<Integer> possibleMinY = new HashSet<>();
        HashSet<Integer> possibleMaxX = new HashSet<>();
        HashSet<Integer> possibleMaxY = new HashSet<>();
        for(int i = 0; i < 4; i++) {
            if(i < N) {
                possibleMinX.add(sortedByX[i][0]);
                possibleMinY.add(sortedByY[i][1]);
            }
        }
        for(int i = N-1; i >= N-4; i--) {
            if(i >= 0) {
                possibleMaxX.add(sortedByX[i][0]);
                possibleMaxY.add(sortedByY[i][1]);
            }
        }
        int bestArea = 1599920002;
        for(int i: possibleMinX) {
            for(int j: possibleMinY) {
                for(int k: possibleMaxX) {
                    for(int l: possibleMaxY) {
                        if(validRectangle(Math.min(i,k),Math.max(i,k),Math.min(j,l),Math.max(j,l),sortedByX)) {
                            bestArea = Math.min(bestArea,Math.abs(k-i)*Math.abs(l-j));
                        }
                    }
                }
            }
        }
        out.println(bestArea);
        f.close();
        out.close();
    }
}
