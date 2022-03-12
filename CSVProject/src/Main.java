/**
 * Kenny Shao
 * Professor Kianoosh Boroojeni
 * Programming II assignment 3
 * This program uses interfaces and several classes to output the user input into a CSV file.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class Main {
    public static Scanner sc = new Scanner(System.in);

    /**
     * creates a file and print writer object to create a new csv file and take in user input
     */
    public static void main(String[] args) throws FileNotFoundException {
            File file = new File("out.csv");
            PrintWriter pw = new PrintWriter(file);

            boolean flag = false;
            String [] sInfo;
            int number =0, lines=0;
            String info, line;
            while(flag == false) {
                line = sc.nextLine();
                if(line.matches("[0-9]")){
                    lines = Integer.parseInt(line);
                    flag = true;
                }
                else{
                    System.out.println("Invalid Input. Try Again");
                }
            }

            while(number != lines){
                System.out.println("Please enter your information");
                System.out.println("Position, Name, StudentID, TeacherID, Phone");
                info = sc.nextLine();

                sInfo = info.split(" ");
                if(sInfo.length == 5){
                    number++;
                    if(sInfo[0].equalsIgnoreCase("teacher") && sInfo[2].equalsIgnoreCase("0")){
                        String fName = validName(sInfo[1]);
                        int correctID = validID(sInfo[3]);
                        int teachNum = validteachNum(sInfo[4]);
                        Teacher teacher = new Teacher(fName, correctID, teachNum);
                        teacher.csvPrintln(pw);
                    }
                    else if(sInfo[0].equalsIgnoreCase("student")&& sInfo[3].equalsIgnoreCase("0")){
                        String fName = validName(sInfo[1]);
                        int correctID = validID(sInfo[2]);
                        long vNum = validPhoneNumber(sInfo[4]);
                        Student student = new Student(fName, correctID, vNum);
                        student.csvPrintln(pw);
                    }
                    else if(sInfo[0].equalsIgnoreCase("TA") && Integer.parseInt(sInfo[3]) > 0 && Integer.parseInt(sInfo[2]) > 0){
                        String fName = validName(sInfo[1]);
                        int correctID = validID(sInfo[2]);
                        int cID = validID(sInfo[3]);
                        long vNum = validPhoneNumber(sInfo[4]);
                        TA tA = new TA(fName, correctID, cID, (int) vNum);
                        tA.csvPrintln(pw);
                    }
                    else{
                        System.out.println("Invalid Information! Try Again!");
                        number--;
                        continue;
                    }
                }

                else{
                    System.out.println("Wrong Amount of Data");
                    continue;
                }
            }
            pw.close();
        }

    /**
     * checks if name is valid and if the name isn't, then continue asking until it is correct
     */
    public static String validName(String name){
            String fName = "";
            String[] fullNames;
            boolean flag = false;
            while(flag == false) {
                fullNames = name.split(",");
                if(fullNames.length == 2 && fullNames[0].matches("[a-zA-Z]*")&& fullNames[1].matches("[a-zA-Z]*")) {
                    fName = fullNames[0] + " " +fullNames[1];
                    flag = true;
                }else{
                    System.out.println("Invalid Name. Try Again");
                    name = sc.nextLine();
                }
            }
            return fName;
        }

    /**
     * It checks whether ID is correct or not. If not, ask again.
     */
    public static int validID(String ID){
            int correctID = 0;
            boolean flag = false;
            while(flag == false){
                if(ID.length() == 5 && ID.matches("[0-9]*") && Integer.parseInt(ID)>0){
                    correctID = Integer.parseInt(ID);
                    flag = true;
                }else{
                    System.out.println("Invalid ID. Try Again");
                    ID = sc.nextLine();
                    continue;
                }
            }

            return correctID;
        }

    /**
     * Uses a while loop to check for phone number is correct or not.
     */
    public static long validPhoneNumber(String phoneNumber){
            long vNum = 0;
            boolean flag = false;
            while(flag == false){
                if(phoneNumber.length() == 10 && phoneNumber.matches("[0-9]*")){
                    vNum = Long.parseLong(phoneNumber);
                    flag = true;
                }
                else{
                    System.out.println("Invalid Number. Try Again");
                    phoneNumber = sc.nextLine();
                }
            }

            return vNum;
        }

    /**
     * uses while loop to check if teacher number is correct or not
     */
    public static int validteachNum(String teacherNumber){
            int teachNum = 0;
            boolean flag = false;
            while(flag == false){
                if(teacherNumber.length() == 10 && teacherNumber.matches("[0-9]*")){
                    String lastFour = teacherNumber.substring(6, 10);
                    teachNum = Integer.parseInt(lastFour);
                    flag = true;
                }
                else{
                    System.out.println("Invalid Number. Try Again");
                    teacherNumber = sc.nextLine();
                }
            }
            return teachNum;
        }
}
