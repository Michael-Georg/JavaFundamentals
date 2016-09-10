package JavaSE02_5;

import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StudentTest {
    @Before
    public void generateStudents() {
        for (Disciplines dis : Disciplines.values()) {
            dis.map.clear();
        }
        Student.students.clear();
        Student.numberOfStudents = 0;
        for (int i = 1; i < 11; i++) {
            new Student("Student" + i);
            if ((i % 2) == 0) Disciplines.GEOM.map.put(i, 3.0 + i % 3);
            Disciplines.MATH.map.put(i, 3.0 + i / 10.0);
            Disciplines.PHYSICS.map.put(i, 2.0 + i / 7.0);
            if (i % 3 == 0) Disciplines.HISTORY.map.put(i, 2.0 + i % 4.0);
        }
    }

    @Test
    public void studsGroupsFounded() {

      assertThat(Student.findStudentsGroup(1), is("MATH PHYSICS "));
    }

    @Test
    public void printStuds() {
        Student.printStudentList();
        System.out.println(Student.students.size());
    }

    @Test
    public void shouldFindStudentRight() {
        assertThat(Student.findStudent(5), is("Student5"));
    }

    @Test
    public void allStudGrades() {
        System.out.println(Student.students.size());
        Student.allStudGrades(9);

    }
}