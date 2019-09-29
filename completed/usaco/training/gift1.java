import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
ID: strongh2
LANG: JAVA
PROG: gift1
TASK: gift1
 */
public class gift1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        HashMap<String,Integer> money_list = new HashMap<>();
        int number_of_people = Integer.parseInt(f.readLine());
        String[] people = new String[number_of_people];
        for(int i = 0; i < number_of_people; i++){
            String giver = f.readLine();
            money_list.put(giver, 0);
            people[i] = giver;
        }
        for(int i = 0; i < number_of_people; i++){
            String name = f.readLine();
            StringTokenizer reader = new StringTokenizer(f.readLine());
            int transaction = Integer.parseInt(reader.nextToken());
            money_list.replace(name,money_list.get(name)-transaction);
            int shared_people = Integer.parseInt(reader.nextToken());
            for(int j = 0; j < shared_people; j++){
                String person = f.readLine();
                money_list.replace(person, money_list.get(person) + (transaction/shared_people));
            }
            if(shared_people != 0) {
                money_list.replace(name, money_list.get(name) + (transaction % shared_people));
            }
        }
        for(String k: people){
            out.println(k + " " + money_list.get(k));
        }
        f.close();
        out.close();
    }
}
