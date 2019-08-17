import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
O(n)
7 2
administer 100000
spending 200000
manage 50000
responsibility 25000
expertise 100
skill 50
money 75000
the incumbent will administer the spending of kindergarden milk money
and exercise responsibility for making change he or she will share
responsibility for the task of managing the money with the assistant
whose skill and expertise shall ensure the successful spending exercise
.
this individual must have the skill to perform a heart transplant and
expertise in rocket science
.
*/

public class Main{
    public static void main(String[] args) throws Exception {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int words = Integer.parseInt(st.nextToken());
        int jobDescriptions = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> points = new HashMap<>();
        for(int i = 0; i < words; i++){
            StringTokenizer w = new StringTokenizer(f.readLine());
            String word = w.nextToken();
            int value = Integer.parseInt(w.nextToken());
            points.put(word,value);
        }
        for(int j = 0; j < jobDescriptions; j++){
            String line;
            int totalSalary = 0;
            while(!((line = f.readLine()).equals("."))){
                StringTokenizer l = new StringTokenizer(line);
                while(l.hasMoreTokens()){
                    String currentWord = l.nextToken();
                    if(points.containsKey(currentWord)){
                        totalSalary += points.get(currentWord);
                    }
                }
            }
            out.println(totalSalary);
        }
        f.close();
        out.close();
    }
}
