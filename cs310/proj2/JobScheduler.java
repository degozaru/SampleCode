/* Vincent Chan
 * masc0264
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
import data_structures.*;

public class JobScheduler {
  OrderedArrayPriorityQueue<ServiceRequest> jobList;

  //This will construct a new JobScheduler,
  //using maxJobs as the largest size
  public JobScheduler(int maxJobs) {
    jobList = new OrderedArrayPriorityQueue<ServiceRequest>(maxJobs);
  } //End constructor

  //Insert the job into the queue
  public boolean insertJob(ServiceRequest req) {
    return jobList.insert(req);
  } //End insertJob()

  //Returns the next job to be completed.
  //Also removes the job.
  //returns null if empty.
  public ServiceRequest nextJob() {
    return jobList.remove();
  } //End nextJob()

  //Returns true if jobs remain in the scheduler.
  public boolean hasMoreJobs() {
    return !jobList.isEmpty();
  } //End hasMoreJobs()

  //Returns true of the scheduler is full.
  public boolean schedulerFull() {
    return jobList.isFull();
  } //End schedulerFull()

  //Prints all jobs with given priority
  public void printJobs(int priority) {
    System.out.println("Jobs labeled priority " 
                        + priority + ": ");
    for(ServiceRequest cur : jobList) 
      if(cur.getPriority()==priority)
        System.out.println(cur.toString());
  } //End printJobs()

  //Prints all jobs
  public void printJobs() {
    System.out.println("All current jobs: ");
    for(ServiceRequest cur : jobList) 
        System.out.println(cur.toString());
  }

  //returns the total number of jobs waiting
  //with the given priority.
  public int numberWaiting(int priority) {
    int count = 0;
    for(ServiceRequest cur : jobList) 
      if(cur.getPriority()==priority)
        count++;
    return count;
  } //End numberWaiting()

  //Returns number of jobs remaining
  public int numberWaiting() {
    return jobList.size();
  } //End numberWaiting()
}//End JobScheduler
