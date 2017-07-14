var express = require("express");
var router = express.Router();
var controller = require("./gcmController")();

router.post('/notify', controller.notify.bind(controller));

module.exports = router;