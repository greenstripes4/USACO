import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < testCases; i++) {
            int numWalls = Integer.parseInt(f.readLine());
            int highCount = 0;
            int lowCount = 0;
            StringTokenizer st = new StringTokenizer(f.readLine());
            int currentHight = Integer.parseInt(st.nextToken());
            for (int j = 0; j < numWalls - 1; j++) {
                int newHight = Integer.parseInt(st.nextToken());
                if (newHight > currentHight){
                    highCount++;
                    currentHight = newHight;
                }
                else if(newHight < currentHight){
                    lowCount++;
                    currentHight = newHight;
                }
            }
            System.out.println("Case " + (i + 1) + ": " + highCount + " " + lowCount);
        }
    }
}
