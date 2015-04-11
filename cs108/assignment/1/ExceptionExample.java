public class ExceptionExample {


	public static void main(String[] args) {
		
		try{
			//try something that we KNOW will cause an exception
			double x = 5/0;
		}
		catch(Exception e){ //catch the exception
			System.out.println("Exception: "+e.getMessage());
		}
		
		System.out.println("Continuing execution after try/catch block.");
	}

}
