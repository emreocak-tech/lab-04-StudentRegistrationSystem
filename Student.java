import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1. Create the Student Class
class Student {
    private String studentID;
    private String name;

    // Constructor
    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    // Getters
    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    // Method to print student's information
    @Override
    public String toString() {
        return "ID: " + studentID + ", Name: " + name;
    }
}
