import java.io.*;
import java.util.*;

class FacultyMember implements Comparable<FacultyMember>{
    public String title;
    public String firstName;
    public String lastName;
    public String homeAddress;
    public String department;
    public String homePhone;
    public String workPhone;
    public String campusBox;
    public FacultyMember(String title, String firstName, String lastName, String homeAddress, String department, String homePhone, String workPhone, String campusBox){
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
        this.department = department;
        this.homePhone = homePhone;
        this.workPhone = workPhone;
        this.campusBox = campusBox;
    }
    @Override
    public int compareTo(FacultyMember o){
        return this.lastName.compareTo(o.lastName);
    }
}

public class Main{
    private static void printFacultyMember(FacultyMember facultyMember, PrintWriter out){
        out.println("----------------------------------------");
        out.println(facultyMember.title + " " + facultyMember.firstName + " " + facultyMember.lastName);
        out.println(facultyMember.homeAddress);
        out.println("Department: " + facultyMember.department);
        out.println("Home Phone: " + facultyMember.homePhone);
        out.println("Work Phone: " + facultyMember.workPhone);
        out.println("Campus Box: " + facultyMember.campusBox);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int departments = Integer.parseInt(f.readLine());
        ArrayList<FacultyMember> facultyMembers = new ArrayList<>();
        for(int i = 0; i < departments; i++){
            String department = f.readLine();
            while(true){
                String facultyMember = f.readLine();
                if(facultyMember == null || facultyMember.length() == 0){
                    break;
                }
                String[] information = facultyMember.split(",");
                facultyMembers.add(new FacultyMember(information[0],information[1],information[2],information[3],department,information[4],information[5],information[6]));
            }
        }
        Collections.sort(facultyMembers);
        for(FacultyMember i: facultyMembers){
            printFacultyMember(i,out);
        }
        f.close();
        out.close();
    }
}
