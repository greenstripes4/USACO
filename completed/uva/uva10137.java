import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true){
            int n = f.nextInt();
            if(n == 0){
                break;
            }
            double[] students = new double[n];
            for(int i = 0; i < n; i++){
                students[i] = f.nextDouble();
            }
            Arrays.sort(students);
            double total = 0;
            int i = 0;
            int j = n-1;
            while(i < j){
                total += (students[j]*100-students[i]*100)/100.0;
                i++;
                j--;
            }
            total /= 2;
            out.printf("$%.2f\n",((double)((int)(total*100)))/100);
        }
        f.close();
        out.close();
    }
}
