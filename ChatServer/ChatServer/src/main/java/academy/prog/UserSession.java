package academy.prog;

import jakarta.servlet.http.HttpServletResponse;

import java.util.*;

public class UserSession {

    private static final Map<String, User> userOnline = new HashMap<>();

    public static Map<String, User> getUserOnline() {
        return userOnline;
    }

    public synchronized static boolean setUserLogin(String login) {
        if (userOnline.get(login.toLowerCase()) == null) {
            userOnline.put(login.toLowerCase(), new User(login, true));
            return false;
        }
        return true;
    }

    public synchronized static void updateTime(String login, HttpServletResponse response) {
        if (userOnline.get(login.toLowerCase()) == null) {
            response.setStatus(HttpServletResponse.SC_REQUEST_TIMEOUT);
            return;
        } else
            userOnline.get(login.toLowerCase()).setStatus(true);
    }

    public synchronized static String getOnline() {
        String result = "";
        for (String key : userOnline.keySet()) {
            result += "\n" + userOnline.get(key).getLogin();
        }
        return result;
    }
}

