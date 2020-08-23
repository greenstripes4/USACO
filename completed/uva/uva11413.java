import java.io.*;
import java.util.*;

public class Main {
    private static boolean isValidMaximumCapacity(int n, int m, int[] c, int minimumMaximumCapacity) {
        int containersUsed = 0;
        int currentContainerCapacity = minimumMaximumCapacity;
        int currentVesselIndex = 0;
        while(currentVesselIndex < n && containersUsed < m) {
            if(c[currentVesselIndex] <= currentContainerCapacity) {
                currentContainerCapacity -= c[currentVesselIndex];
                currentVesselIndex++;
            } else {
                containersUsed++;
                currentContainerCapacity = minimumMaximumCapacity;
            }
        }
        return currentVesselIndex == n;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] c = new int[n];
            st = new StringTokenizer(f.readLine());
            int totalMilk = 0;
            for(int i = 0; i < n; i++) {
                c[i] = Integer.parseInt(st.nextToken());
                totalMilk += c[i];
            }
            int low = (int) Math.ceil(((double) totalMilk)/m);
            int high = totalMilk;
            int minimumMaximumCapacity = -1;
            while(low <= high) {
                int mid = (low+high)/2;
                if(isValidMaximumCapacity(n,m,c,mid)) {
                    minimumMaximumCapacity = mid;
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
            out.println(minimumMaximumCapacity);
        }
        f.close();
        out.close();
    }
}
