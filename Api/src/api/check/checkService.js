var express = require("express");
var router = express.Router();
var controller = require("./checkController")();

router.get('/ping', controller.ping.bind(controller));
router.get('/version', controller.version.bind(controller));

module.exports = router;