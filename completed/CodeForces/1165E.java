import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        ArrayList<Long> a = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            long ai = Integer.parseInt(st.nextToken());
            ai *= i+1;
            ai *= n-i;
            a.add(ai);
        }
        st = new StringTokenizer(f.readLine());
        ArrayList<Long> b = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            b.add((long) Integer.parseInt(st.nextToken()));
        }
        Collections.sort(a);
        Collections.sort(b);
        Collections.reverse(b);
        long ans = 0;
        for(int i = 0; i < n; i++) {
            ans = (ans+a.get(i)%998244353*b.get(i))%998244353;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}