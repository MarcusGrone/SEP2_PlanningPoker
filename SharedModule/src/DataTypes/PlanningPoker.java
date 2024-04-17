package DataTypes;

import DataTypes.States.PlanningPokerState;

import java.util.ArrayList;

public class PlanningPoker
{
    private String connectionCode;
    private ArrayList<User> connectedUsers;
    private PlanningPokerState currentState;
    private Chat chat;
    public PlanningPoker()
    {
        connectedUsers = new ArrayList<>();
        chat = new Chat();
    }

    public Chat getChat() {
        return chat;
    }

    public void setCurrentState(PlanningPokerState planningPokerState)
    {
        this.currentState = planningPokerState;
    }

    public PlanningPokerState getCurrentState(
        PlanningPokerState planningPokerState)
    {
        return planningPokerState;
    }

    public void declareFinalEffort(Task task)
    {

    }
}