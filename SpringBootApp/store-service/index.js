const app = require("./src/app");
require("./src/config/database").connect();
const PORT = process.env.PORT || 3000;
const eurekaHelper = require('./eureka-helper');


app.listen(PORT, () => {
    console.log("running on port 3000");
    console.log("--------------------------");
  });
  eurekaHelper.registerWithEureka('store-service', PORT);
