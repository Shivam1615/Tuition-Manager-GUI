package sample;
/**
 * This is an abstract class which includes an abstract method called tuition
 * due that its subclasses inherit. This class also includes the compareto
 * method in order to compare the first name and the last name of a student.
 * 
 * @author Shivam Patel
 * @author Kevin Shah
 */
public abstract class Student implements Comparable<Object> {
	private String fname;
	private String lname;
	protected int credit;

	public static final int INSTATE_PERCOST = 433;
	public static final int OUTSTATE_PERCOST = 756;
	public static final int INTERNATIONAL_PERCOST = 945;
	public static final int UNIVERSITYFEE_PARTTIME = 846;
	public static final int UNIVERSITYFEE_FULLTIME = 1441;
	public static final int INTERNATIONAL_STUDENT_FEE = 350;

	/**
	 * This constuctor initializes the first name, last name, and the number of
	 * credits for all subclasses to inherit.
	 * 
	 * @param fname  is first name of the student.
	 * @param lname  is last name of the student.
	 * @param credit is number of credits student decides to take.
	 */
	public Student(String fname, String lname, int credit) { // constructor
		this.fname = fname;
		this.lname = lname;
		this.credit = credit;
	}

	// must implement compareTo method because Student class implements the
	// Comparable Interface
	// return 0 if fname and lname of the two students are equal,
	// return -1 if this fname and lname is < obj’s, return 1 if this fname and
	// lname is > obj’s
	// Hint: use the .equals and compareToIgnoreCase methods of the String class to
	// compare fname
	// and lname; names are not case-sensitive
	/**
	 * The compareTo method checks whether the first name and the last name of the
	 * student match in the list and returns 0 if the names do match.
	 */
	public int compareTo(Object obj) {
		Student student = (Student) obj;
		if (this.fname.equalsIgnoreCase(student.fname) && this.lname.equalsIgnoreCase(student.lname)) {
			return 0;
		}

		if (this.fname.compareToIgnoreCase(student.fname) < 0 && this.lname.compareToIgnoreCase(student.lname) < 0) {
			return -1;
		}

		if (this.fname.compareToIgnoreCase(student.fname) > 0 && this.lname.compareToIgnoreCase(student.lname) > 0) {
			return 1;
		}

		return -1;
	}

	// return a string with fname, lname and credit hours; subclasses will be using
	// this method.
	/**
	 * This method returns the string of the first name, last name, and the number
	 * of credits student is taking.
	 */
	public String toString() {
		return this.fname + " " + this.lname + " " + this.credit;
	}

	// compute the tuition due; concrete implementation is required in the
	// subclasses.
	/**
	 * This is the abstract method and computes the tuition amount by the subclasses
	 * in order to compute the tuition amounts by the respective subclasses of
	 * instate, outstate, and international.
	 * 
	 * @return returns an integer value after subclasses inherit this abstract
	 *         method.
	 */
	public abstract int tuitionDue();

}
