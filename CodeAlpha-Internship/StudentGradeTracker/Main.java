import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter Number Of Students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Grade: ");
            int grade = sc.nextInt();
            sc.nextLine();

            students.add(new Student(name, grade));
        }

        int total = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        System.out.println("\n=== STUDENT REPORT ===");

        for (Student s : students) {

            System.out.println(
                    "Name: " + s.getName() +
                    " | Grade: " + s.getGrade());

            total += s.getGrade();

            if (s.getGrade() > highest) {
                highest = s.getGrade();
            }

            if (s.getGrade() < lowest) {
                lowest = s.getGrade();
            }
        }

        double average = (double) total / students.size();

        System.out.println("\nAverage Score: " + average);
        System.out.println("\nHighest Score: " + highest);
        System.out.println("\nLowest Score: " + lowest);

        sc.close();
    }
}