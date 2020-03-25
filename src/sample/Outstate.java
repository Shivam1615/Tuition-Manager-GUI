package sample;
/**
 * This class overrides the toString and the tuitionDue of the Student class to
 * obtain information about an Out of State student.
 * 
 * @author Shivam Patel
 * @author Kevin Shah
 */
public class Outstate extends Student {
    private boolean tristate;

    /**
     * This constructor initializes the first name, last name, number of credits,
     * and whether student is in the tristate area.
     * 
     * @param fname    is the first name of the student.
     * @param lname    is the last name of the student.
     * @param credit   is the number of credits the student is taking.
     * @param tristate decides whether the student is in tristate area or not in
     *                 order to get discount off of the tuition.
     */
    public Outstate(String fname, String lname, int credit, boolean tristate) {
        super(fname, lname, credit);
        this.tristate = tristate;
    }

    /**
     * This toString method overrides the student class toString in order to show
     * tuition for out of state student.
     */
    @Override
    public String toString() {
        return super.toString() + " tuition due: " + "$" + this.tuitionDue();
    }

    /**
     * This method computes the tuition amount of an out of state student and
     * overrides the abstract method of the student class.
     */
    @Override
    public int tuitionDue() {
        int tuition = 0;

        if (this.credit < 12) {
            if (this.tristate == true) {
                tuition = this.credit * (Student.OUTSTATE_PERCOST) + Student.UNIVERSITYFEE_PARTTIME;
            } else if (this.tristate == false) {
                tuition = (Student.OUTSTATE_PERCOST * this.credit) + Student.UNIVERSITYFEE_PARTTIME;
            }
        } else if (this.credit >= 12) {
            if (this.credit >= 15) {
                if (this.tristate == true) {
                    tuition = 15 * (Student.OUTSTATE_PERCOST - 200) + Student.UNIVERSITYFEE_FULLTIME;
                } else if (this.tristate == false) {
                    tuition = (Student.OUTSTATE_PERCOST * 15) + Student.UNIVERSITYFEE_FULLTIME;
                }
            } else {
                if (this.tristate == true) {
                    tuition = this.credit * (Student.OUTSTATE_PERCOST - 200) + Student.UNIVERSITYFEE_FULLTIME;
                } else if (this.tristate == false) {
                    tuition = (Student.OUTSTATE_PERCOST * this.credit) + Student.UNIVERSITYFEE_FULLTIME;
                }
            }
        }
        return tuition;

    }

    /**
     * This testbed main method tests all of the methods and constructor to ensure
     * its correctness.
     * 
     * @param args is the main argument of the testbed main class.
     */
    public static void main(String[] args) {

        Outstate student = new Outstate("John", "White", 17, true);
        Outstate student2 = new Outstate("King", "Kong", 14, false);
        Outstate student3 = new Outstate("John", "McCain", 9, true);
        Outstate student4 = new Outstate("Donald", "Trump", 12, false);

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
