// TODO file header
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    CourseReg Tester class
// Course:   CS 300 Fall 2022
//
// Author:   Chaitanya Sharma
// Email:    csharma4@wisc.edu
// Lecturer: Mouna Kacem
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         NONE
// Online Sources:  NONE
///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;

/**
 * This class implements unit test methods to check the correctness of Course,  CourseIterator, 
 * CourseQueue and CourseReg classes in P10.
 * 
 * Be aware that all methods in this class will be run against not only your code, but also our own
 * working and broken implementations to verify that your tests are working appropriately!
 */
public class CourseRegTester {
  
  /**
   * START HERE, and continue with testCompareTo() after this.
   *
   * This method must test the Course constructor, accessor, and mutator methods, as well as its
   * toString() implementation. The compareTo() method will get its own test.
   *
   * @see Course
   * @return true if the Course implementation is correct; false otherwise
   */
  public static boolean testCourse() {
    // TODO: complete this test
    Course invalid = null;
    try {
      try {
        invalid = new Course(null, 100, 4, 0); // no dept name
        return false;
      }catch (IllegalArgumentException e) {

      } catch (Exception e) {
        return false;
      }
        try {
          invalid = new Course("CS", 0, 3, 0); // 0 COURSE NUMBER
          return false;
        } catch (IllegalArgumentException e) {

        } catch (Exception e) {
          return false;
        }
        try {
          invalid = new Course("MATH", 1, 0, 0); // invalid credits
          return false;
        } catch (IllegalArgumentException e) {

        } catch (Exception e) {
          return false;
        }
        try {
          invalid = new Course("MATH", 1, 1, -1); //negative seats
          return false;
        } catch (IllegalArgumentException e) {

        } catch (Exception e) {
          return false;
        }
        invalid = new Course("CS", 200, 3, 400);
        if (invalid.getNumCredits() != 3) {
          return false;
        } // checks getCredits


        Course course1 = new Course("Math", 101, 3, 100);
        Course course2 = new Course("Anthro", 101, 3, 100);
        Course course3 = new Course("Math", 101, 3, 100);
        course3.setProfessor(null, 4.0);
        Course course4 = new Course("Math", 101, 3, 100);
        Course course5 = new Course("Math", 101, 3, 100);

        // different ratings
        invalid.setProfessor("Wang", 4.5);
        course3.setProfessor("Wang", 4.0);
        if (invalid.equals(course3)) {
          return false;
        }
        if (!invalid.toString().contains("(") || !invalid.toString().contains(")")) { // checks toString()
          return false;
        }

        invalid.setSeatsAvailable(0);
        if (invalid.toString().contains("seats")) {
          return false;
        }
        try {
          invalid.setProfessor("Brian", -5); // checks invalid rating
          return false;
        } catch (IllegalArgumentException e) {

        } catch (Exception e) {
          return false;
        }

        try {
          invalid.setProfessor(null, -1); // checks if it continues after professor is null
        } catch (Exception e) {
          return false;
        }

        try {
          invalid.setSeatsAvailable(-5); //invalid seats
        } catch (IllegalArgumentException e) {

        } catch (Exception e) {
          return false;
        }
      } catch (Exception e) {
        return false;
      }

      return true;

  }

  /**
   * This method must test the Course compareTo() implementation. Be sure to test ALL FOUR levels
   * of the comparison here!
   *
   * Once you complete this test, finish the Course implementation if you have not done so already,
   * then move to testCourseQueue() and testEnqueueDequeue().
   *
   * @see Course#compareTo(Course)
   * @return true if the compareTo() implementation is correct; false otherwise
   */
  public static boolean testCompareTo() {
    // TODO: complete this test
    Course ma100 = new Course("CS",100,3,25);
    ma100.setProfessor("Brian",3.0);
    Course ma101 = new Course("CS",101,3,25);
    ma101.setProfessor("Wang",4.1);
    Course ma102 = new Course("Math",102,3,0);
    Course ma103 = new Course("CS",103,3,25);
    Course ma104 = new Course("CS",104,3,0);

    if(ma101.compareTo(ma100) != 1){ // checks if ma101 is greater as the professor has higher rating
      return false;
    }
    if(ma102.compareTo(ma100) != -1){ // lower course
      return false;
    }
    if(ma103.compareTo(ma102) != 1){ // Department check
      return false;
    }
    if(ma103.compareTo(ma104) != 1){ // no seats
      return false;
    }
    return true; //no bugs
  }

