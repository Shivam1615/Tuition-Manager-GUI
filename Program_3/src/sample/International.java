package sample;
/**
 * 
 * This class overrides toString, tuitionDue and includes testbed main class to
 * test all of the methods of an international student.
 * 
 * @author Shivam Patel
 * @author Kevin Shah
 */
public class International extends Student {
    private boolean exchange;

    /**
     * This constructor initializes the first name, last name, number of credits,
     * and exchange variable.
     * 
     * @param fname    is the first name.
     * @param lname    is the last name.
     * @param credit   is the number of credits the student is taking.
     * @param exchange is the status of whether international student is an exchange
     *                 student or not.
     */
    public International(String fname, String lname, int credit, boolean exchange) {
        super(fname, lname, credit);
        this.exchange = exchange;
    }

    /**
     * This toString() method overrides the toString() method of the Student class
     * to include tuition amount of an international student.
     */
    @Override
    public String toString() {
        return super.toString() + " tuition due: " + "$" + this.tuitionDue();
    }

    /**
     * This tuitionDue() is overriding the abstract method of the Student class to
     * compute how much tuition the international student has to pay.
     */
    @Override
    public int tuitionDue() {
        int tuition = 0;

        if (this.credit < 12) {
            if (this.exchange == true) {
                tuition = Student.UNIVERSITYFEE_FULLTIME + Student.INTERNATIONAL_STUDENT_FEE;
            } else if (this.exchange == false) {
                tuition = (Student.INTERNATIONAL_PERCOST * this.credit) + Student.UNIVERSITYFEE_PARTTIME
                        + Student.INTERNATIONAL_STUDENT_FEE;
            }
        } else if (this.credit >= 12) {
            if (this.credit >= 15) {
                if (this.exchange == true) {
                    tuition = Student.UNIVERSITYFEE_FULLTIME + Student.INTERNATIONAL_STUDENT_FEE;
                } else if (this.exchange == false) {
                    tuition = (Student.INTERNATIONAL_PERCOST * 15) + Student.UNIVERSITYFEE_FULLTIME
                            + Student.INTERNATIONAL_STUDENT_FEE;
                }
            } else {
                if (this.exchange == true) {
                    tuition = Student.UNIVERSITYFEE_FULLTIME + Student.INTERNATIONAL_STUDENT_FEE;
                } else if (this.exchange == false) {
                    tuition = (Student.INTERNATIONAL_PERCOST * this.credit) + Student.UNIVERSITYFEE_FULLTIME
                            + Student.INTERNATIONAL_STUDENT_FEE;
                }
            }
        }
        return tuition;

    }

    /**
     * This testbed main method tests all of the constructors and all of the methods
     * of the class.
     * 
     * @param args is the main argument of the testbed method.
     */
    public static void main(String[] args) {

        International student = new International("Mary", "Yang", 17, true);
        International student2 = new International("Dhanush", "Gandham", 9, false);
        International student3 = new International("Ken", "Liang", 12, false);
        International student4 = new International("Ken", "Liang", 13, true);

        System.out.println(student.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());
        System.out.println(student4.toString());

        System.out.println(student.tuitionDue());
        System.out.println(student2.tuitionDue());
        System.out.println(student3.tuitionDue());
        System.out.println(student4.tuitionDue());

    }

}
