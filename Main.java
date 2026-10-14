import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    private static List<Course> courses = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 3. Course Setup
        System.out.println("=== Welcome to the Course Registration System ===");
        int numCourses = 0;

        // Ask how many courses to create (at least 3)
        while (numCourses < 3) {
            System.out.print("How many courses do you want to create? (Minimum 3): ");
            try {
                numCourses = Integer.parseInt(scanner.nextLine());
                if (numCourses < 3) {
                    System.out.println("You must create at least 3 courses.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        // Create courses and store them in the list
        for (int i = 0; i < numCourses; i++) {
            System.out.println("\nSetting up Course " + (i + 1) + ":");
            System.out.print("Enter course name: ");
            String name = scanner.nextLine();

            int capacity = -1;
            while (capacity <= 0) {
                System.out.print("Enter classroom capacity: ");
                try {
                    capacity = Integer.parseInt(scanner.nextLine());
                    if (capacity <= 0) System.out.println("Capacity must be greater than 0.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }
            courses.add(new Course(name, capacity));
        }

        // Print the list of created courses
        System.out.println("\n--- Setup Complete! Available Courses ---");
        for (Course c : courses) {
            System.out.println("- " + c.getCourseName() + " (Capacity: " + c.getCapacity() + ")");
        }

        // Menu Loop
        while (true) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Register a Student");
            System.out.println("2. View All Courses");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerStudent();
                    break;
                case "2":
                    viewAllCourses();
                    break;
                case "3":
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // 4. Register Students (with Capacity and Duplicate Check)
    private static void registerStudent() {
        System.out.println("\n--- Student Registration ---");
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter the exact name of the course to register for: ");
        String courseName = scanner.nextLine();

        // Search for the course
        Course targetCourse = null;
        for (Course c : courses) {
            if (c.getCourseName().equalsIgnoreCase(courseName)) { // Using equalsIgnoreCase for better UX
                targetCourse = c;
                break;
            }
        }

        // If no course found
        if (targetCourse == null) {
            System.out.println("Error: No course found with that name.");
            return;
        }

        // Check capacity
        if (targetCourse.getEnrolledStudents().size() >= targetCourse.getCapacity()) {
            System.out.println("Error: This course is full. Registration failed.");
            return;
        }

        // Check for duplicate student ID in this course
        for (Student s : targetCourse.getEnrolledStudents()) {
            if (s.getStudentID().equals(studentID)) {
                System.out.println("Error: This student is already registered for this course.");
                return;
            }
        }

        // If all checks pass, register the student
        Student newStudent = new Student(studentID, studentName);
        targetCourse.getEnrolledStudents().add(newStudent);
        System.out.println("Registration successful for " + studentName + " in " + targetCourse.getCourseName() + ".");
    }

    // 5. View All Courses
    private static void viewAllCourses() {
        System.out.println("\n=== All Courses Information ===");
        if (courses.isEmpty()) {
            System.out.println("No courses have been created yet.");
            return;
        }

        for (Course c : courses) {
            c.displayCourseInfo();
        }
    }
}