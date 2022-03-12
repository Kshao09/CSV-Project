/**
 * Student class takes in name, id and phone and implements the CSVPrintable interface
 */

import java.io.PrintWriter;

public class Student implements CSVPrintable {
    String name;
    int id;
    Long phone;

    public Student(String name, int id, Long phone) {
        this.name = name;
        this.id = id;
        this.phone = phone;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getID() {
        return id;
    }

    public Long getPhoneNum() {
        return phone;
    }

    @Override
    public void csvPrintln(PrintWriter out) {
        out.println(getName() + "," + getID() + "," + phone);
        out.flush();
    }
}
