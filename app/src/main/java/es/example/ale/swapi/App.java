package es.example.ale.swapi;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.constraintlayout.widget.ConstraintLayout;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        createChannel();
    }

    private void createChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationChannel defaultChannel = new NotificationChannel("Default Notification Channel","Default Notification Channel",NotificationManager.IMPORTANCE_DEFAULT);
            defaultChannel.setDescription("Default Notification Channel");
        }
    }

}
