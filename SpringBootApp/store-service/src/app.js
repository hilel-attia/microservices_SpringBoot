const express = require("express");
const Store = require("./models/store");
const app = express();
const bodyParser = require("body-parser");

app.use(bodyParser.json());

app.get("/", (req, res) => {
  res.json({ msg: "stors MS Work!" });
});

app.get("/api/stores", async (req, res) => {
  const stores = await Store.find({});
  res.json(stores);
});
app.get("/api/store/:id", async (req, res) => {
  const stores = await Store.findOne({_id:req.params.id});
  res.json(stores);
});
app.post("/api/store", async (req, res) => {
  const store = new Store({ name: req.body.name ,address: req.body.address});
  const savedBook = await store.save();
  res.json(savedBook);
});
app.delete("/api/store", async (req, res) => {
  const savedBook = await Store.deleteOne({_id:req.params.id});
  res.json(savedBook);
});
module.exports = app;
