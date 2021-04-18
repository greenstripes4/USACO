import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int P = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        HashSet<Integer> distinct = new HashSet<Integer>();
        int[] arr = new int[P];
        for(int i = 0; i < P; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            distinct.add(arr[i]);
        }
        HashMap<Integer, Integer> current = new HashMap<Integer, Integer>();
        int i = 0;
        int j = 0;
        int ans = P;
        while(j <= P) {
            if(current.size() == distinct.size()) {
                ans = Math.min(ans, j-i);
                current.put(arr[i], current.get(arr[i])-1);
                if(current.get(arr[i]) == 0) {
                    current.remove(arr[i]);
                }
                i++;
            } else {
                if(j == P) {
                    break;
                }
                if(!current.containsKey(arr[j])) {
                    current.put(arr[j], 0);
                }
                current.put(arr[j], current.get(arr[j])+1);
                j++;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}