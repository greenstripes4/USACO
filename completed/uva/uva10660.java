import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            int n = Integer.parseInt(f.readLine());
            int[][] city = new int[5][5];
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                int row = Integer.parseInt(st.nextToken());
                int column = Integer.parseInt(st.nextToken());
                int population = Integer.parseInt(st.nextToken());
                city[row][column] = population;
            }
            long minimumDistance = Long.MAX_VALUE;
            int[] officePositions = new int[5];
            for(int i = 0; i < 21; i++) {
                for(int j = i+1; j < 22; j++) {
                    for(int k = j+1; k < 23; k++) {
                        for(int l = k+1; l < 24; l++) {
                            for(int m = l+1; m < 25; m++) {
                                int currentDistance = 0;
                                for(int position = 0; position < 25; position++) {
                                    int row = position/5;
                                    int column = position%5;
                                    int distanceFromFirst = Math.abs(row-i/5)+Math.abs(column-i%5);
                                    int distanceFromSecond = Math.abs(row-j/5)+Math.abs(column-j%5);
                                    int distanceFromThird = Math.abs(row-k/5)+Math.abs(column-k%5);
                                    int distanceFromFourth = Math.abs(row-l/5)+Math.abs(column-l%5);
                                    int distanceFromFifth = Math.abs(row-m/5)+Math.abs(column-m%5);
                                    currentDistance += city[row][column]*Math.min(distanceFromFirst,Math.min(distanceFromSecond,Math.min(distanceFromThird,Math.min(distanceFromFourth,distanceFromFifth))));
                                }
                                if(currentDistance < minimumDistance) {
                                    minimumDistance = currentDistance;
                                    officePositions[0] = i;
                                    officePositions[1] = j;
                                    officePositions[2] = k;
                                    officePositions[3] = l;
                                    officePositions[4] = m;
                                }
                            }
                        }
                    }
                }
            }
            out.println(officePositions[0] + " " + officePositions[1] + " " + officePositions[2] + " " + officePositions[3] + " " + officePositions[4]);
        }
        f.close();
        out.close();
    }
}
