import sun.awt.im.CompositionArea;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("moop.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moop.out")));
        int N = Integer.parseInt(f.readLine());
        int[][] particles = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            particles[i][0] = Integer.parseInt(st.nextToken());
            particles[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(particles, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if(ints[0] == t1[0]) {
                    return ints[1]-t1[1];
                }
                return ints[0]-t1[0];
            }
        });
        int[] minLeft = new int[N];
        minLeft[0] = particles[0][1];
        for(int i = 1; i < N; i++) {
            minLeft[i] = Math.min(minLeft[i-1], particles[i][1]);
        }
        int[] maxRight = new int[N];
        maxRight[N-1] = particles[N-1][1];
        for(int i = N-2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], particles[i][1]);
        }
        int count = 1;
        for(int i = 0; i < N-1; i++) {
            if(minLeft[i] > maxRight[i+1]) {
                count++;
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}
