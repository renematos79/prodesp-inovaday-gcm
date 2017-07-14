var debug = require("debug")("apigcm:checkController");
var pkg = require("../../../package.json");

function checkController(){
    debug("controller check carregado => ", pkg.name)
}

checkController.prototype.ping = function(request, response, next){
    response.send("PONG");
}

checkController.prototype.version = function(request, response, next){
    response.json({
        "application-name": pkg.name,
        "application-version": pkg.version,
        "application-description": pkg.description,
    });
};

module.exports = function(){
    return new checkController();
};