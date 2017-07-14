"use strict";

var debug = require("debug")("apigcm:util:notification");
var proxy = require("../util/network");

function notification(config){
    this.config = config;
}

notification.prototype.push = function(topic, data) {
    var url = this.config.gcm().url;
    var header = {
        "Content-Type": "application/json",
        "Authorization": "key=" + this.config.firebase().serverKey
    };
    var body = {
        "to": "/topics/" + topic,
        "message_id": this.config.firebase().senderId,
        "notification": data
    };
    debug("Sending message to => ", url, topic, header, body);
    return proxy.post(url, header, body);
};

module.exports = function(config){
    return new notification(config);
}