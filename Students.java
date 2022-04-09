import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

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

    /**
     * Constructor for objects of class Students
     */
    public Students()
    {
        // initialise instance variables
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
                
                if(lineCount == 1) {
                    unitName = getUnitName(line);
                    System.out.println(unitName);
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
    
    public static void main(String[] args) {
        Students obj = new Students();
        obj.readStudentsFile();
    }
}
