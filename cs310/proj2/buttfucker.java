
   /*  buttfucker.java
    This driver program may help you test your JobScheduler and 
    ServiceRequest classes.  Set the constant NUMBER_OF_JOBS to 
    the value desired.  First, random ServiceRequests are generated
    and printed as they are inserted into the scheduler.  Then 
    they are printed as they are removed.  
    
    Because the data is randomly generated, you'll have to check the
    results manually.
    CS310 Fall 2014
    Alan Riggins
*/    


public class buttfucker {
    public static void main(String [] args) {
        final int NUMBER_OF_JOBS = 10;
        JobScheduler scheduler = new JobScheduler(NUMBER_OF_JOBS);
        ServiceRequest req;
        int priority;
        String client, category, description;
        
        String [] cat = {"Classroom","Network","Server","Lab","Faculty","Staff"};
        String [] fName = {"John","Bill","Sam","William","David","Robert",
                           "Arthur","Mike","Shawn","Joe","Chris","Jason",
                           "Mary","Susan","Ashley","Amy","Sally","Katie",
                           "Karen","Nancy","Louise","Kimberly","Marie"};
        String [] lName = {"Johnson","Smith","Jones","Searle","Simpson",
                           "Zimmermann","Rego","Newman","Peterson","O'Konski",
                           "Jamison","Nguyen","Chang","Ramirez","Perez",
                           "Donaldson","Lee","Epstein","Horowitz","O'Dell"};
        String [] problems = {"Software Installation", "Replace Hard Drive",
                              "Add RAM","Replace Video Card","Install DVD Drive",
                              "Reinstall Windows","Monitor not working",
                              "Replace network card","Fix cables",
                              "Boot failure","Unknown Software Problem"};
                              
        System.out.println("***** First printing jobs as they "+
                           "are inserted *****\n\n");
        
        for(int i=0; i < NUMBER_OF_JOBS; i++) {
            priority = (int) (5*Math.random()+1);
            client = fName[(int)(23*Math.random())] + " " +
                     lName[(int)(20*Math.random())];
            category = cat[(int)(6*Math.random())];
            description = problems[(int)(11*Math.random())];
            req = new ServiceRequest(priority,client,category,description);
            scheduler.insertJob(req);                        
            System.out.println(req+"\n====================================");
            }

        System.out.println("");
        System.out.println("jobs waiting: " + scheduler.numberWaiting() + "\nisfull: " + scheduler.schedulerFull());
        System.out.println("has more jobs: " + scheduler.hasMoreJobs());
        System.out.println("Printing all jobs before i remove them ok");
        scheduler.printJobs();
        scheduler.printJobs(2);
        System.out.println("Priority 2 jobs waiting: " + scheduler.numberWaiting(2));
        System.out.println("\n\n***** Now printing jobs as they come " +
                           "out of the scheduler *****");
        
        for(int i=0; i < NUMBER_OF_JOBS; i++) 
            System.out.println(scheduler.nextJob() + 
            "\n====================================");
        System.out.println("");
        System.out.println("Array size is " + scheduler.numberWaiting());
        System.out.println("EMPTY ARRAY TESTERINOS");
        System.out.println("Exception test");
      System.out.println("CAM I WORK PLS");
      try {
        scheduler.insertJob(new ServiceRequest(1, "faglord", "BEIN A FAGGOT", "LLOL IM A FAGGO"));
        System.out.println(" I AM FAIL");
      }
      catch (Exception e) {
        System.out.println( " I AM WORK" );
      }
      
      scheduler.printJobs();
    }

}        
 

