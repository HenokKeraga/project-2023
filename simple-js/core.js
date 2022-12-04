var fs = require("fs");
var path = require("path");
var http = require("http");
var Buffer = require("buffer");
var util = require("util");
var date = require('./date.js')
// fs.writeFileSync('data.txt','test is test')
// let c='/Users/henokkeraga/Documents/project-2023/project-2023/simple-js/data.txt';
// console.log(path.basename(c))
// console.log(path.dirname(c));
// console.log(path.extname(c))
// console.log(path.isAbsolute(c))

//files , path , http

let startServer = http.createServer(function (req, res) {
//   let s = util.format("this is testsdfsdf response %s", henok);
  res.writeHead(200, { "content-type": "text/plain" });
  res.write('henok '+date());
  // let bf= Buffer.from('asd')
  //    res.write(bf)
  res.end();
});

startServer.listen(3000, "localhost", function () {
  console.log("server is running at http://localhost:3000");
});
