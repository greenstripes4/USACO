import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        // Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true){
            int N = f.nextInt();
            int M = f.nextInt();
            out.println(N + " " + M);
            if(N == 0 && M == 0){
                break;
            }
            Long[] arr = new Long[N];
            for(int i = 0; i < N; i++){
                arr[i] = f.nextLong();
            }
            Arrays.sort(arr, new Comparator<Long>() {
                @Override
                public int compare(Long a, Long b) {
                    long aModM = a < 0 ? -((-a)%M):a%M;
                    long bModM = b < 0 ? -((-b)%M):b%M;
                    if(aModM == bModM){
                        if(Math.abs(a)%2 == 0 && Math.abs(b)%2 == 0){
                            return a.compareTo(b);
                        } else if(Math.abs(a)%2 == 0) {
                            return 1;
                        } else if(Math.abs(b)%2 == 0) {
                            return -1;
                        } else {
                            return b.compareTo(a);
                        }
                    }
                    return aModM < bModM ? -1:1;
                }
            });
            for(long i: arr){
                out.println(i);
            }
        }
        f.close();
        out.close();
    }
}
