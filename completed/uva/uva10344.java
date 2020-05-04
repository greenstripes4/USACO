import java.io.*;
import java.util.*;

public class Main{
    private static boolean dfs(int used, int total, int[] nums, boolean[] visited){
        if(used == 5){
            return total == 23;
        }
        for(int i = 0; i < 5; i++){
            if(!visited[i]){
                visited[i] = true;
                if(dfs(used+1,total+nums[i],nums,visited) || dfs(used+1,total*nums[i],nums,visited) || dfs(used+1,total-nums[i],nums,visited)){
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true){
            int[] nums = {f.nextInt(),f.nextInt(),f.nextInt(),f.nextInt(),f.nextInt()};
            if(Arrays.equals(nums,new int[]{0,0,0,0,0})){
                break;
            }
            boolean[] visited = new boolean[5];
            boolean found = false;
            for(int i = 0; i < 5; i++){
                visited[i] = true;
                if(dfs(1,nums[i],nums,visited)){
                    found = true;
                    out.println("Possible");
                    break;
                }
                visited[i] = false;
            }
            if(!found){
                out.println("Impossible");
            }
        }
        f.close();
        out.close();
    }
}
