import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(f.readLine());
        for (int i = 0; i < testCases; i++) {
            String[] w = new String[10];
            int[] r = new int[10];
            int mostPop = 0;
            for(int j = 0; j < 10; j++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                String webSite = st.nextToken();
                int rating = Integer.parseInt(st.nextToken());
                if(rating > mostPop){
                    mostPop = rating;
                }
                w[j] = webSite;
                r[j] = rating;
            }
            System.out.println("Case #" + (i+1) + ":");
            for(int k = 0; k<10; k++){
                if(r[k] == mostPop){
                    System.out.println(w[k]);
                }
            }
        }
    }
}
