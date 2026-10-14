import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// 2. Create the Course Class
class Course {
    private String courseName;
    private int capacity;
    private List<Student> enrolledStudents; // List to store registered students

    // Constructor
    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>(); // Start with an empty list
    }

    // Getters
    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    // Method to display course information clearly
    public void displayCourseInfo() {
        System.out.println("--------------------------------------------------");
        System.out.println("Course Name: " + courseName);
        System.out.println("Capacity: " + capacity);
        System.out.println("Currently Enrolled: " + enrolledStudents.size());

        if (enrolledStudents.isEmpty()) {
            System.out.println("Enrolled Students: None");
        } else {
            System.out.println("Enrolled Students:");
            for (Student s : enrolledStudents) {
                System.out.println("  - " + s.toString());
            }
        }
        System.out.println("--------------------------------------------------");
    }
}
