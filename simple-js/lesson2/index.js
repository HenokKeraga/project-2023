//read json file
// write json file

var fs = require("fs");

fs.readFile("./jsonData.json", (err, data) => {
  if (err) {
    console.log("error");
  } else {
    
    let out = JSON.parse(data);

    console.log(out);
  }
});

let jData = [
  {
    color: "red",
    value: "#f00",
  },
  {
    color: "green",
    value: "#0f0",
  },
  {
    color: "blue",
    value: "#00f",
  },
  {
    color: "cyan",
    value: "#0ff",
  },
  {
    color: "magenta",
    value: "#f0f",
  },
  {
    color: "yellow",
    value: "#ff0",
  },
  {
    color: "black",
    value: "#000",
  },
];

let jString = JSON.stringify(jData);

fs.writeFile("./jsonData2.json", jString, (err) => {
  if (err) {
    console.log("error");
  } else {
    console.log("written ");
  }
});
