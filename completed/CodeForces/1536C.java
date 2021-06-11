import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        ArrayList<String> a = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("a");
        for(int i = 0; i <= 1700; i++) {
            String temp = queue.poll();
            a.add(temp);
            char[] arr = temp.toCharArray();
            int pos = -1;
            for(int j = arr.length-1; j >= 0; j--) {
                if(arr[j] != 'z') {
                    pos = j;
                    break;
                }
            }
            if(pos == -1) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j <= arr.length; j++) {
                    sb.append("a");
                }
                queue.offer(sb.toString());
            } else {
                arr[pos]++;
                for(int j = pos+1; j < arr.length; j++) {
                    arr[j] = 'a';
                }
                queue.offer(new String(arr));
            }
        }
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            String s = f.readLine();
            HashSet<String> set = new HashSet<>();
            for(int i = 1; i <= 3; i++) {
                for(int j = 0; j <= n-i; j++) {
                    set.add(s.substring(j, j+i));
                }
            }
            for(String i: a) {
                if(!set.contains(i)) {
                    out.println(i);
                    break;
                }
            }
        }
        f.close();
        out.close();
    }
}