import java.util.ArrayList;
import java.util.List;

class MedicalStaff {}
class Doctor extends MedicalStaff{}
class Nurse extends MedicalStaff{}
class HeadDoctor extends Doctor{}

@SuppressWarnings("unused")
class Test{
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor();
//        Doctor doctor2 = new MedicalStaff();
        Doctor doctor3 = new HeadDoctor();
        Object object1 = new HeadDoctor();
//        HeadDoctor doctor4 = new Object();
//        Doctor doctor6 = new Nurse();
//        Nurse nurse = new Doctor();
        Object object2 = new Nurse();
        List<Doctor> list1 = new ArrayList<>();
//        List<MedicalStaff> list2 = new ArrayList<Doctor>();
//        List<Doctor> list3 = new ArrayList<MedicalStaff>();
//        List<Object> list4 = new ArrayList<Doctor>();
        List<Object> list5 = new ArrayList<>();

    }
}
