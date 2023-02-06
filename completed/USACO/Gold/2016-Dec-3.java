import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("lasers.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lasers.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int xL = Integer.parseInt(st.nextToken());
        int yL = Integer.parseInt(st.nextToken());
        int xB = Integer.parseInt(st.nextToken());
        int yB = Integer.parseInt(st.nextToken());
        HashMap<Integer, ArrayList<Integer>> xToY = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> yToX = new HashMap<>();
        xToY.putIfAbsent(xB, new ArrayList<>());
        yToX.putIfAbsent(yB, new ArrayList<>());
        xToY.get(xB).add(yB);
        yToX.get(yB).add(xB);
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xToY.putIfAbsent(x, new ArrayList<>());
            yToX.putIfAbsent(y, new ArrayList<>());
            xToY.get(x).add(y);
            yToX.get(y).add(x);
        }
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer(xL + " " + yL + " 0");
        queue.offer(xL + " " + yL + " 1");
        visited.add(xL + " " + yL + " 0");
        visited.add(xL + " " + yL + " 1");
        int steps = 0;
        boolean found = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String cur = queue.poll();
                st = new StringTokenizer(cur);
                int[] coor = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
                if(coor[0] == xB && coor[1] == yB) {
                    found = true;
                    break;
                }
                int dir = Integer.parseInt(st.nextToken());
                if(dir == 0) {
                    if(!yToX.containsKey(coor[1])) {
                        continue;
                    }
                    for(int j: yToX.get(coor[1])) {
                        if(j == coor[0]) {
                            continue;
                        }
                        String next = j + " " + coor[1] + " 1";
                        if(!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                } else {
                    if(!xToY.containsKey(coor[0])) {
                        continue;
                    }
                    for(int j: xToY.get(coor[0])) {
                        if(j == coor[1]) {
                            continue;
                        }
                        String next = coor[0] + " " + j + " 0";
                        if(!visited.contains(next)) {
                            queue.offer(next);
                        }
                    }
                }
            }
            if(found) {
                break;
            }
            steps++;
        }
        out.println(found ? steps-1 : -1);
        f.close();
        out.close();
    }
}
