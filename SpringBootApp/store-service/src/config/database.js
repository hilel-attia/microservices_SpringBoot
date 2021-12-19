
const mongoose = require("mongoose");



exports.connect = () => {
  // Connecting to the database
  mongoose
    .connect("mongodb+srv://omar:test123@marketplacecluster.e3vzt.mongodb.net/myFirstDatabase?retryWrites=true&w=majority", {
      useNewUrlParser: true,
      useUnifiedTopology: true
    })
    .then(() => {
      console.log("Connected To DB Successfully!");
    })
    .catch((error) => {
      console.log("database connection failed. exiting now...");
      console.error(error);
      process.exit(1);
    });
};