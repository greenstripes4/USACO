import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int result = 0;
            boolean end = true;
            int[] boxes = new int[7];
            for (int i = 1; i < 7; i++) {
                boxes[i] = Integer.parseInt(st.nextToken());
                if (boxes[i] != 0) {
                    end = false;
                }
            }
            if(end) {
                break;
            }
            result += boxes[6];
            boxes[6] = 0;
            while (boxes[5] > 0) {
                result++;
                boxes[5]--;
                int one_remaining = 11;
                int taken = Math.min(one_remaining,boxes[1]);
                boxes[1] -= taken;
            }
            while (boxes[4] > 0) {
                result++;
                boxes[4]--;
                int two_remaining = 5;
                int one_remaining = 20;
                int taken = Math.min(two_remaining, boxes[2]);
                boxes[2] -= taken;
                one_remaining -= 4 * taken;
                taken = Math.min(one_remaining, boxes[1]);
                boxes[1] -= taken;
            }
            while (boxes[3] > 0) {
                result++;
                int three_reamining = 4;
                int two_remaining = 9;
                int one_remaining = 36;
                int taken = Math.min(three_reamining, boxes[3]);
                boxes[3] -= taken;
                switch (taken) {
                    case 1:
                        two_remaining = 5;
                        one_remaining -= 9;
                        break;
                    case 2:
                        two_remaining = 3;
                        one_remaining -= 18;
                        break;
                    case 3:
                        two_remaining = 1;
                        one_remaining -= 27;
                        break;
                    case 4:
                        two_remaining = 0;
                        one_remaining = 0;
                        break;
                }
                taken = Math.min(two_remaining, boxes[2]);
                boxes[2] -= taken;
                one_remaining -= taken * 4;
                taken = Math.min(one_remaining, boxes[1]);
                boxes[1] -= taken;
            }
            while (boxes[2] > 0) {
                result++;
                int two_remaining = 9;
                int one_remaining = 36;
                int taken = Math.min(two_remaining, boxes[2]);
                boxes[2] -= taken;
                one_remaining -= taken * 4;
                taken = Math.min(one_remaining, boxes[1]);
                boxes[1] -= taken;
            }
            while (boxes[1] > 0) {
                result++;
                int one_remaining = 36;
                int taken = Math.min(one_remaining, boxes[1]);
                boxes[1] -= taken;
            }
            out.println(result);
        }
        f.close();
        out.close();
    }
}
