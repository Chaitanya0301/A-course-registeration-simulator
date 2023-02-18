// TODO file header
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    CourseReg class
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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * AN application handler for course registration using a priority queue.
 */
public class CourseReg {

  // data fields
  private CourseQueue courses;  // the priority queue of all courses
  private int creditLoad;       // the maximum number of credits you want to take
  
  /**
   * Creates a new course registration object
   * @param capacity the maximum number of courses to store in the priority queue
   * @param creditLoad the maximum number of credits to take next semester
   * @throws IllegalArgumentException if either capacity or creditLoad are not a positive integer
   */
  public CourseReg(int capacity, int creditLoad) throws IllegalArgumentException {
    // TODO complete this constructor, initializing all data fields
    if (capacity <= 0 || creditLoad <= 0) {
      throw new IllegalArgumentException("Illegal Argument!");
    }
    courses = new CourseQueue(capacity);
    this.creditLoad = creditLoad;
  }
  
  /**
   * Returns a string representation of the highest-priority courses with a total number of credits
   * less than or equal to the creditLoad of this CourseReg object. Use the Iterable property of the
   * CourseQueue to help you out!
   * 
   * Note that this is NOT a "knapsack" problem - you're trying to maximize priority, not number of
   * credits. Just add courses to your result String until adding the next would take you over this
   * CourseReg object's creditLoad limit.
   * 
   * @return a string representation with one course on each line, where the total number of credits
   *   represented is less than or equal to the current creditLoad value
   */
  public String getRecommendedCourses() {
    Iterator<Course> ite = null;
    String output = "";

    try {
      ite = courses.iterator();
      int sum = 0;
      while (ite.hasNext()) {
        Course course = ite.next();
        if (sum + course.getNumCredits() <= creditLoad) {
          sum += course.getNumCredits();
          output += course.toString() + "\n";
        } else {
          break;
        }
      }
    } catch (NoSuchElementException e) {

    }

    return output;
  }
  
  /**
   * Tries to add the given course to the priority queue; return false if the queue is full
   * 
   * @param toAdd the course to add
   * @return true if the course was successfully added to the queue
   */
  public boolean add(Course toAdd) {
    try{
      courses.enqueue(toAdd);
    }catch(IllegalStateException i){
      return false; // if queue is full returns false
    }
    return true; // TODO complete this method
  }
  
  /**
   * Updates the creditLoad data field to the provided value
   * @param creditLoad the maximum number of credits to take next semester
   * @throws IllegalArgumentException if creditLoad is not a positive integer
   */
  public void setCreditLoad(int creditLoad) throws IllegalArgumentException {
    // TODO complete this method
    if(creditLoad <= 0){
      throw new IllegalArgumentException("Unacceptable credit load");
    }
    this.creditLoad = creditLoad;
  }
}
