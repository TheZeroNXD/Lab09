package ku.cs;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import ku.cs.services.Datasource;
import ku.cs.services.StudentListFileDatasource;

public class MainTestConsole {
    public static void main(String[] args) {
        Datasource<StudentList> datasource = new StudentListFileDatasource("data", "student-list.csv");
        StudentList students = datasource.readData();
        Student student1 = students.findStudentById("6410450001");

        if (student1 != null) {
            Student student2 = students.findStudentByObject(student1);
            System.out.println(student1.getName());
            System.out.println(student2.getName());
            System.out.print(student1 == student2);
        } else {
            System.out.println("Student not found.");
        }
    }
}
