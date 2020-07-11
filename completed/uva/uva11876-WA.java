import java.io.*;
import java.util.*;

public class Main{
    private static int numDivisors(int n){
        int count = 0;
        for(int i = 1; i <= (int) Math.sqrt(n); i++){
            if(n%i == 0){
                count++;
                if(n/i != i){
                    count++;
                }
            }
        }
        return count;
    }
    private static int low(int[] sequence, int target){
        int low = 0;
        int high = sequence.length-1;
        while(low < high){
            int middle = (low+high)/2;
            if(sequence[middle] < target){
                low = middle+1;
            } else {
                high = middle-1;
            }
        }
        return high+1;
    }
    private static int high(int[] sequence, int target){
        int low = 0;
        int high = sequence.length-1;
        while(low <= high){
            int middle = (low+high)/2;
            if(sequence[middle] > target){
                high = middle-1;
            } else {
                low = middle+1;
            }
        }
        return low-1;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[] sequence = new int[65000];
        sequence[0] = 1;
        for(int i = 1; i < 65000; i++){
            sequence[i] = sequence[i-1] + numDivisors(sequence[i-1]);
        }
        int T = f.nextInt();
        for(int i = 0; i < T; i++){
            int A = f.nextInt();
            int B = f.nextInt();
            int low = low(sequence,A);
            int high = high(sequence,B);
            out.println("Case " + (i+1) + ": " + (high-low+1));
        }
        f.close();
        out.close();
    }
}
