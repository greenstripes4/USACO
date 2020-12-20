import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;
            if(i > j) {
                int temp = i;
                i = j;
                j = temp;
            }
            int[] contestants = new int[(int) Math.pow(2,N)];
            for(int k = 0; k < contestants.length; k++) {
                contestants[k] = k;
            }
            for(int k = 0; k < N; k++) {
                int[] nextRoundContestants = new int[contestants.length/2];
                boolean found = false;
                for(int l = 0; l < contestants.length-1; l += 2) {
                    if(contestants[l] == i && contestants[l+1] == j) {
                        found = true;
                        break;
                    }
                    if(contestants[l] == i || contestants[l] == j) {
                        nextRoundContestants[l/2] = contestants[l];
                    } else {
                        nextRoundContestants[l/2] = contestants[l+1];
                    }
                }
                if(found) {
                    out.println(k+1);
                    break;
                }
                contestants = nextRoundContestants;
            }
        }
        f.close();
        out.close();
    }
}
