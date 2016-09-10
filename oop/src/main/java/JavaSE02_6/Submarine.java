package JavaSE02_6;

import java.time.LocalDate;

public class Submarine {
    private LocalDate time;

    Submarine(){
        new SubmarineEngine().runSubmarine();
    }

    String getStartTime(){
        return time.toString();
    }


    class SubmarineEngine{
        public void runSubmarine(){
            Submarine.this.time = LocalDate.now();
        }

    }

}
