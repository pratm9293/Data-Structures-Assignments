
public interface Stack<AnyType> {

	
	/*
	 * @return size of the active stack.
	 */
	public int size();
	
	/*
	 * @return true/false depending on whether stack is empty or not
	 */
	public boolean isEmpty();
	
	public void push(AnyType x);
	/*
	 * @return the element at the top
	 */
	public AnyType pop();
	public AnyType top();
}
