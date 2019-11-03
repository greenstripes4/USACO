import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static int passesTo(int currentCow, int[] positions){
        int left_nbr = -1;
        int left_dist = 1000;
        int right_nbr = -1;
        int right_dist = 1000;
        for (int i = 0; i < positions.length; i++)
            if(positions[i] < positions[currentCow] && positions[currentCow] - positions[i] < left_dist){
                left_nbr = i;
                left_dist = positions[currentCow] - positions[i];
            }
        for (int j = 0; j < positions.length; j++) {
            if(positions[j] > positions[currentCow] && positions[j] - positions[currentCow] < right_dist){
                right_nbr = j;
                right_dist = positions[j] - positions[currentCow];
            }
        }
        if(left_dist <= right_dist) {
            return left_nbr;
        }
        return right_nbr;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("hoofball.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
        int N = Integer.parseInt(f.readLine());
        int[] positions = new int[N];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < N; i++){
            positions[i] = Integer.parseInt(st.nextToken());
        }
        int[] recievedPasses = new int[N];
        for(int j = 0; j < N; j++){
            recievedPasses[passesTo(j,positions)]++;
        }
        int count = 0;
        for(int k = 0; k < N; k++){
            if(recievedPasses[k] == 0 || (k < passesTo(k,positions) && passesTo(passesTo(k, positions), positions) == k && recievedPasses[k] == 1 && recievedPasses[passesTo(k, positions)] == 1)){
                count++;
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}
