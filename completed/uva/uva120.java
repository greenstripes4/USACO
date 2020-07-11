import java.io.*;
import java.util.*;

public class Main{
    private static boolean isSorted(int[] arr){
        int prev = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < prev){
                return false;
            }
            prev = arr[i];
        }
        return true;
    }
    private static int getMaxInd(int[] arr, int upperBound){
        int maxInd = 0;
        for(int i = 1; i < upperBound; i++){
            if(arr[i] > arr[maxInd]){
                maxInd = i;
            }
        }
        return maxInd;
    }
    private static void flip(int[] arr, int ind){
        int i = 0;
        int j = ind-1;
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input);
            int[] arr = new int[st.countTokens()];
            for(int i = 0; i < arr.length; i++){
                if(i > 0){
                    out.print(" ");
                }
                arr[i] = Integer.parseInt(st.nextToken());
                out.print(arr[i]);
            }
            out.println();
            List<Integer> sequence = new LinkedList<>();
            int sortedInd = arr.length;
            while(!isSorted(arr)){
                int maxInd = getMaxInd(arr,sortedInd);
                if(maxInd != sortedInd-1){
                    if(maxInd != 0){
                        flip(arr,maxInd+1);
                        sequence.add(arr.length-maxInd);
                    }
                    flip(arr,sortedInd);
                    sequence.add(arr.length-sortedInd+1);
                }
                sortedInd--;
            }
            for(int i: sequence){
                out.print(i+" ");
            }
            out.println(0);
        }
        f.close();
        out.close();
    }
}
