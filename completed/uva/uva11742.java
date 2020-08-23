import java.io.*;
import java.util.*;

class Constraint {
    int a;
    int b;
    int c;
    Constraint(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Main {
    private static int n;
    private static int m;
    private static int numberOfSeatingArrangements;
    private static int[] seatPositions;
    private static Constraint[] socialConstraints;
    private static boolean violatesConstraints(int person, int index) {
        for(int i = 0; i < m; i++) {
            Constraint temp = socialConstraints[i];
            int previousPerson;
            if(temp.a == person) {
                previousPerson = temp.b;
            } else if(temp.b == person) {
                previousPerson = temp.a;
            } else {
                continue;
            }
            int previousSeatPosition = seatPositions[previousPerson];
            if(previousSeatPosition == -1) {
                continue;
            }
            if((temp.c < 0 && index-previousSeatPosition < -temp.c) || (temp.c > 0 && index-previousSeatPosition > temp.c)) {
                return true;
            }
        }
        return false;
    }
    private static void getSeatingArrangements(int index) {
        if(index == n) {
            numberOfSeatingArrangements++;
            return;
        }
        for(int i = 0; i < n; i++) {
            if(seatPositions[i] == -1 && !violatesConstraints(i,index)) {
                seatPositions[i] = index;
                getSeatingArrangements(index+1);
                seatPositions[i] = -1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            numberOfSeatingArrangements = 0;
            seatPositions = new int[n];
            socialConstraints = new Constraint[m];
            Arrays.fill(seatPositions,-1);
            for(int i = 0; i < m; i++) {
                StringTokenizer constraint = new StringTokenizer(f.readLine());
                int a = Integer.parseInt(constraint.nextToken());
                int b = Integer.parseInt(constraint.nextToken());
                int c = Integer.parseInt(constraint.nextToken());
                Constraint temp = new Constraint(a,b,c);
                socialConstraints[i] = temp;
            }
            getSeatingArrangements(0);
            out.println(numberOfSeatingArrangements);
        }
        f.close();
        out.close();
    }
}
