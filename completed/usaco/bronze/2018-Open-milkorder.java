import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static int contains(int obj, int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == obj){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("milkorder.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringTokenizer socialClasses = new StringTokenizer(f.readLine());
        int[] ordering = new int[M];
        for(int i = 0; i < M; i++){
            ordering[i] = Integer.parseInt(socialClasses.nextToken());
        }
        int[] positions = new int[N];
        for(int i = 0; i < K; i++){
            StringTokenizer required = new StringTokenizer(f.readLine());
            int cow = Integer.parseInt(required.nextToken());
            int pos = Integer.parseInt(required.nextToken()) - 1;
            positions[pos] = cow;
        }
        for(int i = 0; i < positions.length; i++){
            if(positions[i] == 0){
                int[] temp = positions.clone();
                temp[i] = 1;
                int ind = 0;
                for(int j = 0; j < temp.length; j++){
                    if(temp[j] == 0 && contains(ordering[ind],temp) == -1){
                        temp[j] = ordering[ind];
                        ind++;
                    } else if(contains(ordering[ind],temp) != -1){
                        j = contains(ordering[ind],temp);
                        ind++;
                    }
                    if(ind == M){
                        break;
                    }
                }
                int[] currentOrdering = new int[M];
                for(int j = 0; j < M; j++){
                    currentOrdering[j] = -1;
                }
                for(int j = 0; j < temp.length; j++){
                    if(contains(temp[j], ordering) != -1){
                        currentOrdering[contains(temp[j], ordering)] = j;
                    }
                }
                boolean valid = true;
                for(int j = 0; j < M; j++){
                    if(currentOrdering[j] == -1){
                        valid = false;
                    }
                }
                int curNum = currentOrdering[0];
                for(int j = 0; j < M; j++){
                    if(currentOrdering[j] < curNum){
                        valid = false;
                        break;
                    }
                    curNum = currentOrdering[j];
                }
                if(valid){
                    out.println(i+1);
                    break;
                }
            }
        }
        f.close();
        out.close();
    }
}
