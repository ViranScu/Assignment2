import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This class reads unit name and students' info including last name,
 * first name, student id, assignment1 marks, assignment2 marks, assignment 3 marks 
 * and calculates the total marks of each student. Then prints the results.
 *
 * @author (Viran Pravinda)
 * @version (09-04-2022)
 */
public class Students
{
    // instance variables
    private String line;
    private String unitName;
    private String[] tokens;
    private ArrayList<String> studentsFirstNames;
    private ArrayList<String> studentsLastNames;
    private ArrayList<Integer> studentsIds;
    private ArrayList<Double> assignment1Marks;
    private ArrayList<Double> assignment2Marks;
    private ArrayList<Double> assignment3Marks;
    private ArrayList<Double> totalMarks; //total = assignment1Marks+assignment2Marks+assignment3Marks

    /**
     * Constructor for objects of class Students
     */
    public Students()
    {
        // initialise instance variables
        studentsFirstNames = new ArrayList<String>();
        studentsLastNames = new ArrayList<String>();
        studentsIds = new ArrayList<Integer>();
        assignment1Marks = new ArrayList<Double>();
        assignment2Marks = new ArrayList<Double>();
        assignment3Marks = new ArrayList<Double>();
        totalMarks = new ArrayList<Double>();
    }
    
    /**
     * Method readStudentsFile
     * This method reads data from the input file
     * @param
     * @return
     */
    public void readStudentsFile() {
        int lineCount = 0;
        try {
            File studentsFile = new File("prog5001_students_grade_2022.csv");
            Scanner myScanner = new Scanner(studentsFile);
            
            while(myScanner.hasNextLine()) {
                lineCount++;
                line = myScanner.nextLine();
                
                if(lineCount != 2) {
                    if(lineCount == 1) {
                        unitName = getUnitName(line);
                    } else {
                        tokens = line.split(",");
                        getFirstNames();
                        getLastNames();
                        getStudentsIds();
                        getStudentsAssignment1Marks();
                        getStudentsAssignment2Marks();
                        getStudentsAssignment3Marks();
                    }
                }
            }
        } catch(FileNotFoundException ex) {
            System.out.println("This file cannot be found");
            ex.printStackTrace();
        }
    }
    
    /**
     * Method getUnitName
     * This method returns the unit name
     * @param lineInfo information read from the file
     * @return unit name
     */
    public String getUnitName(String lineInfo) {
        tokens = lineInfo.split(":");
        return tokens[1].trim();
    }
    
    /**
     * Method getFirstNames
     * this method adds all the students' first names read from
     * file to studentsFirstNames ArrayList
     * @param
     * @return
     */
    public void getFirstNames() {
        studentsFirstNames.add(tokens[1]);
    }
    
    /**
     * Method getLastNames
     * this method adds all the students' last names read from
     * file to studentsLastNames ArrayList
     * @param
     * @return
     */
    public void getLastNames() {
        studentsLastNames.add(tokens[0]);
    }
    
    /**
     * Method getStudentsIds
     * this method adds all the students' ids read from file
     * to studentsIds ArrayList
     * @param
     * @return
     */
    public void getStudentsIds() {
        studentsIds.add(Integer.parseInt(tokens[2]));
    }
    
    /**
     * Method getStudentsAssignment1Marks
     * this method adds all the students' assignment 1 marks read from
     * file to assignment1Marks ArrayList
     * @param
     * @return
     */
    public void getStudentsAssignment1Marks() {
        if(tokens[3].isEmpty()) {
            tokens[3] = "0";
        }
        assignment1Marks.add(Double.parseDouble(tokens[3]));
    }
    
    /**
     * Method getStudentsAssignment2Marks
     * this method adds all the students' assignment 2 marks read from
     * file to assignment2Marks ArrayList
     * @param
     * @return
     */
    public void getStudentsAssignment2Marks() {
        double assignment2Mark = 0;
        
        try {
            assignment2Marks.add(Double.parseDouble(tokens[4]));       
        } catch(ArrayIndexOutOfBoundsException ex) {
            assignment2Marks.add(assignment2Mark);
            ex.printStackTrace();
        }      
    }
    
    /**
     * Method getStudentsAssignment3Marks
     * this method adds all the students' assignment 3 marks read from
     * file to assignment1Marks ArrayList
     * @param
     * @return
     */
    public void getStudentsAssignment3Marks() {
        double assignment3Mark = 0;
        
        try {
            assignment3Marks.add(Double.parseDouble(tokens[5]));
        } catch(ArrayIndexOutOfBoundsException ex) {
            assignment3Marks.add(assignment3Mark);
            ex.printStackTrace();
        }      
    }
    
    /**
     * Method calculateStudentsTotalMarks
     * this method calculates total of an individual student
     * and adds it to totalMarks ArrayList
     * @param
     * @return
     */
    public void calculateStudentsTotalMarks() {
        for(int j=0; j<studentsIds.size(); j++) {
            double total = assignment1Marks.get(j) + assignment2Marks.get(j) + 
                            assignment3Marks.get(j);
            totalMarks.add(total);
        }
    }
    
    /**
     * Method printStudentDetails
     * This method prints all the students' information along with their
     * total assignment marks
     * @param
     * @return
     */
    public void printStudentDetails() {
        System.out.println("Unit name: "+unitName+"\n");
        
        for(int k=0; k<studentsIds.size(); k++) {
            System.out.println(studentsFirstNames.get(k)+" "+studentsLastNames.get(k)+" | "+
            studentsIds.get(k)+" | "+assignment1Marks.get(k)+" | "+assignment2Marks.get(k)+" | "+
            assignment3Marks.get(k)+" | total marks -> "+totalMarks.get(k));
        }
    }
    
    public static void main(String[] args) {
        Students obj = new Students();
        obj.readStudentsFile();
        obj.calculateStudentsTotalMarks();
        obj.printStudentDetails();
    }
}
