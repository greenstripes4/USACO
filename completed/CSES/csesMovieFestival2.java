import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] movies = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            movies[i][0] = Integer.parseInt(st.nextToken());
            movies[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(movies, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[1]-t1[1];
            }
        });
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, k);
        int count = 0;
        for(int[] i: movies) {
            Integer temp = map.floorKey(i[0]);
            if(temp != null) {
                count++;
                int left = map.get(temp)-1;
                if(left == 0) {
                    map.remove(temp);
                } else {
                    map.put(temp, left);
                }
                map.put(i[1], map.getOrDefault(i[1], 0)+1);
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}