  /**
   * This method must test the other methods in CourseQueue (isEmpty, size, peek). Verify normal
   * cases and error cases, as well as a filled and re-emptied queue.
   *
   * Once you have completed this method, implement the required methods in CourseQueue and verify
   * that they work correctly.
   *
   * @see CourseQueue
   * @return true if CourseQueue's other methods are implemented correctly; false otherwise
   */
  public static boolean testCourseQueue() {
    // TODO: complete this test
    CourseQueue uwMadison = null;

    try{
      try {
        uwMadison = new CourseQueue(0); // wrong capacity
        return false;
      } catch (IllegalArgumentException e) {
      }

      uwMadison = new CourseQueue(3);
      if (!uwMadison.isEmpty() || uwMadison.size() != 0) { // constructor test
        return false;
      }

      try {
        uwMadison.peek(); //null peek
      } catch (NoSuchElementException e) {

      }

      Course course1 = new Course("Anthro", 200, 3, 100);
      uwMadison.enqueue(course1);
      if (!course1.equals(uwMadison.peek())) {
        return false;
      }

      Course course2 = new Course("CS", 200, 3, 0);
      if (course2.compareTo(course1) <= 0) {
        return false;
      }
      uwMadison.enqueue(course2);

      if (!course2.equals(uwMadison.peek())) {
        return false;
      }

      Course course3 = new Course("CS", 300, 3, 555);
      if (course3.compareTo(course2) <= 0 || course3.compareTo(course1) <= 0) {
        return false;
      }
      uwMadison.enqueue(course3);

      if (!course3.equals(uwMadison.peek())) {
        return false;
      }
      if(uwMadison.isEmpty() || uwMadison.size() != 3){
        return false;
      }


      Course course4 = new Course("CS", 400, 4, 666);
      //adds to full queue
      try {
        uwMadison.enqueue(course4);
        return false;
      } catch (IllegalStateException e) {

      }

      // test dequeue
      if (!uwMadison.dequeue().equals(course3) || uwMadison.isEmpty() || uwMadison.size() != 2) {
        return false;
      }

    } catch (Exception e) {
      return false;
    }
    return true;
}

  /**
   * This method must test the enqueue and dequeue methods in CourseQueue. Verify normal cases and
   * error cases, as well as filling and emptying the queue.
   *
   * You may also test the percolate methods directly, though this is not required.
   *
   * Once you have completed this method, implement the enqueue/dequeue and percolate methods in
   * CourseQueue and verify that they work correctly, then move on to testCourseIterator().
   *
   * @see CourseQueue#enqueue(Course)
   * @see CourseQueue#dequeue()
   * @return true if the CourseQueue enqueue/dequeue implementations are correct; false otherwise
   */
  public static boolean testEnqueueDequeue() {
    // TODO: complete this test
    CourseQueue courses = null;

    try {
      courses = new CourseQueue(7);
      //TESTER courses
      Course course1 = new Course("Math", 200, 3, 0);
      Course course2 = new Course("Math", 234, 3, 0);
      Course course3 = new Course("Math", 256, 3, 50);
      Course course4 = new Course("Math", 298, 3, 50);
      course4.setProfessor("Ann", 0.0);
      Course course5 = new Course("Math", 222, 3, 50);
      course5.setProfessor("Brian", 3.0);
      Course course6 = new Course("Math", 220, 3, 50);
      course6.setProfessor("Wang", 4.0);
      Course course7 = new Course("CS", 300, 3, 400);

    //priority order
      if (course1.compareTo(course2) != 0 || course2.compareTo(course3) >= 0 ||
              course3.compareTo(course4) >= 0 || course4.compareTo(course5) >= 0 ||
              course5.compareTo(course6) >= 0 || course6.compareTo(course7) >=0) {
        return false;
      }

      try { //check for exception in empty queue
        courses.dequeue();
        return false;
      } catch (NoSuchElementException e) {

      }

      // checks for enqueue exception
      try {
        courses.enqueue(null);
        return false;
      } catch (NullPointerException e) {

      }
      try {
        courses.peek();
        return false;
      } catch (NoSuchElementException e) {

      }

      courses.enqueue(course1);
      if (courses.size() != 1 || !courses.peek().equals(course1)) {
        return false;
      }
      courses.enqueue(course2);
      if (courses.size() != 2 || !courses.peek().equals(course1)) {
        return false;
      }
      courses.enqueue(course3);
      if (courses.size() != 3 || !courses.peek().equals(course3)) {
        return false;
      }
      courses.enqueue(course4);
      if (courses.size() != 4 || !courses.peek().equals(course4)) {
        return false;
      }
      courses.enqueue(course5);
      if (courses.size() != 5 || !courses.peek().equals(course5)) {
        return false;
      }
      courses.enqueue(course6);
      if (courses.size() != 6 || !courses.peek().equals(course6)) {
        return false;
      }
      courses.enqueue(course7);
      if (courses.size() != 7 || !courses.peek().equals(course7)) {
        return false;
      }

      //adds to a full queue, checks for IllegalStateException
      Course courseInvalid = new Course("CS", 400, 4, 400);
      try {
        courses.enqueue(courseInvalid);
        return false;
      } catch (IllegalStateException e) {

      }
      // dequeue test
      if (!courses.dequeue().equals(course7) || courses.size() != 6 || !courses.peek().equals(course6)) {
        return false;
      }

      if (!courses.dequeue().equals(course6) || courses.size() != 5 || !courses.peek().equals(course5)) {
        return false;
      }
    } catch (Exception e) {
      return false;
    }

    return true;
  }

