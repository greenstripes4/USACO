import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
        int n = Integer.parseInt(f.readLine());
        int[] arr = new int[n];
        int totalCows = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(f.readLine());
            totalCows += arr[i];
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < arr.length; j++){
            int cowsLeft = totalCows;
            int curRoom = j;
            int doors = 0;
            while(cowsLeft != 0){
                cowsLeft -= arr[curRoom%n];
                curRoom++;
                doors += cowsLeft;
            }
            if(doors < min){
                min = doors;
            }
        }
        out.println(min);
        out.close();
        f.close();
    }
}
