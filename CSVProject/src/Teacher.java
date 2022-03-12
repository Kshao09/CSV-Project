/**
 * the Teacher class takes in name, id and phone number and implements the CSVPrintable interface
 */

import java.io.PrintWriter;

public class Teacher implements CSVPrintable {
    String name;
    int id;
    Integer phoneNum;

    public Teacher(String name, int id, Integer phoneNum) {
        this.name = name;
        this.id = id;
        this.phoneNum = phoneNum;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getID() {
        return id;
    }

    public Integer getPhoneNum() {
        return phoneNum;
    }

    @Override
    public void csvPrintln(PrintWriter out) {
        out.println(getName() + "," + getID() + "," + phoneNum);
        out.flush();
    }
}
