//VY NGUYEN
//CSC-236-IN
//LAB4-PROGRAM #2
public interface ListStackADT <T> {
			
	//Method to determine whether the stack is empty 
	//Postcondition: Returns true if the stack is empty,
	// 					otherwise, returns false.
	public boolean isEmptyStack();
			
	//Method to dethermine whether the stack is full
	//Postcondition: Returns true if the stack is full,
	// 				otherwise, return false
	public boolean isFullStack();
		    
	//Method to add newItem to the stack
	//Precondition: The stack exists and is not full
	//Postcondition: The stack is changed and newItem is added to the top of the stack.
	// 				If stack is full, throws StackOverflowexception. 
	public void push(T newItem) throws FullStackException;
			
	//Method to return the top element of the stack
	//Precondition: The stack exists and is not empty.
	//Postcondition: If the stack is empty, throws StackUnderflowException,
	//				otherwise, return the reference to the top element of the stack. 
	public T peek() throws EmptyStackException;
				
	//Method to remove the top element of the stack.
	//Precondition: The stack exists and is not empty 
	//Postcondition: The top element is removed from the stack,
	//				position of the top element is changed,
	//				If the stack is empty, throws StackUnderflowException. 
	public T pop() throws EmptyStackException;
	
	//Method return a string of object.
	//Postcondition: a string describing object is returned.
	public String toString();
	

}
