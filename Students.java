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
                        System.out.println(unitName);
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
        assignment2Marks.add(Double.parseDouble(tokens[4]));
    }
    
    /**
     * Method getStudentsAssignment3Marks
     * this method adds all the students' assignment 3 marks read from
     * file to assignment1Marks ArrayList
     * @param
     * @return
     */
    public void getStudentsAssignment3Marks() {
        assignment3Marks.add(Double.parseDouble(tokens[5]));
    }
    
    public static void main(String[] args) {
        Students obj = new Students();
        obj.readStudentsFile();
    }
}
