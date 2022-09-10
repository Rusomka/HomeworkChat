package academy.prog;


import java.util.Timer;
import java.util.TimerTask;

public class User {
    private String login;
    private boolean status;
    private MessageList msgList = MessageList.getInstance();

    public User() {
    }

    public User(String login, boolean status) {
        this.login = login;
        this.status = status;
        offLine(login);
    }

    public void offLine(String login) {
        new Timer(true).schedule(new TimerTask() {
            @Override
            public void run() {
                if (UserSession.getUserOnline().get(login.toLowerCase()).isStatus() == false) {
                    UserSession.getUserOnline().remove(login.toLowerCase());
                    msgList.clearMessages(login);
                    this.cancel();
                } else {
                    UserSession.getUserOnline().get(login.toLowerCase()).setStatus(false);
                }
            }
        }, 500, 5000);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", status=" + status +
                '}';
    }
}
