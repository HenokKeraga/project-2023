let fs = require("fs");

// fs.open("./../data.txt", "r+", function (err, fd) {
//   if (err) {
//     console.log('errro open')
//   } else {
//     console.log(fd);
//     fs.readFile(fd,'utf-8',function(error,fileData){
//       if(error){
//         console.log(error)
//       }else{
//         console.log(fileData)
//       }

//     })
//     let reads = fs.createReadStream("./../data.txt");
//     reads.on('data',function(chunk){
//         console.log(chunk.toString())
//     })
//   }
// });

// fs.writeFile("./../data.txt", "henok love", function (err) {
//   if (err) {
//     console.log("error");
//   }
// });

// fs.appendFile("./../data.txt", " henok love", function (err) {
//   if (err) {
//     console.log("error");
//   }
// });

// fs.rename('./../data.txt','./../data2.txt',function(err){
//     if(err){
//         console.log('error')
//     }
// })

// fs.unlink("./../data.txt", function(err){
//     if(err){
//         console.log('error')
//     }

// })
fs.stat("./../data.txt", function (err, stats) {
  if (err) {
    console.log("error");
  } else {
    console.log(stats);
    console.log(stats.isDirectory());
  }
});
