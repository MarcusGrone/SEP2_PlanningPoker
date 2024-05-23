package Model.Main;

import DataTypes.PlanningPoker;
import DataTypes.User;
import DataTypes.UserRoles.Role;
import DataTypes.UserRoles.UserRole;
import Networking.ClientConnection_RMI;
import Networking.ServerConnection_RMI;
import Networking.Server_RMI;
import Util.PropertyChangeSubject;

import java.util.ArrayList;
import java.util.Map;

public interface MainServerModel extends PropertyChangeSubject
{

  /**
   * Validates the existence of a Planning Poker game with the specified ID.
   * @param planningPokerID the ID of the Planning Poker game to validate.
   * @return true if the game exists, false otherwise.
   */
  boolean validatePlanningPoker(int planningPokerID);
  PlanningPoker createPlanningPoker();

  /**
   * Retrieves the Planning Poker game with the specified ID.
   * @param planningPokerId the ID of the Planning Poker game to retrieve.
   * @return the PlanningPoker object if found, null otherwise.
   */
  PlanningPoker getPlanningPokerGame(int planningPokerId);

  /** Retrieves all saved planning poker session from the database and saves them in the model*/
  void getAllPlanningPokersFromDb();
  User applyPlanningPokerRole(UserRole role, User user, int planningPokerId);
  void broadcastPlanningPokerObjUpdate(Map<Integer, ArrayList<ClientConnection_RMI>> clientList, ServerConnection_RMI server, int planningPokerId);

  /** Sets the product owner for the users planning poker session
   * @param user the user that is intended to become product owner
   * @param connectedClients all the clients that are connected to the server
   * @param serverRmi the server which has received the request*/
  void setProductOwner(User user, ArrayList<ClientConnection_RMI> connectedClients, Server_RMI serverRmi);
  boolean removeUserFromGame(User user, int planningPokerId);
  void verifyConnectedUsersIntegrity(Map<Integer, ArrayList<ClientConnection_RMI>> clientList, ServerConnection_RMI server, int planningPokerId);
}
