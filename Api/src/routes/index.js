const debug = require("debug")("apigcm:routes");
const express = require("express");
const router = express.Router();

// rotas para check usando controller
router.use('/api/check', require('../api/check/checkService'));

// rotas para gcm usando controller
router.use('/api/gcm', require('../api/gcm/gcmService'));


module.exports = router;