import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[][] exams = new int[n][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            exams[i][0] = Integer.parseInt(st.nextToken());
            exams[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(exams, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if(ints[0] == t1[0]) {
                    return ints[1]-t1[1];
                }
                return ints[0]-t1[0];
            }
        });
        int lastTime = 0;
        for(int i = 0; i < n; i++) {
            if(exams[i][1] >= lastTime) {
                lastTime = exams[i][1];
            } else {
                lastTime = exams[i][0];
            }
        }
        out.println(lastTime);
        f.close();
        out.close();
    }
}
