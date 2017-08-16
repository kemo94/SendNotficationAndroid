package retrofit.kemo.com.sendnotification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kemo94 on 5/11/2017.
 */

public class Notification {


    @SerializedName("body")
    @Expose
    private String body;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("sound")
    @Expose
    private String sound;

    public void setBody(String body) {
        this.body = body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
