const express = require("express");
const fs = require('fs')

let app = express();

app.get('/',(req,res)=>{

    res.send(' <h1>Hello Node <h1>')
})

app.get('/data',(req,res)=>{
  fs.readFile('./jsonData.json',(err,data)=>{
   if(err){
    console.log('erorr')
    throw err;
   }else{
    console.log('response')
     let obj = res.send(JSON.parse(data));
   }

  })

})

app.listen("8000", (err) => {
  if (err) {
    console.log("error");
  }else{
    console.log('server is running')
  }
});
