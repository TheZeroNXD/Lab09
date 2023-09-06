package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentListTest {
    private StudentList studentList;

    @BeforeEach
    public void setUp() {
        studentList = new StudentList();
    }

    @Test
    @DisplayName("Test adding a new student without score")
    public void testAddNewStudent() {
        studentList.addNewStudent("1", "John");
        studentList.addNewStudent("2", "Alice");

        assertEquals(2, studentList.getStudents().size());
    }

    @Test
    @DisplayName("Test adding a new student with score")
    public void testAddNewStudentWithScore() {
        studentList.addNewStudent("1", "John", 85.0);

        assertEquals(1, studentList.getStudents().size());
        assertEquals(85.0, studentList.getStudents().get(0).getScore(), 0.01);
    }

    @Test
    @DisplayName("Test finding a student by ID")
    public void testFindStudentById() {
        studentList.addNewStudent("1", "John");
        studentList.addNewStudent("2", "Alice");

        assertEquals("John", studentList.findStudentById("1").getName());
        assertEquals("Alice", studentList.findStudentById("2").getName());
        assertNull(studentList.findStudentById("3"));
    }

    @Test
    @DisplayName("Test giving a score to a student by ID")
    public void testGiveScoreToId() {
        studentList.addNewStudent("1", "John");
        studentList.addNewStudent("2", "Alice");

        studentList.giveScoreToId("1", 95.0);
        studentList.giveScoreToId("2", 88.5);

        assertEquals(95.0, studentList.findStudentById("1").getScore(), 0.01);
        assertEquals(88.5, studentList.findStudentById("2").getScore(), 0.01);
    }

    @Test
    @DisplayName("Test viewing the grade of a student by ID")
    public void testViewGradeOfId() {
        studentList.addNewStudent("1", "John", 85.0);
        studentList.addNewStudent("2", "Alice", 92.5);

        assertEquals("A", studentList.viewGradeOfId("1"));
        assertEquals("A", studentList.viewGradeOfId("2"));
        assertNull(studentList.viewGradeOfId("3"));
    }


}
