import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();

    // Add a student
    public void addStudent(Student student) {
        students.add(student);
    }

    // View all students
    public void viewStudents() {
        students.forEach(System.out::println);
    }

    // Update student details
    public void updateStudent(int rollNumber, String newName, String newGrade) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                student.setName(newName);
                student.setGrade(newGrade);
                break;
            }
        }
    }

    // Delete a student by roll number
    public void deleteStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    // Search student by name
    public Student searchStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null; // Not found
    }

    public static void main(String[] args) {
        // Example usage
        StudentManagementSystem system = new StudentManagementSystem();

        // Adding students
        system.addStudent(new Student(101, "Alice", "A"));
        system.addStudent(new Student(102, "Bob", "B"));
        system.addStudent(new Student(103, "Carol", "C"));

        // Viewing all students
        system.viewStudents();

        // Updating student details
        system.updateStudent(102, "Bob Smith", "B+");
        system.viewStudents();

        // Deleting a student
        system.deleteStudent(101);
        system.viewStudents();

        // Searching for a student by name
        Student searchedStudent = system.searchStudentByName("Carol");
        if (searchedStudent != null) {
            System.out.println("Found student: " + searchedStudent);
        } else {
            System.out.println("Student not found.");
        }
    }
}

