package es.example.ale.swapi;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ServicioNotificacion extends JobIntentService {

    private static final int JOB_ID = 7;
    private static final int NOTIFICATION_ID = 9001;

    public static void start(Context context){
        Intent intet = new Intent(context,ServicioNotificacion.class);
        enqueueWork(context,ServicioNotificacion.class,JOB_ID,intet);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        NotificationCompat.Builder notif = new NotificationCompat.Builder(this,"Default Notification Channel");
        notif.setSmallIcon(R.drawable.ic_star_black_24dp).setContentTitle("Nombre obtenido").setContentText("Toma").setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS).setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID,notif.build());
    }
}
