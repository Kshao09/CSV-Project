/**
 * The TA class extends the Student class and implements the CSVPrintable interface
 */

import java.io.PrintWriter;

public class TA extends Student {
    private int tID;

    public TA(String name, int sId, long phone, int tID) {
        super(name, sId, phone);
        this.tID = tID;
    }

    public String getName() {
        return name;
    }

    /**
     * Compares the student and teacher id from the student class and returns the bigger value
     */
    public int getId() {
        if(tID > super.getID()){
            System.out.println("Teacher ID returned");
            return tID;
        }
        else{
            System.out.println("Student ID returned");
            return super.getID();
        }
    }

    @Override
    public void csvPrintln(PrintWriter out) {
        out.println(getName() + "," + getId() + "," + phone);
        out.flush();
    }
}
