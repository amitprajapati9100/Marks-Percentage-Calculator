import java.util.Scanner;

public class MarkspercentageCalculator {

    public  static double percentCal(double marks [], int Max_marks){
        if (marks.length == 0 || Max_marks == 0) {
            System.out.println("❌ Invalid Input: Number of Subjects and Max Marks must be greater than 0.");
            return 0.0; // or you can throw an exception // Base Case
        }

        double sum = 0.0, percentage = 0.0;
        for(int i=0; i< marks.length;i++){
            sum = sum + marks[i];
        }
        percentage = (double)(sum /Max_marks);
        return percentage * 100;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double result = 0.0;
        try{
            System.out.print("Please Enter the No. of Subjects: ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid Input ❌ Please enter an integer value.");
                return;
            }
            int n = sc.nextInt();
            if (n<=0){
                System.out.println(" Subject can't be Zero or Negative ");
                return;
            }
            System.out.print("Please Enter the Sum of Max Marks of All Subject: ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid Input ❌ Please enter an integer value.");
                return;
            }
            int max_marks = sc.nextInt();
            if (max_marks <= 0){
                System.out.println(" Maximum marks can't be Zero or Negative ");
                return;
            }
            double marks[] = new double[n];
            for (int i=0;i<n;i++) {
                System.out.print("Please Enter the Marks of Subject : " + (i + 1) + " -> ");
                marks[i] = sc.nextDouble();
                if (marks[i]< 0) {
                    System.out.println("The Minimum Marks Obtains in any Subject can be Zero,It Can't be Negative \nPlease Recheck the Value and Enter Correct Value ");
                    return;
                }

            }
            result = percentCal(marks,max_marks);
            String result_formatted = String.format("%.2f", result);
            String result_CGPA = String.format("%.2f", (result/10));
            if (result<0) System.out.println("Result can't be Negative, Please Recheck the Value and Enter Correct Value ");
            else if (result <= 100)System.out.println("The Total Percentage is : " + result_formatted + "% \n" + " and CGPA = " + result_CGPA + " \n Thank You...");
            else {
                System.out.println("❌ Percentage is More tha 100% Found ❌.....\n" +  "it is not Possible ❌ that Percentage is More than 100, Please Check the Marks Again carefully and Re Enter...\n" + "Thank You..." );
            }

        } catch (Exception e) {
            System.out.println("Invalid Input X");
            System.out.println("Please Enter a Integer Value(e.g : 1,2,3,4............upto 2^31 -1)");
        }
        finally {
            sc.close();
        }

    }
}
