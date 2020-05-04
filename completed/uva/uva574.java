import java.io.*;
import java.util.*;

public class Main{
    private static void printAllSums(int t, int cur, HashSet<String> allSums, String sum, int[] nums, int ind, PrintWriter out){
        if(cur == t){
            String output = sum.substring(0,sum.length()-1);
            if(!allSums.contains(output)){
                out.println(output);
                allSums.add(output);
            }
            return;
        }
        if(ind >= nums.length){
            return;
        }
        if(cur+nums[ind] <= t){
            printAllSums(t,cur+nums[ind],allSums,sum+nums[ind]+"+",nums,ind+1,out);
        }
        printAllSums(t,cur,allSums,sum,nums,ind+1,out);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true){
            int t = f.nextInt();
            int n = f.nextInt();
            if(t == 0 && n == 0){
                break;
            }
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = f.nextInt();
            }
            HashSet<String> allSums = new HashSet<>();
            out.println("Sums of " + t + ":");
            printAllSums(t,0,allSums,"",nums,0,out);
            if(allSums.size() == 0){
                out.println("NONE");
            }
        }
        f.close();
        out.close();
    }
}
