package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;

    @BeforeEach
    public void setUp() {
        student = new Student("123", "John", 75.0);
    }
    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อ")
    void testChangeName() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.changeName("NewName");
        assertEquals("NewName", s.getName());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อเมื่อให้ชื่อว่างเปล่า")
    void testChangeNameEmpty() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.changeName("");
        assertEquals("StudentTest", s.getName());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรดสำหรับคะแนน 85")
    void testCalculateGradeA() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรดสำหรับคะแนน 75")
    void testCalculateGradeB() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(75);
        assertEquals("B", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรดสำหรับคะแนน 65")
    void testCalculateGradeC() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(65);
        assertEquals("C", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรดสำหรับคะแนน 55")
    void testCalculateGradeD() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(55);
        assertEquals("D", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการคำนวณเกรดสำหรับคะแนน 45")
    void testCalculateGradeF() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(45);
        assertEquals("F", s.grade());
    }

    @Test
    @DisplayName("ทดสอบเมธอด isId ในกรณี ID ตรงกับ ID ของนักเรียน")
    void testIsIdMatch() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        assertTrue(s.isId("6xxxxxxxxx"));
    }

    @Test
    @DisplayName("ทดสอบเมธอด isId ในกรณี ID ไม่ตรงกับ ID ของนักเรียน")
    void testIsIdNotMatch() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        assertFalse(s.isId("7yyyyyyyyy"));
    }

    @Test
    @DisplayName("Test toString method")
    public void testToString() {
        assertEquals("Student{id='123', name='John', score=75.0, wallet=Wallet{balance=0.0}}", student.toString());
    }

}