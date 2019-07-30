import java.io.*;
import java.util.StringTokenizer;
/*
O(n)
6 4
engine
brakes
tires
ashtray
vinyl roof
trip computer
Chevrolet
20000.00 3
engine
tires
brakes
Cadillac
70000.00 4
ashtray
vinyl roof
trip computer
engine
Hyundai
10000.00 3
engine
tires
ashtray
Lada
6000.00 1
tires
1 1
coffee
Starbucks
1.50 1
coffee
1 1
a
x
1.0 1
a
0 0
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        int case_number = 1;
        while(!((input = f.readLine()).equals("0 0"))){
            if(case_number != 1){
                System.out.println();
            }
            StringTokenizer st = new StringTokenizer(input);
            int requirements = Integer.parseInt(st.nextToken());
            int proposals = Integer.parseInt(st.nextToken());
            for(int i = 0; i < requirements; i++){
                f.readLine();
            }
            String object = f.readLine();
            StringTokenizer stats = new StringTokenizer(f.readLine());
            double min = Double.parseDouble(stats.nextToken());
            int reqs_met = Integer.parseInt(stats.nextToken());
            for(int j = 0; j < reqs_met; j++){
                f.readLine();
            }
            for(int k = 0; k < proposals-1; k++){
                String cur_object = f.readLine();
                StringTokenizer cur_stats = new StringTokenizer(f.readLine());
                double price = Double.parseDouble(cur_stats.nextToken());
                int reqs = Integer.parseInt(cur_stats.nextToken());
                for(int j = 0; j < reqs; j++){
                    f.readLine();
                }
                if((reqs > reqs_met) || (reqs == reqs_met && price < min)){
                    object = cur_object;
                    reqs_met = reqs;
                    min = price;
                }
            }
            System.out.println("RFP #" + case_number);
            System.out.println(object);
            case_number++;
        }
    }
}
