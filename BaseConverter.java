//VY NGUYEN
//CSC-236-IN 
//LAB 4-PROGRAM #2
import java.util.Scanner;
public class BaseConverter {
	
	/**Inner class**/
	private class BaseNumber{
		/** Data field */
		private long srcNum; //source number being converted
		private int desBase; //target base the number will be converted in 
		
		/** Constructors*/
		//default constructor
		//Postcondition: default base 10 
		public BaseNumber(){
			srcNum = 0;
			desBase = 10;
		}
		//overloaded constructor
		//Precondition: targetBase value is between 2-9
		//Postcondition: srcNum = sourceNum, desBase = targetBase
		//				if targetBase < 2 or targetBase > 9
		// 				print message 
		public BaseNumber(long sourceNum, int targetBase) throws IllegalArgumentException{
			if(sourceNum < 0 ) throw new IllegalArgumentException("Integer value is non-negative.");
			if (targetBase <2 || targetBase >9) throw new IllegalArgumentException("base value is between 2 and 9");
			srcNum = sourceNum;
			desBase = targetBase;
		}
		
		/**Methods**/
		//return the value of source integer  
		//Precondition: return srcNum
		public long getNumber() {
			return srcNum;
		}
		
		//return the value of base
		//Precondition: return desBase
		public int getBase() {
			return desBase;
		}
		
		//set a new value for source integer 
		//Precondition: newValue is non-negative 
		//Postcondition: srcNum = newValue
		public void setNumber(long newValue) throws IllegalArgumentException{
			if (newValue <0) throw new IllegalArgumentException("The value of integer is non-negative.");
			srcNum = newValue;
		}
		
		//set a new value for desBase
		//Precondition: the value of newBase range between 2-9.
		//Postcondition: desBase = newBase. 
		public void setBase(int newBase) throws IllegalArgumentException{
			if (newBase <2 || newBase >9) throw new IllegalArgumentException("base value is between 2 and 9");
			desBase = newBase;
		}
		
	}//end inner class 
	
	/**Instance variable field of BaseConverter class */
	private BaseNumber[] inputVal; //array of BaseNumber 
	private final int numOfInputs = 3; //maximum number of input 
	
	/**Constructors**/
	//default constructor 
	BaseConverter(){
		inputVal = new BaseNumber[numOfInputs];
	}
	
	/**prompting user to enter input
	 * Precondition: user entered non-negative value and base value between 2 and 9 
	 * Postcondition: save user inputs of long integer and int value of base into sourceNum 
	 * 				and desBase into BaseNumber 
	 * @throws IllegalArgumentException
	 */
	public void inputPrompt() throws IllegalArgumentException{
		int i = 0; //count variable
		Scanner sc = new Scanner(System.in);
		
		while ( i < numOfInputs) {
			System.out.println("Enter an integer number: ");
			long sourceNum = sc.nextLong();
			if(sourceNum < 0) throw new IllegalArgumentException("Integer value is non-negative.");
			
			System.out.println("Enter a base value in range of 2-9: ");
			int desBase = sc.nextInt();
			if (desBase <2 || desBase >9) throw new IllegalArgumentException("Base value is between 2 and 9.");
			inputVal[i] = new BaseNumber(sourceNum, desBase);
			i++;
		}
	}
	
	/** @return the string showing process of converting and the result. 
	 * @param value
	 * Algorithm: 
	 * Create an empty remainder stack 
	 * while sourceNum != 0: keep dividing number by base, each num % base, push remainder to the stack remainder 
	 * To print get the process and result------- 
	 * declare an empty String result
	 * while remainder stack is not empty: 
	 * remove remainder from the top of the stack 
	 * convert remainder to base equipvalent 
	 */
	public String convert(BaseNumber value) {
		long sourceNum = value.getNumber();
		int desBase = value.getBase();
		
		ListStackDataStrucClass<Long> remStack = new ListStackDataStrucClass<>();
		
		//convert and push remainder to the stack 
		while (sourceNum!=0) {
			long rem = sourceNum % desBase;
			remStack.push(rem);
			sourceNum/=desBase;
		}
		//processt of converting and the result 
		String conversion =""; //store the process of converting 
		String result =""; //store the result
	
		while(!remStack.isEmptyStack()){
			result += remStack.peek();
			conversion = conversion + remStack.pop() +  " * " 
					+ value.getBase() + "^" + (remStack.getSize()-1) + " + "; 
			if(remStack.isEmptyStack()) {
				System.out.println();
			}
		}
		
		//return the final string showing converting process and result
		//remove the last "+" sign of final conversion stirng. 
		String concatStr = conversion.substring(0, conversion.length()-2) + " = " + result;
			
		return concatStr;
	}
	
	/** 
	 * @return a string of result 
	 * called convert() method 
	 * Postcondition: the string result contains all results 
	 * 				of converting object BaseNumber in array inputVal.
	 */
	public String convertAll() {
		//intantiate a new String object 
		String result = new String();
		for(int i = 0; i < numOfInputs; i++) {
			result += inputVal[i].getNumber() + " (Base 10) = " + convert(inputVal[i]) +
					" (Base " + inputVal[i].getBase() + ")"
					+ "\n";
		}
		return result;
	}
	
	/**
	 * call inputPrompt and convertAll() method
	 */
	public void processAndPrint() {
		inputPrompt();
		System.out.println(convertAll());
	}
	
	/**
	 * @return a string containing sourceNum and desBase of each BaseNum object.
	 */
	public String toString() {
		String str ="";
		for(int i = 0; i < numOfInputs; i++) {
			str+= inputVal[i].getNumber() + " (Base 10)"
					+ " convert to base " + inputVal[i].getBase()
					+ "\n";
		}
		return str;
	}
	
	
	
	

}
