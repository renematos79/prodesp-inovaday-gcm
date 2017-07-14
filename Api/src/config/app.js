var express = require("express");
var methodOverride = require("method-override");
var bodyParser = require("body-parser");
var app = express();

// cors
const allowCors = require('./cors')
app.use(methodOverride('X-HTTP-Method'));
app.use(methodOverride('X-HTTP-Method-Override'));
app.use(methodOverride('X-Method-Override'));
app.use(methodOverride('_method'));
app.use(allowCors);


// body parser
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));
app.use(function(req, resp, next){
    if (req.url === "/favicon.ico"){
        resp.writeHead(200, {'Content-Type': 'image/x-icon'});
        resp.end('');
    } else {
        next();
    }
});

// mapeamento das rotas
var routes = require('./../routes/index');
app.use('/', routes);

// controle de erros, page not found
app.use(function(req, resp, next){
    var err = new Error('Not Found');
    err.status = 404;
    next(err);
});

app.use(function(err, req, resp, next){
    resp.status(err.status || 500).json({
        status: err.status,
        message : err.message
    });
});

// listener
module.exports = app;