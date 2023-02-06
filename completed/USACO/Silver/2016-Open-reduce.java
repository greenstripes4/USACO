import java.io.*;
        import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("reduce.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        int[][] sortedByX = new int[N][2];
        int[][] sortedByY = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sortedByX[i][0] = x;
            sortedByX[i][1] = y;
            sortedByY[i][0] = x;
            sortedByY[i][1] = y;
        }
        Arrays.sort(sortedByX, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if(ints[0] == t1[0]) {
                    return ints[1]-t1[1];
                }
                return ints[0]-t1[0];
            }
        });
        Arrays.sort(sortedByY, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if(ints[1] == t1[1]) {
                    return ints[0]-t1[0];
                }
                return ints[1]-t1[1];
            }
        });
        HashSet<Integer> eliminationChoices = new HashSet<>();
        eliminationChoices.add(0);
        eliminationChoices.add(1);
        eliminationChoices.add(2);
        eliminationChoices.add(N-3);
        eliminationChoices.add(N-2);
        eliminationChoices.add(N-1);
        int bestArea = 1599920002;
        for(int i: eliminationChoices) {
            for(int j: eliminationChoices) {
                if(i != j) {
                    for(int k: eliminationChoices) {
                        if(i != k && j != k) {
                            int[][] option1 = {sortedByX[i],sortedByX[j],sortedByX[k]};
                            int[][] option2 = {sortedByX[i],sortedByX[j],sortedByY[k]};
                            int[][] option3 = {sortedByX[i],sortedByY[j],sortedByX[k]};
                            int[][] option4 = {sortedByX[i],sortedByY[j],sortedByY[k]};
                            int[][] option5 = {sortedByY[i],sortedByX[j],sortedByX[k]};
                            int[][] option6 = {sortedByY[i],sortedByX[j],sortedByY[k]};
                            int[][] option7 = {sortedByY[i],sortedByY[j],sortedByX[k]};
                            int[][] option8 = {sortedByY[i],sortedByY[j],sortedByY[k]};
                            int[][][] allOptions = {option1,option2,option3,option4,option5,option6,option7,option8};
                            for(int[][] l: allOptions) {
                                int minX = 0;
                                int maxX = 0;
                                int minY = 0;
                                int maxY = 0;
                                for(int m = 0; m < N; m++) {
                                    boolean removed = false;
                                    for(int[] n: l) {
                                        if(Arrays.equals(sortedByX[m],n)) {
                                            removed = true;
                                        }
                                    }
                                    if(!removed) {
                                        minX = sortedByX[m][0];
                                        break;
                                    }
                                }
                                for(int m = N-1; m >= 0; m--) {
                                    boolean removed = false;
                                    for(int[] n: l) {
                                        if(Arrays.equals(sortedByX[m],n)) {
                                            removed = true;
                                        }
                                    }
                                    if(!removed) {
                                        maxX = sortedByX[m][0];
                                        break;
                                    }
                                }
                                for(int m = 0; m < N; m++) {
                                    boolean removed = false;
                                    for(int[] n: l) {
                                        if(Arrays.equals(sortedByY[m],n)) {
                                            removed = true;
                                        }
                                    }
                                    if(!removed) {
                                        minY = sortedByY[m][1];
                                        break;
                                    }
                                }
                                for(int m = N-1; m >= 0; m--) {
                                    boolean removed = false;
                                    for(int[] n: l) {
                                        if(Arrays.equals(sortedByY[m],n)) {
                                            removed = true;
                                        }
                                    }
                                    if(!removed) {
                                        maxY = sortedByY[m][1];
                                        break;
                                    }
                                }
                                bestArea = Math.min(bestArea,(maxX-minX)*(maxY-minY));
                            }
                        }
                    }
                }
            }
        }
        out.println(bestArea);
        f.close();
        out.close();
    }
}
