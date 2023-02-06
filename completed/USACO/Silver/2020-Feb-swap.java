import java.io.*;
import java.util.*;

public class Main {
    private static String encode(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int i: arr) {
            sb.append(i);
            sb.append("\n");
        }
        return sb.toString();
    }
    private static void reverseAll(int[] arr, int[][] reverses) {
        for(int[] i: reverses) {
            int end = (i[0]+i[1])/2;
            for(int j = i[0]; j <= end; j++) {
                int temp = arr[j];
                arr[j] = arr[i[1]-j+i[0]];
                arr[i[1]-j+i[0]] = temp;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("swap.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        int[][] reverses = new int[M][2];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            reverses[i][0] = Integer.parseInt(st.nextToken())-1;
            reverses[i][1] = Integer.parseInt(st.nextToken())-1;
        }
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        boolean cycleFound = false;
        while(list.size() <= K) {
            String encoded = encode(arr);
            if(map.containsKey(encoded)) {
                cycleFound = true;
                int start = map.get(encoded);
                int length = list.size()-start;
                K = start+(K-start)%length;
                out.print(list.get(K));
                break;
            }
            map.put(encoded, list.size());
            list.add(encoded);
            reverseAll(arr, reverses);
        }
        if(!cycleFound) {
            out.print(list.get(K));
        }
        f.close();
        out.close();
    }
}
