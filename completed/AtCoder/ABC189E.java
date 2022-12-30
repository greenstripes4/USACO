import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        long[][] points = new long[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(f.readLine());
        long[][] op = new long[M][2];
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            op[i][0] = Integer.parseInt(st.nextToken());
            if(op[i][0] > 2) {
                op[i][1] = Integer.parseInt(st.nextToken());
            }
        }
        int Q = Integer.parseInt(f.readLine());
        int[][] queries = new int[Q][2];
        Integer[] idx = new Integer[Q];
        for(int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken())-1;
            idx[i] = i;
        }
        Arrays.sort(idx, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return queries[o1][0]-queries[o2][0];
            }
        });
        String[] res = new String[Q];
        long[] constants = new long[2];
        int[] variables = new int[2];
        variables[0] = 1;
        variables[1] = 2;
        int j = 0;
        for(int i: idx) {
            while(j < queries[i][0]) {
                if(op[j][0] == 1) {
                    long temp = constants[0];
                    constants[0] = constants[1];
                    constants[1] = -temp;
                    temp = variables[0];
                    variables[0] = variables[1];
                    variables[1] = (int) -temp;
                } else if(op[j][0] == 2) {
                    long temp = constants[0];
                    constants[0] = -constants[1];
                    constants[1] = temp;
                    temp = variables[0];
                    variables[0] = -variables[1];
                    variables[1] = (int) temp;
                } else if(op[j][0] == 3) {
                    constants[0] = 2*op[j][1]-constants[0];
                    variables[0] = -variables[0];
                } else {
                    constants[1] = 2*op[j][1]-constants[1];
                    variables[1] = -variables[1];
                }
                j++;
            }
            long x = points[queries[i][1]][Math.abs(variables[0])-1];
            long y = points[queries[i][1]][Math.abs(variables[1])-1];
            if(variables[0] < 0) {
                x = -x;
            }
            if(variables[1] < 0) {
                y = -y;
            }
            x += constants[0];
            y += constants[1];
            res[i] = x + " " + y;
        }
        for(String i: res) {
            out.println(i);
        }
        f.close();
        out.close();
    }
}
