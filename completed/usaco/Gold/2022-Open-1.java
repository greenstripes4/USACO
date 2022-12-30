import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        int[][] events = new int[N][4];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            events[i][0] = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            events[i][3] = Integer.parseInt(st.nextToken());
            events[i][1] = t-x;
            events[i][2] = t+x;
        }
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[2]-o2[2] : o1[1]-o2[1];
            }
        });
        TreeMap<Integer, Integer> map = new TreeMap<>();
        long ans = 0;
        for(int[] i: events) {
            if(i[0] == 1) {
                map.put(i[2], map.getOrDefault(i[2], 0)+i[3]);
            } else {
                Integer temp = map.floorKey(i[2]);
                while(temp != null && i[3] > 0) {
                    int cows = map.get(temp);
                    if(cows > i[3]) {
                        map.put(temp, cows-i[3]);
                        ans += i[3];
                        i[3] = 0;
                    } else {
                        map.remove(temp);
                        ans += cows;
                        i[3] -= cows;
                        temp = map.lowerKey(temp);
                    }
                }
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
