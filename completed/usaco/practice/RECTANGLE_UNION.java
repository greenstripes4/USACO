import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        int[][] rectangles = new int[N][4];
        int[][] verticalEdges = new int[2*N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            rectangles[i][0] = Integer.parseInt(st.nextToken());
            rectangles[i][2] = Integer.parseInt(st.nextToken());
            rectangles[i][1] = Integer.parseInt(st.nextToken());
            rectangles[i][3] = Integer.parseInt(st.nextToken());
            verticalEdges[2*i][0] = i;
            verticalEdges[2*i][1] = 0;
            verticalEdges[2*i+1][0] = i;
            verticalEdges[2*i+1][1] = 1;
        }
        Arrays.sort(verticalEdges, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                int xDifference = rectangles[ints[0]][ints[1]]-rectangles[t1[0]][t1[1]];
                if(xDifference == 0) {
                    return t1[1]-ints[1];
                }
                return xDifference;
            }
        });
        TreeMap<int[], Integer> activeRectangles = new TreeMap<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                int yDifference = rectangles[ints[0]][ints[1]]-rectangles[t1[0]][t1[1]];
                if(yDifference == 0) {
                    return t1[1]-ints[1];
                }
                return yDifference;
            }
        });
        long unionArea = 0;
        int lastX = -1;
        for(int[] i: verticalEdges) {
            if(activeRectangles.size() > 0) {
                int totalHeight = 0;
                int active = 0;
                int lastY = -1;
                for(int[] j: activeRectangles.keySet()) {
                    int occurances = activeRectangles.get(j);
                    for(int k = 0; k < occurances; k++) {
                        if(active > 0) {
                            totalHeight += rectangles[j[0]][j[1]]-lastY;
                        }
                        if(j[1] == 2) {
                            active++;
                        } else {
                            active--;
                        }
                        lastY = rectangles[j[0]][j[1]];
                    }
                }
                unionArea += totalHeight*(rectangles[i[0]][i[1]]-lastX);
            }
            int[] bottomEdge = new int[]{i[0], 2};
            int[] topEdge = new int[]{i[0], 3};
            if(i[1] == 0) {
                if(activeRectangles.containsKey(bottomEdge)) {
                    activeRectangles.put(bottomEdge, activeRectangles.get(bottomEdge)+1);
                } else {
                    activeRectangles.put(bottomEdge, 1);
                }
                if(activeRectangles.containsKey(topEdge)) {
                    activeRectangles.put(topEdge, activeRectangles.get(topEdge)+1);
                } else {
                    activeRectangles.put(topEdge, 1);
                }
            } else {
                if(activeRectangles.get(bottomEdge) == 1) {
                    activeRectangles.remove(bottomEdge);
                } else {
                    activeRectangles.put(bottomEdge, activeRectangles.get(bottomEdge)-1);
                }
                if(activeRectangles.get(topEdge) == 1) {
                    activeRectangles.remove(topEdge);
                } else {
                    activeRectangles.put(topEdge, activeRectangles.get(topEdge)-1);
                }
            }
            lastX = rectangles[i[0]][i[1]];
        }
        out.println(unionArea);
        f.close();
        out.close();
    }
}