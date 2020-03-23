import java.util.Scanner;

/**
 * Manages the driver used to run I/O commands through the command line.
 * Maintains a list of students and adds/removes students according to the
 * inputs.
 * 
 * @author Kevin Shah
 * @author Shivam Patel
 */
public class TuitionManager {
    static Scanner stdin;
    static StudentList students;

    /**
     * Calls StudentList's remove for a given student from the list of students.
     * 
     * @param fname First name of the student
     * @param lname Last name of the student
     */
    private static void remove(String fname, String lname) {
        Student removedStudent = new Instate(fname, lname, 0, 0);
        if (!students.remove(removedStudent)) {
            System.out.println(fname + " " + lname + " is not a student.");
        } else {
            System.out.println(fname + " " + lname + " has been removed.");
        }
    }

    /**
     * Appends an International student to the end of the student list.
     * 
     * @param fname  First name of the student
     * @param lname  Last name of the student
     * @param credit Number of credits
     * @param status true if the student is an exchange student, false otherwise
     */
    private static void addInternational(String fname, String lname, int credit, boolean status) {
        if (credit >= 9) {
            International newStudent = new International(fname, lname, credit, status);

            if (students.contains(newStudent)) {
                System.out.println(fname + " " + lname + " is already a student.");
            } else {
                students.add(newStudent);
                System.out.println(fname + " " + lname + " has been added to the list.");
            }
        } else {
            System.out.println("Invalid credits amount.");
        }
    }

    /**
     * Appends an Out-of-State student to the end of the student list.
     * 
     * @param fname  First name of the student
     * @param lname  Last name of the student
     * @param credit Number of credits
     * @param status true if the student is from a tri-state area, false otherwise
     */
    private static void addOutState(String fname, String lname, int credit, boolean status) {
        if (credit > 0) {
            Outstate newStudent = new Outstate(fname, lname, credit, status);

            if (students.contains(newStudent)) {
                System.out.println(fname + " " + lname + " is already a student.");
            } else {
                students.add(newStudent);
                System.out.println(fname + " " + lname + " has been added to the list.");
            }
        } else {
            System.out.println("Invalid credits amount.");
        }
    }

    /**
     * Appends an In-State student to the end of the student list.
     * 
     * @param fname  First name of the student
     * @param lname  Last name of the student
     * @param credit Number of credits
     * @param funds  the amount of funding given to the student
     */
    private static void addInState(String fname, String lname, int credit, int funds) {
        if (credit > 0) {
            Instate newStudent = new Instate(fname, lname, credit, funds);

            if (students.contains(newStudent)) {
                System.out.println(fname + " " + lname + " is already a student.");
            } else {
                students.add(newStudent);
                System.out.println(fname + " " + lname + " has been added to the list.");
            }
        } else {
            System.out.println("Invalid credits amount.");
        }
    }

    /**
     * Prints all the students in the list. Prints an error statement in case of no
     * students.
     */
    private static void print() {
        if (students.isEmpty()) {
            System.out.println("There are no students in the list!");
        } else {
            students.print();
        }
    }

    /**
     * Prints an error statement specifying that a specific command is not
     * supported.
     * 
     * @param command the command that states the error
     */
    private static void printError(String command) {
        System.out.println("Command '" + command + "' not supported!");
    }

    /**
     * Main driver that performs the I/O with the terminal.
     * 
     * @param args flags/arguments
     */
    public static void main(String[] args) {
        stdin = new Scanner(System.in);
        students = new StudentList();

        boolean done = false;

        while (!done) {
            String command = stdin.nextLine();
            String[] splitCommand = command.split(" "); // Split the command given into parts
            String fname, lname;
            int credit, funds;
            boolean status;

            switch (command.charAt(0)) {
                case 'I': // In-State Student
                    if (splitCommand.length != 5 || splitCommand[0].length() != 1) {
                        printError(splitCommand[0]);
                        break;
                    }
                    fname = splitCommand[1];
                    lname = splitCommand[2];
                    credit = Integer.parseInt(splitCommand[3]);
                    funds = Integer.parseInt(splitCommand[4]);
                    addInState(fname, lname, credit, funds);
                    break;
                case 'O': // Out-of-State Student
                    if (splitCommand.length != 5 || splitCommand[0].length() != 1) {
                        printError(splitCommand[0]);
                        break;
                    }
                    fname = splitCommand[1];
                    lname = splitCommand[2];
                    credit = Integer.parseInt(splitCommand[3]);
                    status = splitCommand[4].equals("T") ? true : false;
                    addOutState(fname, lname, credit, status);
                    break;
                case 'N': // International Student
                    if (splitCommand.length != 5 || splitCommand[0].length() != 1) {
                        printError(splitCommand[0]);
                        break;
                    }
                    fname = splitCommand[1];
                    lname = splitCommand[2];
                    credit = Integer.parseInt(splitCommand[3]);
                    status = splitCommand[4].equals("T") ? true : false;
                    addInternational(fname, lname, credit, status);
                    break;
                case 'R': // Remove
                    if (splitCommand.length != 3 || splitCommand[0].length() != 1) {
                        printError(splitCommand[0]);
                        break;
                    }
                    fname = splitCommand[1];
                    lname = splitCommand[2];
                    remove(fname, lname);
                    break;
                case 'P': // Print
                    if (splitCommand.length != 1 || splitCommand[0].length() != 1) {
                        printError(splitCommand[0]);
                        break;
                    }
                    print();
                    break;
                case 'Q': // Quit
                    if (splitCommand.length != 1 || splitCommand[0].length() != 1) {
                        printError(splitCommand[0]);
                        break;
                    }
                    System.out.println("Program terminated");
                    done = true;
                    break;
                default:
                    printError(splitCommand[0]);
                    break;
            }
        }
    }

}
