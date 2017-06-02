import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceApp {
	static ArrayList<Double> prices;
	static double taxRate;
	static Scanner in;
	
	public static void main(String... strings){
		in = new Scanner(System.in);
		prices = new ArrayList<>();
		
		
		pf("Please enter your tax rate: ");
		while (!in.hasNextDouble()) {
			pf("the tax rate must be a number: ");
			in.next();
		}
		taxRate = in.nextDouble();

		pf("you have entered a tax rate of %s you may now enter sales items.\n", taxRate);
		char again;
		int counter = 1;
		do {
			pf("item #%d: ", counter);
			while (!in.hasNextDouble()) {
				pf("please enter price");
				in.next();
			}
			prices.add(in.nextDouble());
			in.nextLine();
			pf("another? (y/n)");
			again = in.nextLine().toLowerCase().charAt(0);
			counter++;
		} while (again == 'y');
		
		double total = 0;
		
		
		
		pf("Receipt:\n");
		
		for (double price : prices) {
			total += price;
			pf("-%s \n", price);
		}
		pf("total: %s \n", total);
		pf("tax: %s \n", total * taxRate);
		pf("grand total: %s \n" ,total * (1 + taxRate));
		
	}
	
	public static void pf(String format, Object... args) {
		System.out.printf(format, args);
	}
	
}


/*
Note: This project requires the use of an array to keep the list of prices. 
We have not yet discussed arrays - we'll get to that tomorrow. For now keep the prices in an array of type double as follows:

 

//declare the array of a set size
 double myPrices[] = new double[100];
//add prices to array. 
 //Use a counter to keep track of how many items are in your array.
 int counter = 0;
myPrices[counter] = 199.99;
 counter +=1;
 myPrices[counter] = 350.0;
 counter +=1;
 myPrices[counter] = 500.33;
//print the array
 for (int i=0;i <=counter; i++){
System.out.printf("The price is %.02f\n",myPrices[i]);
}
}
 

You can use the NumberFormat class from the Java API

NumberFormat nf= NumberFormat.getInstance();
nf.setMaximumFractionDigits(2);
nf.setMinimumFractionDigits(2);
nf.setRoundingMode(RoundingMode.HALF_UP);

System.out.print(nf.format(decimalNumber));
Or you can use String.format. This will also work with printf to print a formatted string.

double d = yourDoubleValue;  
String formattedData = String.format("%.02f", d);
 

Create an application that allows the user to enter a tax rate followed by any number of prices. 
When the user enters a price of 0.0, the application should print out the list of prices entered followed by the subtotal, tax and grand total

The program should run something like this:

Tax Rate ? : .05
Price # 1   : 2.34
Price # 2  : 3.0
Price # 3   : 5.50
Price # 4   : 0.0

--------------------------------------------

Receipt
2.34
3.00
5.50
10.84 subtotal
.542  tax
11.36  grand total

*/