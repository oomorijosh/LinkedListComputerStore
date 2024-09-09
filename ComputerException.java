public class ComputerException extends Exception {
   private String message = "OOPSIE!!";
	
   public ComputerException() {
   }

   public void setMessage(String newMessage) {
      this.message = newMessage;
   }
	
   public String getMessage() {
      return this.message;
   }
}