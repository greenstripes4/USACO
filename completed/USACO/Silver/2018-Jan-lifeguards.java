import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
        int N = Integer.parseInt(f.readLine());
        int[][] startAndEndTimes = new int[N*2][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            startAndEndTimes[i*2][0] = start;
            startAndEndTimes[i*2][1] = i;
            startAndEndTimes[i*2+1][0] = end;
            startAndEndTimes[i*2+1][1] = i;
        }
        Arrays.sort(startAndEndTimes, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });
        HashSet<Integer> onShift = new HashSet<>();
        int[] aloneOnShift = new int[N];
        int coverage = 0;
        for(int i = 0; i < N*2; i++) {
            if(onShift.size() > 0) {
                coverage += startAndEndTimes[i][0]-startAndEndTimes[i-1][0];
                if(onShift.size() == 1) {
                    for(int j: onShift) {
                        aloneOnShift[j] += startAndEndTimes[i][0]-startAndEndTimes[i-1][0];
                    }
                }
            }
            if(onShift.contains(startAndEndTimes[i][1])) {
                onShift.remove(startAndEndTimes[i][1]);
            } else {
                onShift.add(startAndEndTimes[i][1]);
            }
        }
        int maxCoverageLeft = 0;
        for(int i: aloneOnShift) {
            maxCoverageLeft = Math.max(maxCoverageLeft,coverage-i);
        }
        out.println(maxCoverageLeft);
        f.close();
        out.close();
    }
}
