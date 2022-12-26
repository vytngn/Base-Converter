//VY NGUYEN
//CSC-236-IN
//LAB 4 - PROGRAM #2
public class ListStackDataStrucClass<T> implements ListStackADT<T> {
	
	/**inner class**/
	//definition of the node
	private class ListNode<T>{
		public T info;
		public ListNode<T> link;
	
		/**Constructors**/
		//Default constructor 
		public ListNode() {
			info = null;
			link = null;
		}
		//Arg-constructor 
		public ListNode(T initInfo, ListNode<T> initLink) {
			info = initInfo;
			link = initLink;
		}
		//Copy constructor 
		public ListNode(ListNode<T> initNode) {
			info = initNode.info;
			link = initNode.link;
		}
		
		/**Methods**/
		//getValue
		public T getValue() {
			return info;
		}
		//getNext
		public ListNode<T> getNext(){
			return link;
		}
		//setValue
		public void setValue(T newValue) {
			info = newValue;
		}
		//setNext
		public void setNext(ListNode<T> newNext) {
			link = newNext;
		}
	}//end inner method 

	/** instance variable for ListStackDataStructureClass **/
	private ListNode<T> stackTop;
	
	/**Constructors for ListStackDataStructureClass **/
	//default constructor 
	//Postcondition: stackTop points to null
	public ListStackDataStrucClass() {
		stackTop = null;
	}
	//arg-constructor 
	//Postcondition: stackTop points to initNode 
	public ListStackDataStrucClass(ListNode<T> initNode) {
		stackTop = initNode;
	}
	//copy-constructor 
	//Precondition: the otherStack is not empty 
	//Postcondition: shallow copy otherStack into this stack. 
	public ListStackDataStrucClass(ListStackDataStrucClass<T> otherStack) {
		stackTop = null;
		otherStack.ifEmpty();
		while(!otherStack.isEmptyStack()) {
			ListNode<T> current = otherStack.stackTop;
			//get the last value of stack
			while(current.getNext() != null) {
				current = current.getNext();
			}
		//create a new node & copy current node to newNode
		ListNode<T> newNode = new ListNode<T>(current.getValue(), this.stackTop);
		current = null;
		stackTop = newNode;
		}
				
	}
	
	/** Methods **/
	@Override
	//check whether the stack is empty
	//Postcondition: return true if stackTop is null,
	//				otherwise return false.
	public boolean isEmptyStack() {
		return stackTop == null;
	}
	
	/**
	 * throw exception if the stack is empty
	 * @throws EmptyStackException
	 */
	public void ifEmpty() throws EmptyStackException{
		if(isEmptyStack()) throw new EmptyStackException("The stack is empty.");
	}
	
	@Override
	/** @return false **/
	public boolean isFullStack() {
		return false;
	}
	
	/** @return the top node of the stack 
	 **Precondition: the stack is not empty 
	 **Postcondition: the top node of the stack is returned. 
	 */
	public ListNode<T> getTop() throws EmptyStackException{	
		if(isEmptyStack()) throw new EmptyStackException("The stack is empty.");
		return  this.stackTop;
	}

	/** point stackTop to a node 
	 *Postcondition: stackTop points to newTop
	 */
	public void setTop(ListNode<T> newTop) {
		stackTop = newTop;
	}
	
	@Override
	/** adding an object to the stack 
	 *Postcondition: if the stack is empty, push newItem to the stack 
	 *			point stackTop to newItem
	 */
	public void push(T newItem) {
		if(isEmptyStack()) {
			ListNode<T> newNode = new ListNode<T>(newItem, null);
			setTop(newNode);
		}else {
		//create a new node 
			ListNode<T> newNode  = new ListNode<T>(newItem, getTop());
			setTop(newNode); //point stackTop to the new node 
		}	
	}

	@Override
	/** @return the top element of the stack. 
	 *Postcondition: return the value of the top element of the stack. 
	 */
	public T peek() throws EmptyStackException{
		if(isEmptyStack()) throw new EmptyStackException("The stack is empty.");
		return getTop().getValue();
	}

	@Override
	/**remove the top element of the stack 
	 * Postcondition: @return the value of the deleted element. 
	 */
	public T pop() throws EmptyStackException{
		if(isEmptyStack()) throw new EmptyStackException("The stack is empty.");
		else {
			T returnValue = getTop().getValue();
			setTop(getTop().getNext());
		return returnValue;
		}
		
	}
	
	/**
	 * @return the size of the stack 
	 */
	public int getSize() {
		int size = 1;
		ListNode<T> current = stackTop;
		while(current != null) {
			size++;
			current = current.getNext();
		}
		return size;
	}
	
	@Override 
	/**
	 * @return the string of each node.
	 */
	public String toString() {
		String str ="";
		if(!isEmptyStack()) {
			ListNode<T> current = stackTop;
			
			//traverse the stack 
			while(current !=null) {
			str = str + current.getValue() + " ";
			current = current.getNext();
			}
		}
		return str;
		
	}


}
