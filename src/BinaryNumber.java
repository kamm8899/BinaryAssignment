
//@author Jessica Kamman

import java.util.Arrays;
import java.lang.*;

//Binary Class defined
public class BinaryNumber {
	private int data[];
	private boolean overFlow;
	
		//binary constructor for binary numbers
	public BinaryNumber(int length) {
		data= new int[length];
	
		//this will initialize the data array
		for(int i=0; i<length; i++) {
			data[i]=0;
		}
	}
	
	//constructor for binary number strings
	public BinaryNumber(String str) {
		data= new int[str.length()];
		
		//for loop to iterate through the strings
		for(int i=0; i<str.length();i++){
			
			data[i]= java.lang.Character.getNumericValue(str.charAt(i));			
		}
		//Show new binary number that was created
		System.out.print("New BinaryNumber: " + str.length() + " and String shown " + str);
		//Print statement needed for ease of reading
				System.out.println();
			
		}

	//getLength method
	public int getLength() {
		return data.length;
	}
	
	//getDigit method
	public int getDigit(int index) {
		if(index> data.length) {
		    System.out.println("larger than length of index");
		}
		else {
			return data[index];
		}
		return index;
		    	
	}
	
	
	//to Decimal method to help transform from binary to decimal
	public int toDecimal() {
		double decimalNumber=0;
		//for loop to convert binary to decimal
		for (int i=0; i<data.length; i++) {
			///equation to multiply by power of 2
			decimalNumber= decimalNumber + java.lang.Math.pow(2, i)* data[i];
		}
		System.out.println("Decimal equals to " + decimalNumber);
		return 0;
			
		}
	
	//operation for shifiting all digits in binary to the right
	public void shiftR(int amount) {
		int amountToShift[]= Arrays.copyOf(data,data.length + amount);
		//for loop to shift the digits
		for(int i=0; i>= amount; i++) {
			if(i>amount) {
			amountToShift[i]= data[i-amount];
		}else {
			amountToShift[i]=0;
		}
		}
		//show amount shifted
	for(int i=0;i<amountToShift.length; i++) {
		System.out.print( amountToShift[i]);
	}
		System.out.println();

	}


	public void add(BinaryNumber aBinaryNumber) {
		//global variables for the add function
		int carry=0;
		int result=0;
		int addarray[]= new int[data.length];
		//variables that are global for the program
		//statement to see if the length of Binary number matches
		if(aBinaryNumber.getLength() == data.length) {
			//addition for binary number
			for(int i=0;i<data.length;i++) {
				carry=(aBinaryNumber.getDigit(i)+ data[i]+carry)/2;
				result= (aBinaryNumber.getDigit(i)+data[i] + carry) %2;

				addarray[i]= result;
	
			
			}
			if(carry ==0) {
				for(int i=0; i<data.length; i++) {
					data[i]=addarray[i];
					System.out.println("There is no carry");
				
				}
				System.out.println("Adding both numbers together: " );
				for(int i=0; i<data.length; i++) {
					System.out.print(data[i]);
					
				}
				//
			}else{
				overFlow= true;
				System.out.println("Overlow is apparent");
				}
	
		}else {
			//statement to see if the length of Binary number matches
			if(getLength() != aBinaryNumber.getLength()) {
				System.out.println("aBinary number does not match length");
			}
		}
		}

		

		
	//Transforming a binary to String to String
	 public String toString() {
		 String resultString= "";
		for(int i=0; i<data.length; i++) {
				resultString = resultString + data[i];
			}
			if (overFlow) {
				return "Overflow";
			}
			else {
				return resultString;
			}
		}
	 public void clearOverflow() {
			overFlow= false;
		}
	
//Set operation to clear overflow tag
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Set operation to clear overflow tag
	//First step convert string to Boolean(true/false)
	BinaryNumber stringBinaryNumber= new BinaryNumber("11011");
	//Test to see how digits behaves
	System.out.println("11011 Index of 2 equals " + stringBinaryNumber.getDigit(2));
	//Test and convert toDecimal 
	stringBinaryNumber.toDecimal();
	//shift numbers with shiftR
	stringBinaryNumber.shiftR(2);
	//Length method
	int lengthOfFirstBinary =stringBinaryNumber.getLength();
	System.out.println("The length of the first binary is " + lengthOfFirstBinary);
	
	//Test the add method
	BinaryNumber newBinaryNumber= new BinaryNumber("110111");
	stringBinaryNumber.add(newBinaryNumber);
	stringBinaryNumber.toDecimal();
	System.out.println("After addition the Binary equals " + stringBinaryNumber);
	//Testing the second Binary number
	int lengthOfSecondBinary = newBinaryNumber.getLength();
	System.out.println("The length of new Binary number is " + lengthOfSecondBinary);
	
	//Testing Overflow
	BinaryNumber _newBinaryNumber= new BinaryNumber("10111");
	BinaryNumber newoverflowBinaryNumber = new BinaryNumber("11100");
	
	//adding the new binary numbers together
	_newBinaryNumber.add(newoverflowBinaryNumber);
	String _stringBinaryNumber= _newBinaryNumber.toString();
	System.out.println("String Binary number is: " + _stringBinaryNumber);
	
	//if binary number has an overflow, clears overflow
	_newBinaryNumber.clearOverflow();
	_stringBinaryNumber = _newBinaryNumber.toString();
	System.out.println("New binary after overlows is: " + _stringBinaryNumber);
	//test the getLength method
	int testLength = stringBinaryNumber.getLength();
	System.out.println("Length of first binary number is " + testLength);
	int testNewBinaryNumber = newBinaryNumber.getLength();
	System.out.println("Length of newBinary Number is " + testNewBinaryNumber);
	//Additonal testing digits is 0 since 110111
	System.out.println("Digit 2 of newBinaryNumber is: " + newBinaryNumber.getDigit(2));
	
	
	
	
	
	
	}
}
	


