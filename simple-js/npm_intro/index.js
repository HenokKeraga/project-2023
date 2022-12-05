var url = require("url");
var util = require("util");
var os = require("os");
var date=require('./date.js')

var urlAddress = "http://localhost:8080/user?year=2022";

var parse_url = url.parse(urlAddress, true);

console.log(parse_url);

console.log(parse_url.host);
console.log(util.format(" %s hello", "henok"));

console.log(os.arch());
console.log(os.platform());
console.log(os.cpus().length);
console.log(os.hostname());
console.log(date())
