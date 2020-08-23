import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int M = Integer.parseInt(f.readLine());
        for(int t = 0; t < M; t++) {
            f.readLine();
            if(t > 0) {
                out.println();
            }
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char[][] dnaSequences = new char[m][n];
            for(int i = 0; i < m; i++) {
                dnaSequences[i] = f.readLine().toCharArray();
            }
            Arrays.sort(dnaSequences, new Comparator<char[]>() {
                @Override
                public int compare(char[] chars, char[] t1) {
                    int sortedFactor1 = 0;
                    for(int i = 0; i < n; i++) {
                        for(int j = i+1; j < n; j++) {
                            if(chars[i] > chars[j]) {
                                sortedFactor1++;
                            }
                        }
                    }
                    int sortedFactor2 = 0;
                    for(int i = 0; i < n; i++) {
                        for(int j = i+1; j < n; j++) {
                            if(t1[i] > t1[j]) {
                                sortedFactor2++;
                            }
                        }
                    }
                    return sortedFactor1-sortedFactor2;
                }
            });
            for(char[] i: dnaSequences) {
                out.println(i);
            }
        }
        f.close();
        out.close();
    }
}
