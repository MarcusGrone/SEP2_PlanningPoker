package Views.GameView;

import Application.ViewModelFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.rmi.RemoteException;

public class GameViewController
{
  @FXML public StackPane effortWrapper;
  @FXML public HBox placedCardsWrapper;
  @FXML private Button clearCardsButton;
  @FXML private Button showCardsButton;
  @FXML private Button setEffortButton;
  @FXML private Button skipButton;
  @FXML private Label taskHeaderLabel;
  @FXML private Label taskDescLabel;
  @FXML private ChoiceBox finalEffortDropdown;
  @FXML private Label finalEffortLabel;
  private GameViewModel gameViewModel;

  public GameViewController() throws RemoteException
  {
    this.gameViewModel = ViewModelFactory.getInstance().getGameViewModel();
    Platform.runLater(this::initialize);
  }

  public void initialize()
  {
    applyBindings();
    gameViewModel.setPlacedCardsWrapper(placedCardsWrapper);
    gameViewModel.setSkipButtonRef(skipButton);
    gameViewModel.setEffortButtonRef(setEffortButton);
    gameViewModel.setFinalEffortDropdownRef(finalEffortDropdown);
    gameViewModel.setClearCardsButtonRef(clearCardsButton);
    gameViewModel.setShowCardsButtonRef(showCardsButton);
    gameViewModel.setGameStarted(false);
    gameViewModel.refresh();
    showPlayingCards();
    finalEffortDropdown();
  }

  private void applyBindings()
  {
    taskHeaderLabel.textProperty().bindBidirectional(gameViewModel.taskHeaderPropertyProperty());
    taskDescLabel.textProperty().bindBidirectional(gameViewModel.taskDescPropertyProperty());
    finalEffortLabel.textProperty().bindBidirectional(gameViewModel.finalEffortLabelProperty());
  }

  public void onGameStart() {
    gameViewModel.setGameStarted(true);
  }

  public void onsetEffortButtonPressed()
  {
    String effortValue = (String) finalEffortDropdown.getValue();
    gameViewModel.setFinalEffortLabel(effortValue);
  }

  public void onSkipEffortButtonPressed()
  {
    gameViewModel.skipTask();
  }

  public void showPlayingCards()
  {
    gameViewModel.getPossiblePlayingCards(effortWrapper);
  }

  public void onClearCardsButtonPressed()
  {
    gameViewModel.requestClearPlacedCards();
  }

  public void onShowCardsButtonPressed()
  {
    gameViewModel.requestShowCards();
  }

  public void finalEffortDropdown()
  {
    finalEffortDropdown.setItems(gameViewModel.getEffortObserverList());
  }


}
