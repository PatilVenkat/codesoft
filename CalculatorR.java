
/*Input: Take marks obtained (out of 100) in each subject.
Calculate Total Marks: Sum up the marks obtained in all subjects.
Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
average percentage.
Grade Calculation: Assign grades based on the average percentage achieved.
Display Results: Show the total marks, average percentage, and the corresponding grade to the user*/
import java.util.*;

public class CalculatorR {
    public static void main(String[] args) {
        int Total_marks = 0, Average_per = 0;
        for (int i = 1; i <= 6; i++) {
            Scanner sc = new Scanner(System.in);
            int marks = sc.nextInt();
            Total_marks = Total_marks + marks;
            Average_per = Total_marks / 6;

        }
        System.out.println(" Total marks " + Total_marks);
        System.out.println("Average Percentage " + Average_per);
        if (Average_per < 30) {
            System.out.println(" Grade is E");
        } else if (Average_per < 50) {
            System.out.println(" Grade is D");
        } else if (Average_per < 70) {
            System.out.println(" Grade is C");
        } else if (Average_per < 80) {
            System.out.println(" Grade is B");
        } else {
            System.out.println(" Grade is A");
        }
    }
}