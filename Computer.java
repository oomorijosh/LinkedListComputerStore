/**
 * Computer --- program creates a way to store computer information using
 * get and set methods under the computer class.  Each variable should
 * have its own parameters that calls on ComputerException.  There should
 * also be a toString method to get the formatted information.
 * @author  Joshua Omori
 */

public class Computer {
   private int iBarcode = 0;   //int ranging from 10001 - 99999
   private int iOs;        //1 - "Windows"  2 - "MacOS"  3 - "Linux"
   private double price;   //double ranging from $50.00 to $25,000.00
   private String model;   //String of model name
	
   /**
    * main class method that uses barcode, OS, price, and model
    * to call on set methods for all of the variables.
    * @param     bar, Os, price, and model
    * @exception Any exception
    * @return    No return value.
    */ 
   public Computer (int bar, CList list, int Os, double price, String model) throws Exception{
      this.setBarcode(bar, list);
      this.setOs(Os);
      this.setPrice(price);
      this.setModel(model);
   }


   /**
    * set method to set a new barcode value which must be between 10001 and 99999
    * @param     bar               An int value representing the barcode
    * @exception ComputerException Any value not between 10001 - 99999
    * @return                      No return value.
    */ 
   public void setBarcode(int bar, CList list) throws Exception {
      if(bar >= 10001 && bar <= 99999){
         this.iBarcode = bar;
      }
      else{         
         ComputerException me = new ComputerException();
         me.setMessage("ERROR: Set bar between 10001 and 99999");
         throw me;
      }
      if (!list.checkBarcode(bar)) {
         ComputerException me = new ComputerException();
         me.setMessage("ERROR: Barcode already exists...");
         throw me;
      }
      
   }

   /**
    * set method to set a new OS value which must be 1 2, or 3
    * @param     Os                An int value where 1 = Windows, 2 = MacOS, and 3 = Linux
    * @exception ComputerException Any value not between 1 - 3
    * @return                      No return value.
    */ 
   public void setOs(int Os) throws Exception {
      if(Os == 1 || Os == 2 || Os == 3){
         this.iOs = Os;
      }
      else{         
         ComputerException me = new ComputerException();
         me.setMessage("ERROR: Set OS = 1 for Windows, 2 for MacOS, and 3 for Linux");
         throw me;
      }
   }
   
   /**
    * set method to set a new price value which must be between 50 and 25000
    * @param     price             A double value representing the price of computer
    * @exception ComputerException Any value not between 50 and 25000
    * @return                      No return value.
    */
   public void setPrice(double price) throws Exception {
      if(price >= 50.00 && price <= 25000.00){
         this.price = price;
      }
      else{         
         ComputerException me = new ComputerException();
         me.setMessage("ERROR: Set price between 50 and 25000");
         throw me;
      }
   }

   /**
    * set method to set a new model string which must be at least 2 characters long
    * @param     model             A string value representing the computer model name
    * @exception ComputerException Any string less than 2 characters long
    * @return                      No return value.
    */   
   public void setModel(String model) throws Exception {
      if(model.length() >= 2){
         this.model = model;
      }
      else{         
         ComputerException me = new ComputerException();
         me.setMessage("ERROR: Set model name longer than 2 characters");
         throw me;
      }
   }


   /**
    * get method to get a new barcode value
    * @param                No parameters.
    * @exception            Any exception
    * @return this.iBarcode An int value representing the barcode.
    */ 
   public int getBarcode() throws Exception {
      try {
         return this.iBarcode;
      }
      catch (Exception e) {
         return 0;
      }
     
   }

   /**
    * get method to get OS name based off of OS value
    * @param          No parameters.
    * @exception      Any exception
    * @return         If iOs == 1, "Windows"; iOs == 2, "MacOS"; and iOs == 3, "Linux"
    */ 
   public String getOs() {
      switch (this.iOs) {
         case 1:
            return "Windows";
         case 2:
            return "MacOS";
         case 3:
            return "Linux";
      }
      return "n/a"; 
   }
   
   /**
    * get method to get a new price value
    * @param             No parameters.
    * @exception         Any exception
    * @return this.price A double value representing the price.
    */ 
   public double getPrice() {
      return this.price;
   }
   
   /**
    * get method to get a new model name
    * @param             No parameters.
    * @exception         Any exception
    * @return this.model A String representing the model name.
    */ 
   public String getModel() {
      return this.model;
   }

   
   /**
    * toString method to format the computer information.
    * @param             No parameters.
    * @exception         Any exception
    * @return            A formatted String showing the computer information.
    */ 
   public String toString() {
      //
      String s = "Barcode number: " + this.iBarcode;
      s = s + "\n            OS: " + getOs();
      s = s + "\n         price: $" + String.format("%.2f", this.price);
      s = s + "\n         model: " + this.model;
      //
      return s;
   }
}
