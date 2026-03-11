import java.io.*;
import java.util.*;


class Student {

    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return id + " " + name + " " + marks;
    }
}

class StudentManager {

    Scanner sc = new Scanner(System.in);

    
    public void writeStudent() {

        try {

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Student Marks: ");
            double marks = sc.nextDouble();

            Student s = new Student(id, name, marks);

            FileWriter fw = new FileWriter("students.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(s.toString());
            bw.newLine();

            bw.close();

            System.out.println("Student record saved successfully.");

        }

        catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter correct data type.");
            sc.nextLine();
        }

        catch (IOException e) {
            System.out.println("Error while writing to file.");
        }

    }


    
    public void readStudents() {

        File file = new File("students.txt");

        if (!file.exists()) {
            System.out.println("File does not exist. No records found.");
            return;
        }

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            System.out.println("\nStudent Records:");

            while ((line = br.readLine()) != null) {

                String data[] = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double marks = Double.parseDouble(data[2]);

                System.out.println("ID: " + id + "  Name: " + name + "  Marks: " + marks);
            }

            br.close();

        }

        catch (IOException e) {
            System.out.println("Error while reading file.");
        }

    }
}




public class Main {

    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n---- Student Record System ----");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    manager.writeStudent();
                    break;

                case 2:
                    manager.readStudents();
                    break;

                case 3:
                    System.out.println("Program terminated.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");

            }
        }
    }
}