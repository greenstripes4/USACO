import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int scenarios = f.nextInt();
        for(int s = 0; s < scenarios; s++) {
            int d = f.nextInt();
            int n = f.nextInt();
            int[][] totalPopulationExtinguished = new int[1025][1025];
            for(int i = 0; i < n; i++) {
                int x = f.nextInt();
                int y = f.nextInt();
                int size = f.nextInt();
                for(int j = -d; j <= d; j++) {
                    for(int k = -d; k <= d; k++) {
                        int reachableFromX = x+j;
                        int reachableFromY = y+k;
                        if(reachableFromX >= 0 && reachableFromX < 1025 && reachableFromY >= 0 && reachableFromY < 1025) {
                            totalPopulationExtinguished[reachableFromX][reachableFromY] += size;
                        }
                    }
                }
            }
            int gasBombX = -1;
            int gasBombY = -1;
            int populationExtinguished = 0;
            for(int i = 0; i < 1025; i++) {
                for(int j = 0; j < 1025; j++) {
                    if(totalPopulationExtinguished[i][j] > populationExtinguished) {
                        gasBombX = i;
                        gasBombY = j;
                        populationExtinguished = totalPopulationExtinguished[i][j];
                    }
                }
            }
            out.println(gasBombX + " " + gasBombY + " " + populationExtinguished);
        }
        f.close();
        out.close();
    }
}
