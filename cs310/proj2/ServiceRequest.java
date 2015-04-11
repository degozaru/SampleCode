/* Vincent Chan
 * masc0264
 */

public class ServiceRequest implements Comparable<ServiceRequest> {
  private int priority;
  private String client;
  private String category;
  private String description;

  //Constructs a request with the given parameters
  public ServiceRequest(int priority, String client, 
                      String category, String description) {
    setPriority(priority);
    setCategory(category);
    setClient(client);
    setDescription(description);
  } //End Constructor

  //Returns the priority of the job.
  public int getPriority() {
    return priority;
  } //End getPriority()
        
  //Sets the priority of the job.
  //Priority is between 1 and 5, inclusive.
  public void setPriority(int n) {
    if(n<1 || n>5) throw new IllegalArgumentException();
    priority = n;
  } //End setPriority()

  //Return the client's name.
  public String getClient() {
    return client;
  } //End getClient()

  //Sets the client's name
  public void setClient(String c) {
    client = c;
  } //End setClient()

  //Returns the category of the request
  public String getCategory() {
    return category;
  } //End getCategory()

  /*Sets the category. Throws exception if illegal parameter.
   * Legal parameters:
   * Classroom
   * Network
   * Server
   * Lab
   * Falculty
   * Staff
   */
  public void setCategory(String c) {
    switch(c.toUpperCase()) {
      case "CLASSROOM": case "NETWORK":
      case "SERVER":    case "LAB":
      case "FACULTY":   case "STAFF":
        category = c.toUpperCase();
        break;
      default:
        throw new IllegalArgumentException();
    }
  } //End setCategory()

  //Returns a description of the request.
  public String getDescription() {
    return description;
  } //End getDescription()

  //Sets the description of the request.
  public void setDescription(String d) {
    description = d;
  } //End setDescription()

  //Returns the request in printable format.
  public String toString() {
    return priority + " | " 
            + category + " | " 
            + client + " | " 
            + description;
  } //End toString()

  //Compares the request to another request.
  //Returns a positive value if priority is lower
  //Returns negative if priority is higher (meaning finish first)
  public int compareTo(ServiceRequest req) {
    int comp = priority - req.getPriority();
    if(comp!=0) return comp;
    return categoryPri() - req.categoryPri();
  } //End compareTo

  //Returns the priority of the category.
  private int categoryPri() {
    switch (category) {
      case "CLASSROOM": return 1;
      case "NETWORK": return 2;
      case "SERVER": return 3;
      case "LAB": return 4;
      case "FACULTY": return 5;
      default: return 6;
    }
  } //End categoryPri()
} //End ServiceRequest