  /**
   * This method must test the CourseIterator class. The CourseIterator iterates through a deep copy
   * of a CourseQueue in decreasing order of priority, returning each Course object in turn.
   *
   * Once you have completed this method, implement the CourseIterator class and make CourseQueue
   * into an Iterable class. Verify that this works correctly, and then move on to the final test
   * method: testCourseReg().
   *
   * @see CourseIterator
   * @return true if the CourseIterator implementation is correct; false otherwise
   */
  public static boolean testCourseIterator() {
    CourseIterator ite = null;
    CourseQueue courses = null;

    try {
      courses = new CourseQueue(7);

      Course course1 = new Course("Math", 200, 3, 0);
      Course course2 = new Course("Math", 234, 3, 0);
      Course course3 = new Course("Math", 256, 3, 50);
      Course course4 = new Course("Math", 298, 3, 50);
      course4.setProfessor("Ann", 0.0);
      Course course5 = new Course("Math", 222, 3, 50);
      course5.setProfessor("Brian", 3.0);
      Course course6 = new Course("Math", 220, 3, 50);
      course6.setProfessor("Wang", 4.0);
      Course course7 = new Course("CS", 300, 3, 400);

      courses.enqueue(course1);

      courses.enqueue(course2);


      courses.enqueue(course3);


      courses.enqueue(course4);

      courses.enqueue(course5);


      courses.enqueue(course6);


      courses.enqueue(course7);

      ite = new CourseIterator(courses.deepCopy());

      if (!ite.hasNext() || !ite.next().equals(course7)) {
        return false;
      }

      if (!ite.hasNext() || !ite.next().equals(course6)) {
        return false;
      }

      if (!ite.hasNext() || !ite.next().equals(course5)) {
        return false;
      }

      if (!ite.hasNext() || !ite.next().equals(course4)) {
        return false;
      }

      if (!ite.hasNext() || !ite.next().equals(course3) ||
              courses.size() != 7) {
        return false;
      }

      if (!ite.hasNext() || !ite.next().equals(course1) ||
              courses.size() != 7) {
        return false;
      }

      if (!ite.hasNext() || !ite.next().equals(course2)) {
        return false;
      }

      // checks on an empty deepcopy
      if (ite.hasNext()) {
        return false;
      }
      try {
        ite.next();
        return false;
      } catch (NoSuchElementException e) {

      }

    } catch (Exception e) {
      return false;
    }
    return true; //no bugs
  }

