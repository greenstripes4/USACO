import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            int N = Integer.parseInt(input);
            int[][] matrix = new int[N][N];
            for(int i = 0; i < N; i++) {
                 StringTokenizer st = new StringTokenizer(f.readLine());
                 for(int j = 0; j < N; j++) {
                     matrix[i][j] = Integer.parseInt(st.nextToken());
                 }
            }
            int M = 0;
            ArrayList<int[]> triples = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                for(int j = i+1; j < N; j++) {
                    for(int k = j+1; k < N; k++) {
                        if(matrix[i][j] == 1 && matrix[j][k] == 1 && matrix[k][i] == 1) {
                            triples.add(new int[]{i+1,j+1,k+1});
                            M++;
                        } else if(matrix[k][j] == 1 && matrix[j][i] == 1 && matrix[i][k] == 1) {
                            triples.add(new int[]{k+1,j+1,i+1});
                            M++;
                        } else if(matrix[i][j] == 0 && matrix[j][k] == 0 && matrix[k][i] == 0 && matrix[j][i] == 0 && matrix[k][j] == 0 && matrix[i][k] == 0) {
                            triples.add(new int[]{i+1,j+1,k+1});
                            M++;
                        }
                    }
                }
            }
            Collections.sort(triples, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    if(ints[0] == t1[0]) {
                        if(ints[1] == t1[1]) {
                            return ints[2]-t1[2];
                        }
                        return ints[1]-t1[1];
                    }
                    return ints[0]-t1[0];
                }
            });
            out.println(M);
            for(int[] i: triples) {
                out.println(i[0] + " " + i[1] + " " + i[2]);
            }
        }
        f.close();
        out.close();
    }
}
