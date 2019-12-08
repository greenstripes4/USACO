import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("buckets.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
        char[][] farm = new char[10][10];
        for(int i = 0; i < 10; i++){
            farm[i] = f.readLine().toCharArray();
        }
        int[] barnLocation = new int[2];
        int[] lakeLocation = new int[2];
        int[] rockLocation = new int[2];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(farm[i][j] == 'B'){
                    barnLocation[0] = i;
                    barnLocation[1] = j;
                } else if(farm[i][j] == 'L'){
                    lakeLocation[0] = i;
                    lakeLocation[1] = j;
                } else if(farm[i][j] == 'R'){
                    rockLocation[0] = i;
                    rockLocation[1] = j;
                }
            }
        }
        if(lakeLocation[0] == barnLocation[0] && lakeLocation[0] == rockLocation[0] && ((rockLocation[1] >= barnLocation[1] && rockLocation[1] <= lakeLocation[1]) || (rockLocation[1] >= lakeLocation[1] && rockLocation[1] <= barnLocation[1]))){
            out.println(3 + Math.abs(lakeLocation[1] - barnLocation[1]) - 2);
        } else if(lakeLocation[1] == barnLocation[1] && lakeLocation[1] == rockLocation[1] && ((rockLocation[0] >= barnLocation[0] && rockLocation[0] <= lakeLocation[0]) || (rockLocation[0] >= lakeLocation[0] && rockLocation[0] <= barnLocation[0]))){
            out.println(3 + Math.abs(lakeLocation[0] - barnLocation[0]) - 2);
        } else {
            out.println(Math.abs(lakeLocation[0] - barnLocation[0]) + Math.abs(lakeLocation[1] - barnLocation[1]) - 1);
        }
        f.close();
        out.close();
    }
}
