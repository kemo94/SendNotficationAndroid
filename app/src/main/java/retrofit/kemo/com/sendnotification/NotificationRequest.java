package retrofit.kemo.com.sendnotification;

 import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by as on 5/11/2017.
 */

public class NotificationRequest {

    @SerializedName("to")
    @Expose
    private String to;

    @SerializedName("notification")
    @Expose
    private Notification notification;

    public void setTo(String to) {
        this.to = to;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
