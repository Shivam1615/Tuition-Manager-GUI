package sample;
/**
 * Manages a list of students in a form of an array. Manages itself dynamically
 * as it runs out of space by a factor of GROW_SIZE.
 * 
 * @author Kevin Shah
 * @author Shivam Patel
 */
public class StudentList {
    private final int NOT_FOUND = -1;
    private final int GROW_SIZE = 4;
    private Student[] students;
    private int numStudents;

    /**
     * Constructor used to initialize the student list to a given default GROW_SIZE
     * of 4.
     */
    public StudentList() {
        students = new Student[GROW_SIZE];
        numStudents = 0;
    }

    /**
     * Dynamically grows the student list as it runs out of space while copying each
     * element to the new array.
     */
    private void grow() {
        Student[] resizedStudentList = new Student[GROW_SIZE * numStudents];
        for (int i = 0; i < numStudents; i++) {
            resizedStudentList[i] = students[i];
        }
        students = resizedStudentList;
    }

    /**
     * Finds a given student from the list of students.
     * 
     * @param s Student to find
     * @return index at which the student is located in the list, otherwise returns
     *         -1 if not found.
     */
    private int find(Student s) {
        for (int i = 0; i < numStudents; i++) {
            if (students[i].compareTo(s) == 0)
                return i;
        }
        return NOT_FOUND;
    }

    /**
     * Checks if the number of students is 0.
     * 
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return numStudents == 0;
    }

    /**
     * Checks if the student list contains the student specified in the parameter.
     * 
     * @param s Student to check
     * @return true if the student list contains, false otherwise.
     */
    public boolean contains(Student s) {
        for (int i = 0; i < numStudents; i++) {
            if (students[i].compareTo(s) == 0)
                return true;
        }
        return false;
    }

    /**
     * Appends the specified student to the end of the student list. In case the
     * number of students reaches capacity, the function dynamically grows the list
     * first and then adds the student.
     * 
     * @param s Student to add
     */
    public void add(Student s) {
        if (numStudents == students.length)
            grow();
        students[numStudents] = s;
        numStudents++;
    }

    /**
     * Removes the specified student from the list.
     * 
     * @param s Student to remove
     * @return true if removing the student was successful, false otherwise.
     */
    public boolean remove(Student s) {
        int indexToRemove = find(s);
        if (indexToRemove == NOT_FOUND)
            return false;

        // Swap the index to remove with the last item in the array.
        students[indexToRemove] = students[numStudents - 1];
        students[numStudents - 1] = null;

        numStudents--;
        return true;
    }

    /**
     * Prints student information along with the tuition due for individual
     * students.
     */
    public void print() {
        for (int i = 0; i < numStudents; i++) {
            System.out.println(students[i].toString());
        }
    }
}
