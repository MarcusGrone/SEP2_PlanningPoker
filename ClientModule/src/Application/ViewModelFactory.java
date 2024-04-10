package Application;

import Views.LoginView.LoginViewModel;
import Views.MainView.MainViewModel;

import java.rmi.RemoteException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ViewModelFactory {
    private static ViewModelFactory instance;
    private final static Lock lock = new ReentrantLock();
    private ModelFactory modelFactory;
    private LoginViewModel loginViewModel;
    private MainViewModel mainViewModel;

    private ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public static ViewModelFactory getInstance(ModelFactory modelFactory) {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new ViewModelFactory(modelFactory);
                }
            }
        }

        return instance;
    }

    public LoginViewModel getLoginViewModel() throws RemoteException {
        if (loginViewModel == null) {
            loginViewModel = new LoginViewModel(modelFactory.getClientModel());
        }

        return loginViewModel;
    }

    public MainViewModel getMainViewModel() throws RemoteException {
        if (mainViewModel == null) {
            mainViewModel = new MainViewModel(modelFactory.getClientModel());
        }

        return mainViewModel;
    }

}