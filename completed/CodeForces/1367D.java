import sun.awt.im.CompositionArea;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int q = Integer.parseInt(f.readLine());
        for(int t = 0; t < q; t++) {
            TreeMap<Character, Integer> max = new TreeMap<>(new Comparator<Character>() {
                @Override
                public int compare(Character integer, Character t1) {
                    return t1-integer;
                }
            });
            char[] s = f.readLine().toCharArray();
            for(char i: s) {
                max.put(i, max.getOrDefault(i, 0)+1);
            }
            int m = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] b = new int[m];
            for(int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
            char[] solution = new char[m];
            int count = 0;
            while(count < m) {
                HashSet<Integer> zeros = new HashSet<>();
                for(int i = 0; i < m; i++) {
                    if(b[i] == 0) {
                        zeros.add(i);
                    }
                }
                char next = ' ';
                while(true) {
                    char temp = max.firstKey();
                    if(max.get(temp) >= zeros.size()) {
                        next = temp;
                        break;
                    }
                    max.remove(temp);
                }
                max.remove(next);
                for(int i = 0; i < m; i++) {
                    if(b[i] == 0) {
                        b[i] = -1;
                        solution[i] = next;
                        count++;
                    } else {
                        for(int j: zeros) {
                            b[i] -= Math.abs(i-j);
                        }
                    }
                }
            }
            out.println(solution);
        }
        f.close();
        out.close();
    }
}
