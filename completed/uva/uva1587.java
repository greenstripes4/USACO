/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null){
            int[][] faces = new int[6][2];
            StringTokenizer st = new StringTokenizer(input);
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if(l > h){
                int temp = l;
                l = h;
                h = temp;
            }
            faces[0][0] = l;
            faces[0][1] = h;
            for(int i = 1; i <= 5; i++){
                StringTokenizer face = new StringTokenizer(f.readLine());
                int a = Integer.parseInt(face.nextToken());
                int b = Integer.parseInt(face.nextToken());
                if(a > b){
                    int temp = a;
                    a = b;
                    b = temp;
                }
                faces[i][0] = a;
                faces[i][1] = b;
            }
            Arrays.sort(faces, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] == o2[0]){
                        if(o1[1] == o2[1]){
                            return 0;
                        }
                        return o1[1] > o2[1] ? 1:-1;
                    }
                    return o1[0] > o2[0] ? 1:-1;
                }
            });
            boolean v1 = faces[0][0] == faces[1][0] && faces[0][0] == faces[2][0] && faces[0][0] == faces[3][0];
            boolean v2 = faces[4][0] == faces[5][0] && faces[4][0] == faces[0][1] && faces[4][0] == faces[1][1];
            boolean v3 = faces[2][1] == faces[3][1] && faces[2][1] == faces[4][1] && faces[2][1] == faces[5][1];
            out.println(v1 && v2 && v3 ? "POSSIBLE" : "IMPOSSIBLE");
        }
        out.close();
        f.close();
    }
}
