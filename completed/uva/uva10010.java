import java.io.*;
import java.util.*;

public class Main{
    private static boolean searchHelper(char[][] arr, String word, int i, int j, int[] dir){
        char[] chars = word.toCharArray();
        int ind = 0;
        while(ind < chars.length && i >= 0 && i < arr.length && j >= 0 && j < arr[0].length && chars[ind] == arr[i][j]){
            i += dir[0];
            j += dir[1];
            ind++;
        }
        return ind == chars.length;
    }
    private static int[] search(char[][] arr, String word){
        int[][] dir = {{1,1},{1,0},{1,-1},{0,1},{0,-1},{-1,1},{-1,0},{-1,-1}};
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                for(int[] k: dir){
                    if(searchHelper(arr,word,i,j,k)){
                        return new int[]{i+1,j+1};
                    }
                }
            }
        }
        return new int[]{0,0};
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++){
            if(t > 0){
                out.println();
            }
            f.readLine();
            StringTokenizer st = new StringTokenizer(f.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            char[][] arr = new char[m][n];
            for(int i = 0; i < m; i++){
                arr[i] = f.readLine().toLowerCase().toCharArray();
            }
            int k = Integer.parseInt(f.readLine());
            String[] queries = new String[k];
            for(int i = 0; i < k; i++){
                queries[i] = f.readLine().toLowerCase();
            }
            for(int i = 0; i < k; i++){
                int[] temp = search(arr,queries[i]);
                out.println(temp[0] + " " + temp[1]);
            }
        }
        f.close();
        out.close();
    }
}
