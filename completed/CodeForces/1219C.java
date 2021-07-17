import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int L = Integer.parseInt(f.readLine());
        char[] A = f.readLine().toCharArray();
        int repeats = (A.length+L-1)/L;
        char[] B = new char[L*repeats];
        if(B.length > A.length) {
            for(int i = 0; i < B.length; i++) {
                B[i] = i%L == 0 ? '1' : '0';
            }
        } else {
            for(int i = 0; i < L; i++) {
                for(int j = i; j < B.length; j += L) {
                    B[j] = A[i];
                }
            }
            int i;
            for(i = 0; i < A.length; i++) {
                if(A[i] != B[i]) {
                    break;
                }
            }
            if(i == A.length || A[i] > B[i]) {
                int j;
                for(j = L-1; j >= 0; j--) {
                    if(B[j] < '9') {
                        break;
                    }
                }
                if(j < 0) {
                    B = new char[L*(repeats+1)];
                    for(int k = 0; k < B.length; k++) {
                        B[k] = k%L == 0 ? '1' : '0';
                    }
                } else {
                    for(int k = j; k < B.length; k += L) {
                        B[k]++;
                    }
                    for(int k = j+1; k < L; k++) {
                        for(int l = k; l < B.length; l += L) {
                            B[l] = '0';
                        }
                    }
                }
            }
        }
        out.println(B);
        f.close();
        out.close();
    }
}