/**
 * LinkedComputerStore --- program uses Computer and Computer to
 * print a menu to the output.  Is the driver class that uses nodes and lists
 * in order to create a functional program that does not crash.
 * @author  Joshua Omori
 */

import java.util.InputMismatchException;
import java.util.Scanner;
	
public class LinkedComputerStore {
   private static void computerStoreMenu () {
      System.out.println("Type [1, 2, 3, 4, or 0] to execute:");
      System.out.println("1. add a computer");
      System.out.println("2. remove a computer");
      System.out.println("3. print computers of a specific operating system");
      System.out.println("4. print all the computers");
      System.out.println("0. end the program");
   }
   public static void main(String[] args) throws Exception {
      int choice = -1; // number to navigate through menu
      Scanner s = new Scanner (System.in);
      CList cList = new CList(); // Creates a new computer list of nodes (empty).
   
      do {
         computerStoreMenu(); //calls on computerStoreMenu (prints to user a menu screen)
         try {
            s = new Scanner (System.in);
            choice = s.nextInt();
            System.out.println("");
         
            switch (choice) {
               case 1:
                  addComputer(cList, s);
                  break;
               case 2:
                  removeComputer(cList, s);
                  break;
               case 3:
                  printOSComputers(cList, s);
                  break;
               case 4:
                  cList.printAllComputers(); //doesn't need user input, so directly calls on cList.printAllComputers();
                  break;
               case 0:
                  System.out.println("Thank you for using this program!");
                  break;
               default:
                  System.out.println("ERROR: Enter an integer that corresponds to the menu\n");
                  break;
            }
         }
         catch (InputMismatchException e){
            System.out.println("\nERROR: Please enter a valid integer\n");
         }
      } while (choice != 0);
   
      s.close();
   }

   private static void addComputer(CList list, Scanner s) throws Exception {
      int ibarcode; // Barcode number from user (range 10001 - 99999)
      int ioS; // OS number from user (1 - Windows, 2 - MacOS, 3 - Linux)
      int price; // Price from user (range $50 - $25000)
      String model; // Model name from user
      
      try {
         System.out.print("Give Barcode number (between 10001 - 99999): ");
         s = new Scanner (System.in);
         ibarcode = s.nextInt();
         
         System.out.print("Give Os number (1 - Windows, 2 - MacOS, 3 - Linux): ");
         s = new Scanner (System.in);
         ioS = s.nextInt();
       	
         System.out.print("Give price (between $50 - $25000): ");
         s = new Scanner (System.in);
         price = s.nextInt();
         
         System.out.print("Give model name (longer than 1 char long): ");
         s = new Scanner (System.in);
         model = s.nextLine();
         
         // list is sent to Computer to display errors if duplicate barcode exists
         Computer c = new Computer(ibarcode, list, ioS, price, model);
         list.add(c); // Node is made (w/computer info) and is added in list cronilogically
      }
      catch (ComputerException e) {
         System.out.println(e.getMessage()+"\n");
         return;
      }
      catch (InputMismatchException e) {
         System.out.println("ERROR: Please enter a valid integer (no letters/special characters)\n");
         return;
      }
   
      System.out.println("\nScanner successfully created\n");
   }
   
   private static void removeComputer(CList cList, Scanner s) throws Exception {
      int userBar; // Barcode number to remove from user
      System.out.print("Enter Barcode Number to remove: ");
      try {
         s = new Scanner (System.in);
         userBar = s.nextInt();
         	 
        /* 
         * Checks if the bar typed from user matches with any other barcodes saved
         * in computerArray.  If so, it gets removed.
         */
         cList.remove(userBar);

      }
      catch (InputMismatchException e){
         System.out.println("\nERROR: Please enter a valid integer\n");
      }
   }
   
   private static void printOSComputers(CList cList, Scanner s) {
      int iuserOS; // OS number used to print all Computer info of specified OS from computerArray
      
      System.out.print("Enter OS number (1 - Windows, 2 - MacOS, 3 - Linux): ");
      try {
         s = new Scanner (System.in);
         iuserOS = s.nextInt();
         System.out.println("");
         cList.printComputersOS(iuserOS); // Only prints out computers of OS type from user input.
      }
      catch (InputMismatchException e){
         System.out.println("ERROR: Please enter an integer\n");
      }
   
   	
   }
}
