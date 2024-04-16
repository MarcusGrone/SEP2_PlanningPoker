package Model.Chat;

import Application.ClientFactory;
import Networking.Client_RMI;
import Util.PropertyChangeSubject;
import javafx.application.Platform;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;

public class ChatModelImpl implements ChatModel, PropertyChangeSubject
{
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

  private Client_RMI clientConnection;



  /** Primary constructor. Defers most of the declarations and definitions to the init method,
   * which is run inside a Platform.runLater statement for increased thread safety while using javaFx. */
  public ChatModelImpl() {
    //Assign the network connection:
    try
    {
      clientConnection = (Client_RMI) ClientFactory.getInstance().getClient();
    }
    catch (RemoteException e)
    {
      //TODO: Properly handle this error!
      e.printStackTrace();
    }

    //Initialize remaining data:
    Platform.runLater(this::init);
  }



  @Override public void init()
  {
    //TODO Initialize relevant data that might affect the javaFx thread here.


    //Assign all PropertyChangeListeners:
    this.assignListeners();
  }



  /** Assigns all the required listeners to the clientConnection allowing for Observable behavior betweeen these classes. */
  private void assignListeners()
  {
    //TODO define the listeners that should be added to the Client here.

    //Example:
    clientConnection.addPropertyChangeListener("DataChanged", evt -> {
      System.out.println("This is an example");});
    //End of example
  }



  @Override public void addPropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }
  @Override public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(name, listener);
  }
  @Override public void removePropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.removePropertyChangeListener(listener);
  }
  @Override public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
    propertyChangeSupport.removePropertyChangeListener(name, listener);
  }
}
