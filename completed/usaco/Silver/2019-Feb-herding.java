import java.io.*;
import java.util.*;

public class Main {
    private static int binarySearch(int[] locations, int upperBound) {
        int low = 0;
        int high = locations.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(locations[mid] <= upperBound) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("herding.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
        int N = Integer.parseInt(f.readLine());
        int[] locations = new int[N];
        for(int i = 0; i < N; i++) {
            locations[i] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(locations);
        int minimum = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            int index = binarySearch(locations, locations[i]+N-1);
            int moves = N-index+i-1;
            if(index-i+1 == N-1 && locations[i]+N-1 == locations[index]+1) {
                moves = 2;
            }
            minimum = Math.min(minimum, moves);
        }
        out.println(minimum);
        out.println(Math.max(locations[N-2]-locations[0], locations[N-1]-locations[1])-N+2);
        f.close();
        out.close();
    }
}
