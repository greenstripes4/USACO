import java.io.*;
import java.util.StringTokenizer;
/*
O(n)
16
a
b
c
d
e
f
g
h
i
j
k
l
m
n
o
p
17
a
b
c
d
e
f
g
h
i
j
k
l
m
n
o
p
q
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int numPeople = Integer.parseInt(f.readLine());
        boolean[] success = new boolean[numPeople];
        String[] people = new String[numPeople];
        String[] words = {"Happy","birthday","to","you","Happy","birthday","to","you","Happy","birthday","to","Rujia","Happy","birthday","to","you"};
        for(int i = 0; i < numPeople; i++){
            people[i] = f.readLine();
            success[i] = false;
        }
        int wordsSang = 0;
        int ind = 0;
        while(true){
            System.out.println(people[ind%numPeople] + ": " + words[ind%16]);
            wordsSang++;
            success[ind%numPeople] = true;
            boolean success1 = true;
            for(boolean j: success){
                if(!j){
                    success1 = false;
                }
            }
            if(success1 && wordsSang >= 16 && ind%16 == 15){
                break;
            }
            ind++;
        }
    }
}
