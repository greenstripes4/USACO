import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken())-1;
            char[] arr = f.readLine().toCharArray();
            char[] tar = new char[n];
            for(int i = 0; i < k; i++) {
                tar[i*2] = '(';
                tar[i*2+1] = ')';
            }
            for(int i = 0; i < (n-2*k)/2; i++) {
                tar[2*k+i] = '(';
            }
            for(int i = 0; i < (n-2*k)/2; i++) {
                tar[n-(n-2*k)/2+i] = ')';
            }
            ArrayList<String> res = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                if(arr[i] != tar[i]) {
                    for(int j = i+1; j < n; j++) {
                        if(arr[j] == tar[i]) {
                            res.add((i+1) + " " + (j+1));
                            for(int l = i; l <= (i+j)/2; l++) {
                                char temp = arr[l];
                                arr[l] = arr[i+j-l];
                                arr[i+j-l] = temp;
                            }
                            break;
                        }
                    }
                }
            }
            out.println(res.size());
            for(String i: res) {
                out.println(i);
            }
        }
        f.close();
        out.close();
    }
}