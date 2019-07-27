import java.io.*;
import java.util.StringTokenizer;
//O(n)
//1 4 2 2 3 5 3 4
//9
//1 2 3 4 5
//10 10 10 10 10
//10 0 10 0 10
//0 0 0 0 0

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int num = Integer.parseInt(f.readLine());
        for(int i = 0; i < num; i++){
            int numWalls = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] walls = new int[numWalls];
            for(int j = 0; j < numWalls; j++){
                walls[j] = Integer.parseInt(st.nextToken());
            }
            int high = 0;
            int low = 0;
            int prev = walls[0];
            for(int k: walls){
                if(k > prev){
                    high++;
                }
                else if(k < prev){
                    low++;
                }
                prev = k;
            }
            System.out.println("Case " + (i+1) + ": " + high + " " + low);
        }
    }
}
