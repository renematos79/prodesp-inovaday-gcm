package br.com.prodesp.inovadaygcm;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Random;

public class FbService extends FirebaseMessagingService {
    public FbService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // TODO(developer): Handle FCM messages here.
        // If the application is in the foreground handle both data and notification messages here.
        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
        String body = remoteMessage.getNotification().getBody();

        Log.d("FbService", "From: " + remoteMessage.getFrom());
        Log.d("FbService", "Notification Message Body: " + body);

        NotificacaoProxy.Notificacoes.add(new NotificacaoModel(body));

        Random rand = new Random();
        int pickedNumber = rand.nextInt(1000);

        NotificacaoHelper.createSimpleMessage(this, "Nova mensagem", body, pickedNumber);


    }
}
