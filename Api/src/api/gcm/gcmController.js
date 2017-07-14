var debug = require("debug")("apigcm:gcmController");
var pkg = require("../../../package.json");
// cloud messaging notification service
var config = require("../../config/config");
var notification = require("../../util/notification")(config);

function gcmController(){
    debug("controller check carregado => ", pkg.name)
}

gcmController.prototype.notify = function(request, response, next){
    var _topic = request.body.topic;
    var _message = {text: request.body.message};
    debug("params => TOPIC: ", _topic, " MESSAGE: ", _message);

    notification.push(_topic, _message)
        .then(function(result){
            response.status(201);
            response.json({
                message : "mensagem enviada com sucesso!",
                data : {
                    topic : _topic,
                    message : _message
                }
            });
        })
        .catch(function(result){
            response.status(400);
            response.json({
                error : result,
                data : {
                    topic : _topic,
                    message : _message
                }
            });
        });
}

module.exports = function(){
    return new gcmController();
};