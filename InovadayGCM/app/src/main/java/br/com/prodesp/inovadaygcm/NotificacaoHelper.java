package br.com.prodesp.inovadaygcm;

/**
 * Created by root on 26/10/16.
 */

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;

/**
 * Created by renat on 10/02/2016.
 */
public class NotificacaoHelper {

    public static PendingIntent createPendingIntent(Context ctx, String message, int id){
        Intent intent = new Intent(ctx, NotificacaoActivity.class);
        intent.putExtra(NotificacaoActivity.NOTIFY_EXTRA_MESSAGE, message);
        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(ctx);
        taskStackBuilder.addParentStack(NotificacaoActivity.class);
        taskStackBuilder.addNextIntent(intent);
        return taskStackBuilder.getPendingIntent(id, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    public static void createSimpleMessage(Context ctx, String title, String message, int id){
        PendingIntent pendingIntent = createPendingIntent(ctx, message, id);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(ctx)
                .setDefaults(Notification.DEFAULT_ALL)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(pendingIntent);
        NotificationManagerCompat nm = NotificationManagerCompat.from(ctx);
        nm.notify(id, builder.build());
    }

}
