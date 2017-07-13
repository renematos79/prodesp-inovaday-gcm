package br.com.prodesp.inovadaygcm;

import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by root on 25/10/16.
 */

public class FbTopic {

    public void Subscribe(String topicName){
        FirebaseMessaging.getInstance().subscribeToTopic(topicName);
    }

}
