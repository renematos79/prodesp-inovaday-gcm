function config(){}

config.prototype.firebase = function(){
    return {
        senderId: "982637523000",
        serverKey : "AIzaSyDe8_dupKqe3prMnR0YXPQzVycnaUCgeUo"
    };
};

config.prototype.gcm = function(){
    return {
        url: "https://fcm.googleapis.com/fcm/send"
    }
};

module.exports = new config();