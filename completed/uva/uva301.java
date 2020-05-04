import java.io.*;
import java.util.*;

public class Main{
    private static int max;
    private static void dfs(int n, int[] stations, int[][] orders, int ind, int earnings){
        if(ind == orders.length){
            max = Math.max(max,earnings);
            return;
        }
        dfs(n,stations,orders,ind+1,earnings);
        boolean canFit = true;
        for(int i = orders[ind][0]; i < orders[ind][1]; i++){
            if(stations[i]+orders[ind][2] > n){
                canFit = false;
                break;
            }
        }
        if(canFit){
            for(int i = orders[ind][0]; i < orders[ind][1]; i++){
                stations[i] += orders[ind][2];
            }
            dfs(n,stations,orders,ind+1,earnings+(orders[ind][1]-orders[ind][0])*orders[ind][2]);
            for(int i = orders[ind][0]; i < orders[ind][1]; i++){
                stations[i] -= orders[ind][2];
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true){
            int n = f.nextInt();
            int m = f.nextInt();
            int numOrders = f.nextInt();
            if(n == 0 && m == 0 && numOrders == 0){
                break;
            }
            int[] stations = new int[m+1];
            int[][] orders = new int[numOrders][3];
            for(int i = 0; i < numOrders; i++){
                int start = f.nextInt();
                int end = f.nextInt();
                int passengers = f.nextInt();
                orders[i][0] = start;
                orders[i][1] = end;
                orders[i][2] = passengers;
            }
            max = 0;
            dfs(n,stations,orders,0,0);
            out.println(max);
        }
        f.close();
        out.close();
    }
}
