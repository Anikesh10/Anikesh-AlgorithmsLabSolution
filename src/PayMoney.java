
import java.util.Scanner;

public class PayMoney {
	 
	  private final static boolean checkTransactions(int target, int []transactions) {
		  int index = 0;
		   while(index != transactions.length) {
			   target = target - transactions[index];
			   
			   if(target <= 0) {
				   System.out.println("Target has been achieved in "+ (index+1) + " transactions.");
				   return true;
			   } 
			   index++;
		   }
		   System.out.println("Given target is not achieved.");
		   return false;
	  }
	  
  public static void main(String[] args) {
	  int transactions[];
	  int targets[];
	  int totalTargets = 0;
	  int currentTargetIndex = 0;
	 
	  Scanner scan = new Scanner(System.in);
	  System.out.println("Enter the size of the transaction array.");
	  int size = scan.nextInt();
	  
	  // Get transactions inputs based on the size
//	  if(size > 0) {
		  System.out.println("Enter the values of transaction array.");
		  transactions = new int[size];
		  for(int i=0; i < size; i++) {
			  transactions[i] = scan.nextInt();
		  }
//	  } else {
//		  System.out.println("Invalid size of the transaction array.");
//	  }

      // Get number of targets
	  System.out.println("Enter total number of targets that needs to be achieved.");
	  totalTargets = scan.nextInt();
	   if(totalTargets > 0) {
		  targets = new int[totalTargets];
		  
		  while(currentTargetIndex!=totalTargets) {
			  System.out.println("Enter the value of target ");
			  targets[currentTargetIndex] = scan.nextInt();
			  checkTransactions(targets[currentTargetIndex], transactions);
			  currentTargetIndex++;
		  }
	   } else {
		   System.out.println("Invalid number of target.");
	   }
	  
	  scan.close();
  }
}
