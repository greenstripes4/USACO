import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        String[] arr = new String[M];
        for(int i = 0; i < M; i++) {
            arr[i] = f.readLine();
        }
        for(int i = 0; i < Q; i++) {
            int minimumIndex = -1;
            int minimumHammingDistance = Integer.MAX_VALUE;
            char[] query = f.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                if(arr[j].length() >= query.length) {
                    for(int k = 0; k <= arr[j].length()-query.length; k++) {
                        char[] substr = arr[j].substring(k, k+query.length).toCharArray();
                        int hammingDistance = 0;
                        for(int l = 0; l < query.length; l++) {
                            if(substr[l] != query[l]) {
                                hammingDistance++;
                            }
                        }
                        if(hammingDistance < minimumHammingDistance) {
                            minimumHammingDistance = hammingDistance;
                            minimumIndex = j;
                        }
                    }
                }
            }
            out.println(minimumIndex+1);
        }
        f.close();
        out.close();
    }
}
