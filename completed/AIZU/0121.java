import java.io.*;
import java.util.*;

public class Main {
    private static int encode(int[] arr) {
        int res = 0;
        for(int i = 0; i < 8; i++) {
            res = res*10+arr[i];
        }
        return res;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static ArrayList<int[]> getNeighbors(int[] arr) {
        ArrayList<int[]> res = new ArrayList<>();
        int idx = -1;
        for(int i = 0; i < 8; i++) {
            if(arr[i] == 0) {
                idx = i;
                break;
            }
        }
        int[] p = {idx-1, idx+1, idx-4, idx+4};
        for(int i: p) {
            if(i >= 0 && i < 8 && !(idx == 3 && i == 4) && !(idx == 4 && i == 3)) {
                int[] temp = arr.clone();
                swap(temp, idx, i);
                res.add(temp);
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<int[]> queue = new LinkedList<int[]>();
        HashSet<Integer> visited = new HashSet<Integer>();
        queue.offer(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        visited.add(1234567);
        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                map.put(encode(temp), steps);
                for(int[] j: getNeighbors(temp)) {
                    int ej = encode(j);
                    if(!visited.contains(ej)) {
                        queue.offer(j);
                        visited.add(ej);
                    }
                }
            }
            steps++;
        }
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int[] source = new int[8];
            for(int i = 0; i < 8; i++) {
                source[i] = Integer.parseInt(st.nextToken());
            }
            out.println(map.get(encode(source)));
        }
        f.close();
        out.close();
    }
}