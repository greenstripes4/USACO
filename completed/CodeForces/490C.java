import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] temp = f.readLine().toCharArray();
        int[] arr = new int[temp.length];
        for(int i = 0; i < temp.length; i++) {
            arr[i] = temp[i]-'0';
        }
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0]%a;
        for(int i = 1; i < arr.length; i++) {
            prefix[i] = (prefix[i-1]*10+arr[i])%a;
        }
        int[] suffix = new int[arr.length];
        suffix[arr.length-1] = arr[arr.length-1]%b;
        int powTen = 10;
        for(int i = arr.length-2; i >= 0; i--) {
            suffix[i] = (arr[i]*powTen+suffix[i+1])%b;
            powTen = (powTen*10)%b;
        }
        boolean found = false;
        for(int i = 0; i < arr.length-1; i++) {
            if(prefix[i] == 0 && suffix[i+1] == 0 && arr[i+1] != 0) {
                found = true;
                out.println("YES");
                for(int j = 0; j <= i; j++) {
                    out.print(arr[j]);
                }
                out.println();
                for(int j = i+1; j < arr.length; j++) {
                    out.print(arr[j]);
                }
                out.println();
                break;
            }
        }
        if(!found) {
            out.println("NO");
        }
        f.close();
        out.close();
    }
}
