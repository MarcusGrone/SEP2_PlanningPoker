package Model.Chat;

import DataTypes.User;
import Networking.ClientConnection_RMI;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChatServerModelImpl implements ChatServerModel, Runnable
{
  private PropertyChangeSupport propertyChangeSupport;
  private static ChatServerModel instance;
  private static final Lock lock = new ReentrantLock();



  private ChatServerModelImpl()
  {
    //TODO
  }

  public static ChatServerModel getInstance()
  {
    //Here we use the "Double-checked lock" principle to ensure proper synchronization.
    if(instance == null)
    {
      synchronized (lock)
      {
        if(instance == null)
        {
          instance = new ChatServerModelImpl();
        }
      }
    }
    return instance;
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

  @Override public void run()
  {
    //TODO
  }

  @Override
  public void receiveAndBroadcastMessage(String message, User sender, ArrayList<ClientConnection_RMI> connectedClients) {
    /*ArrayList<User> usersToReceive = sender.getPlanningPoker().getConnectedUsers();

    for (ClientConnection_RMI client : connectedClients)
    {
      for (User user : usersToReceive)
      {
        try
        {
          if (client.getCurrentUser().equals(user))
          {
            client.receiveMessage(message);
            break;
          }
        }
      }
    }*/
  }


}
