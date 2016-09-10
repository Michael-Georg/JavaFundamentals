package JavaSE02_5;

import java.util.HashMap;
import java.util.Map;

public class Student {
    public static Map<Integer, Student> students = new HashMap<>();
    public static int numberOfStudents = 0;
    private int id;
    private String name;

    public Student(String name) {
        this.name = name;
        this.id = ++numberOfStudents;
        students.put(this.id, this);
    }

    public static String findStudent(int id) {
        if (students.containsKey(id))
            return students.get(id).name;
        else System.out.println("Student isn't found");
        return null;
    }

    public static void printStudentList() {
        System.out.println("*------------*");
        System.out.println("| Name  | ID |");
        System.out.println("*------------*");
        for (Map.Entry mp : students.entrySet()) {
            System.out.println(mp.getValue().toString());
        }
    }

    public static String findStudentsGroup(int id) {
        String s = "";
        Disciplines[] disc = Disciplines.values();
        for (Disciplines d : disc) {
            if (d.map.containsKey(id)) s+=d.toString() + " ";
        }
        return s;
    }

    public static void allStudGrades(int id) {
        double maxgrade = 0;
        if (findStudent(id) != null) {
            System.out.println(findStudent(id) + ": ");
            Disciplines[] disc = Disciplines.values();

            for (Disciplines d : disc) {
                if (d.map.containsKey(id)) {
                    System.out.printf("  " + d.toString() + " %.2f \n", d.map.get(id));
                    maxgrade = maxgrade < d.map.get(id) ? d.map.get(id) : maxgrade;
                }


            }
        }
        System.out.println("Best grade - " + maxgrade);
    }

    @Override
    public String toString() {
        return name + " " + id;
    }
}