  /**
   * This method must test the constructor and three methods of the CourseReg class (setCreditLoad,
   * add, and getRecommendedCourses). Verify normal cases and error cases.
   *
   * Once you have completed this method, implement CourseReg and verify that it works correctly.
   * Then you're DONE! Save and submit to gradescope, and enjoy being DONE with programming
   * assignments in CS 300 !!!
   *
   * @see CourseReg
   * @return true if CourseReg has been implemented correctly; false otherwise
   */
  public static boolean testCourseReg() {
    // TODO: complete this test
    CourseReg reg = null;

    try {
      Course course1 = new Course("Math", 222, 4, 0);
      Course course2 = new Course("Anthro", 101, 3, 0);
      Course course3 = new Course("Math", 221, 5, 400);
      Course course4 = new Course("Math", 400, 3, 400);
      course4.setProfessor("Brian", 0.0);
      Course course5 = new Course("CS", 441, 3, 400);
      course5.setProfessor("Wang", 3.0);
      Course course6 = new Course("CS", 570, 4, 400);
      course6.setProfessor("Zhang", 4.0);
      Course course7 = new Course("CS", 540, 4, 400);
      course7.setProfessor("Levi", 5.0);

      try {
        reg = new CourseReg(0, 12); // invalid capacity
        return false;
      } catch (IllegalArgumentException e) {

      }

      try {
        reg = new CourseReg(9, 0); //invalid credits
        return false;
      } catch (IllegalArgumentException e) {

      }
      reg = new CourseReg(6, 17);

      if (reg == null) { // checks if null
        return false;
      }

      reg.add(course6);
      String[] result = reg.getRecommendedCourses().split("\n");
      if (!result[0].equals(course6.toString())) {
        return false;
      }

      reg.add(course7);
      result = reg.getRecommendedCourses().split("\n");
      if (!result[0].equals(course7.toString()) || !result[1].equals(course6.toString())) {
        return false;
      }

      reg.add(course5);
      result = reg.getRecommendedCourses().split("\n");
      if (!result[2].equals(course5.toString())) {
        return false;
      }

      reg.add(course2);
      result = reg.getRecommendedCourses().split("\n");
      if (!result[3].equals(course2.toString())) {
        return false;
      }

      reg.add(course1); //invalid addition
      result = reg.getRecommendedCourses().split("\n");
      if (result.length != 4||!result[3].equals(course2.toString())) {
        return false;
      }

      reg.setCreditLoad(15);
      result = reg.getRecommendedCourses().split("\n");
      if (result.length != 5||!result[4].equals(course1.toString())) {
        return false;
      }

      reg.setCreditLoad(10);
      result = reg.getRecommendedCourses().split("\n");
      if (!result[0].equals(course7.toString()) || !result[1].equals(course6.toString())) {
        return false;
      }

      reg.setCreditLoad(5);
      result = reg.getRecommendedCourses().split("\n");
      if (!result[0].equals(course7.toString())) {
        return false;
      }


      try {
        reg.setCreditLoad(0); // invalid parameter
        return false;
      } catch (IllegalArgumentException e) {

      }

      reg.add(null);// adding null

    } catch (Exception e) {
      return false;
    }

    return true; // noo bugs :0
  }

  /**
   * This method calls all test methods defined by us; you may add additional methods to this if
   * you like. All test methods must be public static boolean.
   *
   * @return true if all tests in this class return true; false otherwise
   */
  public static boolean runAllTests() {
    boolean testVal = true;

    // test Course
    System.out.print("testCourse(): ");
    if (!testCourse()) {
      System.out.println("FAIL");
      testVal = false;
    } else { System.out.println("pass"); }

    // test compareTo
    System.out.print("testCompareTo(): ");
    if (!testCompareTo()) {
      System.out.println("FAIL");
      testVal = false;
    } else { System.out.println("pass"); }

    // test CourseIterator
    System.out.print("testCourseIterator(): ");
    if (!testCourseIterator()) {
      System.out.println("FAIL");
      testVal = false;
    } else { System.out.println("pass"); }

    // test CourseQueue enqueue/dequeue
    System.out.print("testEnqueueDequeue(): ");
    if (!testEnqueueDequeue()) {
      System.out.println("FAIL");
      testVal = false;
    } else { System.out.println("pass"); }

    // test CourseQueue
    System.out.print("testCourseQueue(): ");
    if (!testCourseQueue()) {
      System.out.println("FAIL");
      testVal = false;
    } else { System.out.println("pass"); }

    // test CourseReg
    System.out.print("testCourseReg(): ");
    if (!testCourseReg()) {
      System.out.println("FAIL");
      testVal = false;
    } else { System.out.println("pass"); }

    return testVal;
  }

  /**
   * Calls runAllTests() so you can verify your program
   *
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    runAllTests();
  }
}
