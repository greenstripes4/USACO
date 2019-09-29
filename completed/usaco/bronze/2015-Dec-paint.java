import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("paint.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
        StringTokenizer farmer = new StringTokenizer(f.readLine());
        StringTokenizer cow = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(farmer.nextToken());
        int b = Integer.parseInt(farmer.nextToken());
        int c = Integer.parseInt(cow.nextToken());
        int d = Integer.parseInt(cow.nextToken());
        boolean[] fence = new boolean[100];
        for(int i = a; i < b; i++){
            fence[i] = true;
        }
        for(int j = c; j < d; j++){
            fence[j] = true;
        }
        int count = 0;
        for(boolean k: fence){
            if(k){
                count++;
            }
        }
        out.println(count);
        out.close();
        f.close();
    }
}
