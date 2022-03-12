/**
 * Interface to implement polymorphism and save code usage
  */
import java.io.PrintWriter;

public interface CSVPrintable {
    String getName();
    int getID();
    void csvPrintln(PrintWriter out);
}
