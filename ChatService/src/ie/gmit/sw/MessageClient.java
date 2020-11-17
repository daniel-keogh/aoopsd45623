package ie.gmit.sw;

import java.io.*;
import java.net.*;
import java.util.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
public class MessageClient extends Application{
	private int listenPort = 9998;
	private String clientIP;
	private String remoteHost;
	private int remotePort;
	private ServerSocket ss = null;
	private TextArea txtConversation = null;

	@Override
    public void start(Stage stage) throws Exception {
		//Build a tree of nodes to create the GUI
		stage.setTitle("Message Client");
		stage.setWidth(500);
		stage.setHeight(300);
		stage.setOnCloseRequest((e) -> System.exit(0)); //Kill the VM when window is closed
		
		//VBox is a Layout (a Concrete Strategy) and the Scene object is the Context.
		VBox box = new VBox();
		box.setPadding(new Insets(10));
	    box.setSpacing(8);
		Scene scene = new Scene(box, 500, 300);
		stage.setScene(scene);
		
		txtConversation = new TextArea(); //The "chat" is displayed in a text area
		txtConversation.setEditable(false); //Editing disabled
		
		TextField txtMessage = new TextField(); //Text field for a message
		
		/* Calling setOnAction() tells FX to register the EventHandler 
		 * observer (the lambda) to be notified when btnSendis clicked. 
		 * The FX event dispatch manager calls actionPerformed() when
		 * this event occurs. In this case, handle(ActionEvent ae) opens 
		 * a socket to the chat server and sends a serialized MessageRequest 
		 * containing the new message. 
		 */
		Button btnSend = new Button("Send Message");
		btnSend.setOnAction(e -> { //Plant an observer with the event dispatch mameger
        	try (ObjectOutputStream out = new ObjectOutputStream(new Socket(remoteHost, remotePort).getOutputStream())){
				out.writeObject(new MessageRequestImpl(System.getProperty("user.name"), txtMessage.getText()));
        	}catch(Exception ex){
        		ex.printStackTrace();
        	}
        	txtMessage.clear();
		});
		
		//Build the tree of nodes to form the GUI
		box.getChildren().add(txtConversation);
		box.getChildren().add(txtMessage);
		box.getChildren().add(btnSend);
		
		//Display the window
		stage.show();
		stage.centerOnScreen();
		
		//Initialise the observer
		List<String> params = getParameters().getRaw(); 
		this.clientIP = params.get(0); //Hard-coding ordinal is not good...
		this.remoteHost = params.get(1); 
		this.remotePort = Integer.parseInt(params.get(2));
		initConnections();
		System.out.println("[INFO] Client ready...");
	}

	
	public void initConnections() throws Exception {
		initListener();
		registerObserver();
	}
	
	//Start a socket on the client to listen for push notifications from the service 
	private void initListener() throws Exception {
		listenPort = getRandomPort();
		ss = new ServerSocket(listenPort);
		ClientListener listener = new ClientListener();
		listener.start();
	}

	
	//Open a socket to the chat server and register as an observer
	private void registerObserver() throws Exception {
		try(ObjectOutputStream out = new ObjectOutputStream(new Socket(remoteHost, remotePort).getOutputStream())) {
			out.writeObject(new MessageObserverImpl(System.getProperty("user.name"), clientIP, listenPort));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//Update the text pane with incoming message
	private void updateDisplay(MessageRequest request) {
		 StringBuilder sb = new StringBuilder(); 
		 sb.append(txtConversation.getText());
		 sb.append("\n" + request.getName() + ">" + request.getMessage());
		 txtConversation.setText(sb.toString());
	}

	
	/*
	 * The client application needs to open a sock in order to listen for incoming
	 * message updates from the chat server. The client host name and port number
	 * and encapsulated in a MessageObserver instance that the constructor created
	 * and registers as an observer.
	 */
	class ClientListener extends Thread {
		public void run() {
			System.out.println("[INFO] Listener started");
			while (true) {				
				try(ObjectInputStream oin = new ObjectInputStream(ss.accept().getInputStream())) {
					if (oin.readObject() instanceof MessageRequest request) {
						updateDisplay(request);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public int getRandomPort() {
		int max = 9998; int min = 9000;
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	public static void main(String[] args) {
		String[] params = {"127.0.0.1", "127.0.0.1", "9999"};
		Application.launch(params); //Can read in String[] args to a Stage
	}
}