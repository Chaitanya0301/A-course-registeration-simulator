// TODO file header
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Course Iterator class
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
 * An iterator for Courses in a priority queue, which returns the Courses in order from highest
 * priority to lowest.
 */
public class CourseIterator implements Iterator<Course> {

  // data field - you may NOT add any additional data fields to this class!
  private CourseQueue queue; // a DEEP COPY of the priority queue of courses to iterate over

  /**
   * Creates a new CourseIterator which iterates over the elements of the given CourseQueue
   * in order from the highest-priority course to the lowest-priority course
   *
   * @param queue a DEEP COPY of the queue to iterate over
   */
  public CourseIterator(CourseQueue queue) {
    this.queue = queue;
  }

  /**
   * Returns true if the iteration has more elements.
   *
   * @return {@code true} if the iteration has more elements
   */
  @Override
  public boolean hasNext() {
    // TODO Auto-generated method stub
    if (queue.isEmpty()) { // returns true if next() isn't null
      return false;
    }
    return true;
  }

  /**
   * Returns the next element in the iteration. Consider how to use the priority queue's methods
   * to get the next course in descending order.
   *
   * @return the next element in the iteration
   * @throws NoSuchElementException if the iteration has no more elements
   */
  @Override
  public Course next() throws NoSuchElementException {
    // TODO Auto-generated method
    if (!hasNext()) {
      throw new NoSuchElementException("No more elements");
    }
    return queue.dequeue();
  }
}
