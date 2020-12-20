import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        HashSet<Integer> taken = new HashSet<>();
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            queue.offer(x);
            taken.add(x);
        }
        ArrayList<Integer> people = new ArrayList<>();
        int placed = 0;
        int distance = 0;
        long totalDistance = 0;
        while(placed < m) {
            int size = queue.size();
            distance++;
            for(int i = 0; i < size; i++) {
                int temp = queue.poll();
                if(!taken.contains(temp-1) && placed < m) {
                    placed++;
                    totalDistance += distance;
                    queue.offer(temp-1);
                    taken.add(temp-1);
                    people.add(temp-1);
                }
                if(!taken.contains(temp+1) && placed < m) {
                    placed++;
                    totalDistance += distance;
                    queue.offer(temp+1);
                    taken.add(temp+1);
                    people.add(temp+1);
                }
            }
        }
        out.println(totalDistance);
        out.print(people.get(0));
        for(int i = 1; i < m; i++) {
            out.print(" " + people.get(i));
        }
        out.println();
        f.close();
        out.close();
    }
}
