package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMessage extends Remote {

	public String message() throws RemoteException;

}