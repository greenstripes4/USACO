import java.io.*;
import java.util.*;

public class Main {
    private static int bruteforce(ArrayList<Integer> a, ArrayList<Integer> b, int n) {
        int ans = 0;
        while(true) {
            Collections.sort(a, Comparator.reverseOrder());
            Collections.sort(b, Comparator.reverseOrder());
            int sa = 0;
            int sb = 0;
            for(int i = 0; i < (n+ans)-(n+ans)/4; i++) {
                sa += a.get(i);
                sb += b.get(i);
            }
            if(sa >= sb) {
                break;
            }
            a.add(100);
            b.add(0);
            ans++;
        }
        return ans;
    }
    private static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = 100;
        while(t-- > 0) {
            int n = 10;
            //StringTokenizer st = new StringTokenizer(f.readLine());
            PriorityQueue<Integer> a = new PriorityQueue<>();
            ArrayList<Integer> aa = new ArrayList<>();
            int sa = 0;
            for(int i = 0; i < n; i++) {
                int ai = getRandomNumberUsingNextInt(0, 100);
                a.offer(ai);
                aa.add(ai);
                sa += ai;
            }
            //st = new StringTokenizer(f.readLine());
            PriorityQueue<Integer> b = new PriorityQueue<>();
            ArrayList<Integer> bb = new ArrayList<>();
            int sb = 0;
            for(int i = 0; i < n; i++) {
                int bi = getRandomNumberUsingNextInt(0, 100);
                b.offer(bi);
                bb.add(bi);
                sb += bi;
            }
            Stack<Integer> temp = new Stack<>();
            for(int i = 0; i < n/4; i++) {
                sa -= a.poll();
                int min = b.poll();
                sb -= min;
                temp.push(min);
            }
            int ans = 0;
            while(sa < sb) {
                ans++;
                a.offer(100);
                sa += 100;
                if(!temp.isEmpty()) {
                    int max = temp.pop();
                    b.offer(max);
                    sb += max;
                } else {
                    b.offer(0);
                }
                if((n+ans)/4 > (n+ans-1)/4) {
                    sa -= a.poll();
                    sb -= b.poll();
                }
            }
            if(ans != bruteforce(aa, bb, n)) {
                for(int i: aa) {
                    out.print(i + " ");
                }
                out.println();
                for(int i: bb) {
                    out.print(i + " ");
                }
                out.println();
                out.println(ans);
                out.println(bruteforce(aa, bb, n));
                break;
            }
        }
        f.close();
        out.close();
    }
}