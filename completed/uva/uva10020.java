import java.io.*;
import java.util.*;

class Segment implements Comparable<Segment> {
    int L;
    int U;
    Segment(int L, int U) {
        this.L = L;
        this.U = U;
    }
    @Override
    public int compareTo(Segment o) {
        if(this.L == o.L) {
            return o.U-this.U;
        }
        return this.L-o.L;
    }
    @Override
    public String toString() {
        return this.L + " " + this.U;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = f.nextInt();
        for(int t = 0; t < testCases; t++) {
            if(t > 0) {
                out.println();
            }
            int M = f.nextInt();
            LinkedList<Segment> segments = new LinkedList<>();
            boolean segmentsFound = false;
            while(true) {
                int L = f.nextInt();
                int U = f.nextInt();
                if(L == 0 && U == 0) {
                    break;
                }
                if(U < 0 || L > M || segmentsFound) {
                    continue;
                }
                if(L <= 0 && U >= M) {
                    out.println(1);
                    out.println(L + " " + U);
                    segmentsFound = true;
                }
                segments.add(new Segment(L,U));
            }
            if(segmentsFound) {
                continue;
            }
            Collections.sort(segments);
            int end = 0;
            LinkedList<Segment> minimalCoverage = new LinkedList<>();
            while(end < M) {
                Segment nextSegment = null;
                for(Segment i: segments) {
                    if(i.L <= end && (i.U > Math.max(end,nextSegment == null ? end : nextSegment.U))) {
                        nextSegment = i;
                    }
                }
                if(nextSegment == null) {
                    break;
                }
                end = nextSegment.U;
                minimalCoverage.add(nextSegment);
            }
            if(end < M) {
                out.println(0);
                continue;
            }
            out.println(minimalCoverage.size());
            for(Segment i: minimalCoverage) {
                out.println(i);
            }
        }
        f.close();
        out.close();
    }
}
