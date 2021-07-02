import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[m][n-1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int[] temp = new int[n];
            for(int j = 0; j < n; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 0; j < n-1; j++) {
                a[i][j] = temp[n-1]-temp[j];
            }
        }
        int max = 0;
        ArrayList<Integer> remove = new ArrayList<>();
        for(int i = 1; i <= m; i++) {
            remove.add(i);
        }
        for(int i = 0; i < n-1; i++) {
            int v = i;
            Integer[] temp = new Integer[m];
            for(int j = 0; j < m; j++) {
                temp[j] = j;
            }
            Arrays.sort(temp, new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return a[integer][v]-a[t1][v];
                }
            });
            boolean[] cur = new boolean[m];
            int cnt = 0;
            int sum = 0;
            for(int j = 0; j < m; j++) {
                if(sum+a[temp[j]][i] > 0) {
                    break;
                }
                cnt++;
                cur[temp[j]] = true;
                sum += a[temp[j]][i];
            }
            if(cnt > max) {
                max = cnt;
                remove.clear();
                for(int j = 0; j < m; j++) {
                    if(!cur[j]) {
                        remove.add(j+1);
                    }
                }
            }
        }
        out.println(m-max);
        if(remove.size() > 0) {
            out.print(remove.get(0));
            for(int i = 1; i < remove.size(); i++) {
                out.print(" " + remove.get(i));
            }
        }
        out.println();
        f.close();
        out.close();
    }
}