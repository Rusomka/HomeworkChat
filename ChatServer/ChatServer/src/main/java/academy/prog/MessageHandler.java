package academy.prog;

public class MessageHandler {

    public static void formatMessage(Message msg) {

        if (msg.getText().startsWith("@") && msg.getText().length() >= 3) {

            String result = msg.getText().replace("@", "");
            String[] t = result.trim().split("[ |,]", 2);
            if (t.length >= 2) {
                msg.setTo(t[0]);
                msg.setText(t[1]);
            } else
                msg.setTo(t[0]);
        } else if (msg.getText().trim().equalsIgnoreCase("/online")) {
            msg.setTo(msg.getFrom());
            msg.setFrom("SERVER");
            msg.setText(UserSession.getOnline());
        } else
            msg.setTo("All");
    }
}
