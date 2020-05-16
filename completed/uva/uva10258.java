import java.io.*;
import java.util.*;

class Contestant implements Comparable<Contestant>{
    public int id;
    public HashSet<Integer> solved;
    public int penaltyTime;
    public HashMap<Integer,Integer> incorrectSubmissions;
    public Contestant(int id){
        this.id = id;
        this.solved = new HashSet<>();
        this.penaltyTime = 0;
        this.incorrectSubmissions = new HashMap<>();
    }
    public void addSubmission(int problem, int time, char verdict){
        if(verdict == 'C'){
            if(!solved.contains(problem)) {
                solved.add(problem);
                penaltyTime += time + incorrectSubmissions.getOrDefault(problem, 0) * 20;
            }
        } else if(verdict == 'I'){
            incorrectSubmissions.put(problem,incorrectSubmissions.getOrDefault(problem,0)+1);
        }
    }
    @Override
    public String toString() {
        return id + " " + solved.size() + " " + penaltyTime;
    }
    @Override
    public int compareTo(Contestant o){
        if(solved.size() == o.solved.size()){
            if(penaltyTime == o.penaltyTime){
                return id - o.id;
            }
            return penaltyTime - o.penaltyTime;
        }
        return o.solved.size() - solved.size();
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = Integer.parseInt(f.readLine());
        f.readLine();
        for(int i = 0; i < testCases; i++){
            if(i > 0){
                out.println();
            }
            ArrayList<Contestant> allContestants = new ArrayList<>();
            while(true){
                String submission = f.readLine();
                if(submission == null || submission.length() == 0){
                    break;
                }
                StringTokenizer st = new StringTokenizer(submission);
                int id = Integer.parseInt(st.nextToken());
                int problem = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                char verdict = st.nextToken().charAt(0);
                boolean found = false;
                for(Contestant j: allContestants){
                    if(j.id == id){
                        found = true;
                        j.addSubmission(problem,time,verdict);
                    }
                }
                if(!found){
                    Contestant temp = new Contestant(id);
                    temp.addSubmission(problem,time,verdict);
                    allContestants.add(temp);
                }
            }
            Collections.sort(allContestants);
            for(Contestant j: allContestants){
                out.println(j);
            }
        }
        f.close();
        out.close();
    }
}
