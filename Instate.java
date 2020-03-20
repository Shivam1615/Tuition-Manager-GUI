/**
 * 
 * This class overrides the toString() method in order to store information of
 * an instate student and overrides tuitionDue() method in order to compute how
 * much an instate student will have to pay.
 * 
 * @author Shivam Patel
 * @author Kevin Shah
 */
public class Instate extends Student {
    private int funds;

    /**
     * Constructor initializes the first name, last name, credits, and the amound of
     * funds for a student.
     * 
     * @param fname  is the first name of the student.
     * @param lname  is the last name of the student.
     * @param credit is the number of credits the student is taking.
     * @param funds  is the amount of funds a full-time student is eligible to
     *               recieve.
     */
    public Instate(String fname, String lname, int credit, int funds) {
        super(fname, lname, credit);
        this.funds = funds;
    }

    /**
     * This method overrides the Student toString method in order to include the
     * tuition due for the instate student.
     */
    @Override
    public String toString() {
        return super.toString() + " tuition due: " + "$" + this.tuitionDue();
    }

    /**
     * This method overrides the abstract method of the student class in order to
     * compute the amount of tuition for an instate student.
     */
    @Override
    public int tuitionDue() {
        int tuition = 0;

        // Part-time students
        if (this.credit < 12) {
            tuition = (Student.INSTATE_PERCOST * this.credit) + Student.UNIVERSITYFEE_PARTTIME;
        } else if (this.credit >= 12) { // Full-time students
            if (this.credit >= 15) {
                tuition = (Student.INSTATE_PERCOST * 15) + Student.UNIVERSITYFEE_FULLTIME - this.funds;
            } else {
                tuition = (Student.INSTATE_PERCOST * this.credit) + Student.UNIVERSITYFEE_FULLTIME - this.funds;
            }
        }

        return tuition;
    }

    /**
     * This main testbed method tests the constructor and the tuitionDue() and the
     * toString method.
     * 
     * @param args is the main argument of the testbed main class.
     */
    public static void main(String[] args) {

        Instate student = new Instate("John", "Smith", 17, 1000);
        Instate student1 = new Instate("Shivam", "Patel", 15, 0);
        Instate student2 = new Instate("Kevin", "Shah", 9, 2000);

        System.out.println(student.toString());
        System.out.println(student1.toString());
        System.out.println(student2.toString());

        System.out.println(student.tuitionDue());
        System.out.println(student1.tuitionDue());
        System.out.println(student2.tuitionDue());

    }

}

