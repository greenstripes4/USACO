import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
O(n^2)
2
3 101 102 103
3 201 202 203
ENQUEUE 101
ENQUEUE 201
ENQUEUE 102
ENQUEUE 202
ENQUEUE 103
ENQUEUE 203
DEQUEUE
DEQUEUE
DEQUEUE
DEQUEUE
DEQUEUE
DEQUEUE
STOP
2
5 259001 259002 259003 259004 259005
6 260001 260002 260003 260004 260005 260006
ENQUEUE 259001
ENQUEUE 260001
ENQUEUE 259002
ENQUEUE 259003
ENQUEUE 259004
ENQUEUE 259005
DEQUEUE
DEQUEUE
ENQUEUE 260002
ENQUEUE 260003
DEQUEUE
DEQUEUE
DEQUEUE
DEQUEUE
STOP
0
*/
public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1")));
        String input;
        int count = 1;
        while(!((input = f.readLine()).equals("0"))){
            int numTeams = Integer.parseInt(input);
            HashMap<Integer,Integer> teamNumbers = new HashMap<>();
            HashMap<Integer,LinkedList<Integer>> teamPositions = new HashMap<>();
            LinkedList<LinkedList<Integer>> queue = new LinkedList<>();
            for(int i = 0; i < numTeams; i++){
                StringTokenizer team = new StringTokenizer(f.readLine());
                int teamMembers = Integer.parseInt(team.nextToken());
                for(int j = 0; j < teamMembers; j++){
                    teamNumbers.put(Integer.parseInt(team.nextToken()),i);
                }
            }
            out.println("Scenario #" + count);
            String command;
            while(!((command = f.readLine()).equals("STOP"))){
                StringTokenizer parts = new StringTokenizer(command);
                if(parts.nextToken().equals("ENQUEUE")){
                    int element = Integer.parseInt(parts.nextToken());
                    if(teamNumbers.containsKey(element)) {
                        if (!teamPositions.containsKey(teamNumbers.get(element))) {
                            LinkedList<Integer> temp = new LinkedList<>();
                            temp.add(element);
                            queue.add(temp);
                            teamPositions.put(teamNumbers.get(element), temp);
                        } else {
                            teamPositions.get(teamNumbers.get(element)).add(element);
                        }
                    } else {
                        LinkedList<Integer> temp = new LinkedList<>();
                        temp.add(element);
                        queue.add(temp);
                    }
                } else {
                    out.println(queue.peek().poll());
                    if(queue.peek().isEmpty()){
                        queue.poll();
                    }
                    teamPositions.entrySet().removeIf(entry -> entry.getValue().isEmpty());
                }
            }
            out.println();
            count++;
        }
        out.close();
        f.close();
    }
}
