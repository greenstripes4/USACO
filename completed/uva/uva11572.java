import java.io.*;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int numCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < numCases; i++){
            int numSnowflakes = Integer.parseInt(f.readLine());
            int[] snowflakes = new int[numSnowflakes];
            for(int j = 0; j < numSnowflakes; j++) {
                snowflakes[j] = Integer.parseInt(f.readLine());
            }
            HashMap<Integer,Integer> indexes = new HashMap<>();
            int start = 0;
            int maxLength = 0;
            for(int k = 0; k < numSnowflakes; k++){
                if(indexes.containsKey(snowflakes[k])) {
                    start = indexes.get(snowflakes[k]) + 1;
                    k = start;
                    indexes.clear();
                }
                indexes.put(snowflakes[k],k);
                if ((k - start + 1) > maxLength) {
                    maxLength = k - start + 1;
                }
            }
            out.println(maxLength);
        }
        f.close();
        out.close();
    }
}
