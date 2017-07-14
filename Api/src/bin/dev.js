const port = 21099;
const debug = require("debug")("apigcm:bin:dev");
// carrega a aplicaçao
var app = require('../config/app');
app.set('port', port);
debug("listening to the port => ", port);
app.listen(app.get('port'), function() {
    debug('Node app is running on port', app.get('port'));
});