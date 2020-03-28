/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */


import java.io.*;
import java.util.*;

class PrintJob{
    int jobPriority;
    int jobId;
    public PrintJob(int priority, int id){
        jobPriority = priority;
        jobId = id;
    }
}
public class Main{
    public static int getMaxPriority(Queue<PrintJob> queue){
        int maxPriority = 0;
        for(PrintJob i: queue){
            if(i.jobPriority > maxPriority){
                maxPriority = i.jobPriority;
            }
        }
        return maxPriority;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int T = Integer.parseInt(f.readLine());
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<PrintJob> queue = new LinkedList<>();
            StringTokenizer jobs = new StringTokenizer(f.readLine());
            for(int j = 0; j < n; j++){
                queue.add(new PrintJob(Integer.parseInt(jobs.nextToken()),j));
            }
            int maxPriority = getMaxPriority(queue);
            int time = 0;
            while(true){
                PrintJob nextJob = queue.poll();
                if(nextJob.jobPriority == maxPriority){
                    time++;
                    if(nextJob.jobId == m){
                        out.println(time);
                        break;
                    }
                    maxPriority = getMaxPriority(queue);
                } else {
                    queue.add(nextJob);
                }
            }
        }
        f.close();
        out.close();
    }
}
