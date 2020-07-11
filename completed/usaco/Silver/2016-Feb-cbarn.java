import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
        int n = Integer.parseInt(f.readLine());
        int[] c = new int[n];
        for(int i = 0; i < n; i++){
            c[i] = Integer.parseInt(f.readLine());
        }
        int[] startArr = new int[n];
        startArr[0] = Math.max(0,c[0]-1);
        for(int i = 1; i < n; i++){
            startArr[i] = Math.max(0,startArr[i-1]+c[i]-1);
        }
        int startInd = startArr.length-1;
        while(startArr[startInd] > 0){
            startInd--;
        }
        startInd++;
        Queue<Integer> queue = new LinkedList<>();
        int energy = 0;
        for(int i = startInd; i < startInd+n; i++){
            for(int j = 0; j < c[i%n]; j++){
                queue.offer(i);
            }
            int doors = i-queue.poll();
            energy += doors*doors;
        }
        out.println(energy);
        f.close();
        out.close();
    }
}
