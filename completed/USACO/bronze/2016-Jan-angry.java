import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("angry.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        int numBales = Integer.parseInt(f.readLine());
        int[] bales = new int[numBales];
        for(int i = 0; i < numBales; i++){
            bales[i] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(bales);
        int max = 1;
        for(int i = 0; i < bales.length; i++){
            int explosions = 1;
            int radius = 1;
            int maxIndex = i;
            boolean keepGoing = true;
            while(keepGoing && maxIndex < bales.length){
                keepGoing = false;
                int maxCanHit = 0;
                for(int j = maxIndex + 1; j < bales.length; j++){
                    if(bales[j] - bales[maxIndex] <= radius){
                        explosions++;
                        keepGoing = true;
                        maxCanHit = j;
                    }
                }
                if(maxCanHit > maxIndex){
                    maxIndex = maxCanHit;
                }
                radius++;
            }
            radius = 1;
            keepGoing = true;
            int minIndex = i;
            while(keepGoing && minIndex >= 0){
                keepGoing = false;
                int minCanHit = 0;
                for(int k = minIndex - 1; k >= 0; k--){
                    if(bales[minIndex] - bales[k] <= radius){
                        explosions++;
                        keepGoing = true;
                        minCanHit = k;
                    }
                }
                if(minCanHit < minIndex){
                    minIndex = minCanHit;
                }
                radius++;
            }
            if(explosions > max){
                max = explosions;
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}
