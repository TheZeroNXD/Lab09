package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentListFileDatasourceTest {
    private StudentListFileDatasource datasource;
    private String directoryName;
    private String fileName;

    @BeforeEach
    void setUp() {
        directoryName = "test_directory"; // ระบุไดเรกทอรีที่ใช้ในการทดสอบ
        fileName = "test_students.csv"; // ระบุชื่อไฟล์ที่ใช้ในการทดสอบ
        datasource = new StudentListFileDatasource(directoryName, fileName);
    }

    @Test
    @DisplayName("Test reading data from file")
    void testReadData() {
        // สร้างไฟล์ csv ทดสอบ
        createTestCsvFile();

        StudentList studentList = datasource.readData();

        assertNotNull(studentList);
        List<Student> students = studentList.getStudents();
        assertEquals(2, students.size());

        for (Student student : students) {
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Score: " + student.getScore());
        }
    }

    @Test
    @DisplayName("Test writing data to file")
    void testWriteData() {
        // สร้างข้อมูลสำหรับเขียนลงในไฟล์
        StudentList studentList = new StudentList();
        studentList.addNewStudent("3", "Alice Johnson", 75.5);
        studentList.addNewStudent("4", "Bob Brown", 92.0);

        // เขียนข้อมูลลงในไฟล์
        datasource.writeData(studentList);

        // อ่านข้อมูลจากไฟล์
        StudentList readStudentList = datasource.readData();

        assertNotNull(readStudentList);
        List<Student> students = readStudentList.getStudents();
        assertEquals(2, students.size());

        Student student1 = students.get(0);
        assertEquals("3", student1.getId());
        assertEquals("Alice Johnson", student1.getName());
        assertEquals(75.5, student1.getScore(), 0.001);

        Student student2 = students.get(1);
        assertEquals("4", student2.getId());
        assertEquals("Bob Brown", student2.getName());
        assertEquals(92.0, student2.getScore(), 0.001);
    }

    // เมธอดสร้างไฟล์ csv ทดสอบ
    private void createTestCsvFile() {
        File file = new File(directoryName + File.separator + fileName);
        if (!file.exists()) {
            // สร้างไฟล์และเขียนข้อมูล
            try {
                file.createNewFile();
                datasource.writeData(createTestStudentList());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // เมธอดสร้างข้อมูลสำหรับทดสอบ
    private StudentList createTestStudentList() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("1", "John Doe", 95.5);
        studentList.addNewStudent("2", "Jane Smith", 88.0);
        return studentList;
    }
}
