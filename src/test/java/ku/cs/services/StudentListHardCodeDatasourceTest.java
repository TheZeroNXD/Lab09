package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    @Test
    void testReadData() {
        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
        StudentList list = datasource.readData();

        String actualId = list.getStudents().get(0).getId();
        String expectedId = "6410400001";
        assertEquals(expectedId, actualId);
        String actualName = list.getStudents().get(0).getName();
        String expectedName = "First";
        assertEquals(expectedName, actualName);
    }
}
