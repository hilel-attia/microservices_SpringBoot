const mongoose = require("mongoose");
const Schema = mongoose.Schema;

const StoretSchema = new Schema({
    name:{type:"string",require:[true,'required field']},
    address:{type:"string",require:[true,'required field']}

 
});

module.exports = mongoose.model("Store", StoretSchema);
