package ie.gmit.sw;

/*
 * The invoker holds a command object and calls the execute method
 */
import java.io.*;
import java.net.*;
public class Invoker implements Runnable{ 
	private Socket s = null;
	
	public Invoker(Socket sock){
		this.s = sock;
	}
	
	public void run(){
		//Deserialize the socket input stream into a MessageCommand
		try(ObjectInputStream in = new ObjectInputStream(s.getInputStream())){
			/* Assign a receiver to the command object and call execute()
			 * By encapsulating the request in a command object, we
			 * dispense with the need to have IF/instanceof statements here.
			 * The command approach encapsulates the change that an 
			 * invoker would otherwise have to deal with. 
			 */
			if (in.readObject() instanceof MessageCommand cmd) {
				cmd.setReceiver(MessageBoard.getInstance()); //Set the receiver. This should be done by the client, but not in client-server mode
				cmd.execute(); //Execute the command method. Note that the invoker does not know what this does...
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}