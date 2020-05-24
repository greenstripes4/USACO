import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(f.hasNext()){
            int n = f.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = f.nextInt();
            }
            Arrays.sort(arr);
            if(n%2 == 0){
                int mid1 = arr[n/2-1];
                int mid2 = arr[n/2];
                int count = 0;
                for(int i: arr){
                    if(i == mid1 || i == mid2){
                        count++;
                    }
                }
                out.println(mid1 + " " + count + " " + (mid2-mid1+1));
            } else {
                int mid = arr[n/2];
                int count = 0;
                for(int i: arr){
                    if(i == mid){
                        count++;
                    }
                }
                out.println(mid + " " + count + " " + 1);
            }
        }
        f.close();
        out.close();
    }
}
