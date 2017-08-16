package retrofit.kemo.com.sendnotification;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created. by kemo94 on 7/4/2017.
 */

public class API {
    public static final String BASE_URL = "https://fcm.googleapis.com/fcm/";
    public static final String SERVER_KEY = "key=" + YOUR_FIREBASE_SERVER_KEY;

    public static void sendNotification(String token) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setTo(token);

        Notification notification = new Notification();
        notification.setBody("hi");
        notification.setTitle("New Notification");
        notification.setSound("mySound");

        notificationRequest.setNotification(notification);


        final SendNotificationApi retroInterface = retrofit.create(SendNotificationApi.class);
        Call<MessageResponse> call = retroInterface.sendNotification(SERVER_KEY,notificationRequest);

        call.enqueue(new Callback<MessageResponse>() {
            @Override
            public void onResponse(Call<MessageResponse> call, final Response<MessageResponse> response) {
                Log.d("RetrofitResponse",response.code()+"");

            }

            @Override
            public void onFailure(Call<MessageResponse> call, Throwable t) {
                Log.e("RetrofitFailure",t.toString());
            }
        });
    }

    public interface SendNotificationApi {

        @POST("send")
        Call<MessageResponse> sendNotification(@Header("Authorization") String serverKey,
                                               @Body NotificationRequest notificationRequest);
    }

}