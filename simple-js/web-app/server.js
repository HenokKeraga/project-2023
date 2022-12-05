var express= require("express")

var app = express()
app.get('/',function(req,res){
    res.send("<h1> welcome<h1>")
})
app.get("/hi", function (req, res) {
  res.send("<h1> hi<h1>");
});

app.listen(8095,function(err){
    if(err){
        console.log('error')
        throw err
    }else{
        console.log(`server is running at 8095`)

    }

})