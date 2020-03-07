import java.util.*;
import java.io.*;
public class Main{
    public static int root(int[] computers, int start){
        while(computers[start] != start){
            computers[start] = computers[computers[start]];
            start = computers[start];
        }
        return start;
    }
    public static void union(int[] computers, int[] sizes, int p, int q){
        int i = root(computers,p);
        int j = root(computers,q);
        if(i == j){
            return;
        }
        if(sizes[i] < sizes[j]){
            computers[i] = j;
            sizes[j] += sizes[i];
        } else {
            computers[j] = i;
            sizes[i] += sizes[j];
        }
    }
    public static boolean isConnected(int[] computers, int p, int q){
        return root(computers,p) == root(computers,q);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int cases = Integer.parseInt(f.readLine());
        f.readLine();
        for(int i = 0; i < cases; i++){
            int numOfComputers = Integer.parseInt(f.readLine());
            int[] computers = new int[numOfComputers];
            int[] sizes = new int[numOfComputers];
            for(int j = 0; j < numOfComputers; j++){
                computers[j] = j;
                sizes[j] = 1;
            }
            String input;
            int successfulQueries = 0;
            int unsuccessfulQueries = 0;
            while((input = f.readLine()) != null && !input.equals("")){
                StringTokenizer st = new StringTokenizer(input);
                String op = st.nextToken();
                int c1 = Integer.parseInt(st.nextToken())-1;
                int c2 = Integer.parseInt(st.nextToken())-1;
                if(op.equals("c")){
                    union(computers,sizes,c1,c2);
                } else {
                    if(isConnected(computers,c1,c2)){
                        successfulQueries++;
                    } else {
                        unsuccessfulQueries++;
                    }
                }
            }
            out.println(successfulQueries + "," + unsuccessfulQueries);
            if(i != cases-1) {
                out.println();
            }
        }
        f.close();
        out.close();
    }
}
