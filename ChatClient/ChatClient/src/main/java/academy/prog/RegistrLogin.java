package academy.prog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegistrLogin {

    public RegistrLogin() {
    }

    public static boolean loginCheck(String login) throws IOException {
        URL url = new URL(Utils.getURL() + "/reglogin?user_login=" + login);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();

        try (var bf = new BufferedReader(new InputStreamReader(http.getInputStream()))) {
            String error;
            while ((error = bf.readLine()) != null) {
                if (error != null) {
                    System.out.println(error);
                    return true;
                }
            }
        }
        return false;
    }
}
