package ie.gmit.sw;

/* MessageRequest, like MessageObserver, is encapsulated in the 
 * command object (MessageCommand). When the invoker calls 
 * execute() on the command object, the receiver updates all
 * observers with the new message. Note: all implementations of this 
 * interface are serializable.
 */
import java.io.*;
public interface MessageRequest extends Serializable{
	public String getName();
	public void setMessage(String message);
	public String getMessage();	
}
