//VY NGUYEN
//CSC-236-IN
//LAB 4- PROGRAM #2
public class EmptyStackException extends StackException {
	
	public EmptyStackException() {
		super("Empty Stack Exception.");
	}
	
	public EmptyStackException(String msg) {
		super(msg);
	}
}
