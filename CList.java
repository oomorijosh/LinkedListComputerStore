public class CList {
   private static int count;
   private CNode first = null;   // used to tell where the beginning of the list is
   private CNode last = null;    // used to tell where the end of the list is
   private CNode current = null; // cursor to have a specific position in the list
   private CNode pre = null;     // precursor to help rewire nodes.
	
   public CList() {
   }

  /**
   * method that adds a computer to the list of nodes
   * and is set in barNumerical order.
   * @param     Computer
   * @exception Any exception
   * @return    No return value.
   */ 
   public void add(Computer c) throws Exception {
      CNode node = new CNode(c); //Creates a new node of computer
      current = first;
      pre = first;
   	
      // if there are no nodes, starts the list by making first and last = node
      if (first==null) {
         first = node;
         last = node;
      }
      else {
         // if user barcode is lower than the lowest barcode, set first = user barcode 
         if (c.getBarcode() <= first.getComputer().getBarcode()) {
            node.setNext(first);
            first = node;
         }
         // if user barcode is higher than the highest barcode, set last = user barcode
         else if (c.getBarcode() >= last.getComputer().getBarcode()) {
            last.setNext(node);
            last = node;
         }
         // if user barcode is somewhere in the middle of the list...
         else {
            // cycles through the list until userBarcode > cursor (moving through list)
            while (c.getBarcode() > current.getComputer().getBarcode()) {
               pre = current;
               current = current.getNext();
            
            }
            //rewires previous cursor node to user node to current node
            pre.setNext(node);
            node.setNext(current);
         }
      }
   }
	
  /**
   * method that removes a computer node from the list of nodes
   * @param     barcode
   * @exception Any exception
   * @return    No return value.
   */ 
   public void remove(int barcode) throws Exception {
      current = first;
      pre = null;
      
      if (first == null) {
         System.out.println("There are no entries to remove\n");
         return;
      }
      else {
        /*
         * Cycles through list until either user barcode = a barcode in the list (method continues) or
         * when for sure there are no more barcodes in the list that match with user barcode
         * (method stops with appropriate message)
         */
         while (current.getComputer().getBarcode() != barcode) {
            pre = current;
            current = current.getNext();
            if (current==null) {
               System.out.println("Could not find barcode...\n");
               return;
            }
         	/*
         	 *  Auto stops search when barcode nodes in list becomes greater than
         	 *  barcode to remove (saves on BigO)
         	 */
            if (current.getComputer().getBarcode()>barcode) {
               System.out.println("Could not find barcode...\n");
               return;
            }
         }
         // if there is only one node, goes to zero
         if (first==last) {
            first = null;
            last = null;
         }
         // if the first node in the list matches, makes first = next node
         else if (pre==null) {
            first = current.getNext();
         }
         // rewires previous node to skip over node to remove
         else {
            pre.setNext(current.getNext());
            // if the node to remove is the last, makes last = previous node
            if (current.getNext()==null) {
               last = pre;
            }
         }
         System.out.println("Barcode successfully deleted.\n");
      }
   }
   
  /**
   * method that prints computer nodes from only a certain type of OS
   * @param     iuserOS
   * @exception Any exception
   * @return    No return value.
   */ 
   public void printComputersOS(int iuserOS) {
      boolean r = false; // used to tell if any OS the user chose exists in the list
      // repeats through the whole list
      for (current = first; current!=null; current=current.getNext()) {
         switch (iuserOS) {
            case 1:
               if (current.getComputer().getOs()=="Windows") {
                  System.out.println(current.getComputer() + "\n");
                  r = true;
               }
               break;
            case 2:
               if (current.getComputer().getOs()=="MacOS") {
                  System.out.println(current.getComputer() + "\n");
                  r = true;
               }
               break;
            case 3:
               if (current.getComputer().getOs()=="Linux") {
                  System.out.println(current.getComputer() + "\n");
                  r = true;
               }	
               break;
            default:
               System.out.println("ERROR: Please enter: 1 - Windows, 2 - MacOS, 3 - Linux\n");
               return;
         }
      }
      if (r == false) {
         System.out.println("There are no computers under the OS typed.\n");
      }
   }
	
  /**
   * method that prints all of the computer nodes in the list
   * @param     No param.
   * @exception Any exception
   * @return    No return value.
   */ 
   public void printAllComputers() {  
      current = first;    
      if(first == null) {    
         System.out.println("The computer list is empty.\n"); 
         return;
      }  
      while(current != null) {     
         System.out.println(current + "\n");   
         current = current.getNext();
      }
   }

  /**
   * Method that checks if the barcode the user typed matches with any of the 
   * barcodes on the list
   * @param     No param.
   * @exception Any exception
   * @return    No return value.
   */ 
   public boolean checkBarcode(int n) throws Exception {
      current = first;
      // if there are no nodes, user typed barcode is unique
      if(first == null) {
         return true;
      }  
      // cycles through all of the nodes in the list
      while(current != null) {   
         // if barcode matches with any that are in the list, barcode not unique. 
         if (current.getComputer().getBarcode() == n) {
            System.out.println(current.getComputer().getBarcode());   
            return false;
         }
         current = current.getNext();
      }
      return true;
   }
	
}
