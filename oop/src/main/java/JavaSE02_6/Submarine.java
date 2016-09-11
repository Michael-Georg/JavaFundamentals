package JavaSE02_6;

import JavaSE02_7.MyAnno;

import java.time.LocalDate;

@MyAnno(name = "First Annotation")
public class Submarine {
    private LocalDate time;

    Submarine(){
        new SubmarineEngine().runSubmarine();
    }

    String getStartDate(){
        return time.toString();
    }


    class SubmarineEngine{
        public void runSubmarine(){
            Submarine.this.time = LocalDate.now();
        }

    }

}
