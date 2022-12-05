//console.log("data input " + process.argv[2]);

// let firstValue = Number.parseInt(process.argv[2])
// let operator = process.argv[3]
// let secondValue = Number.parseInt(process.argv[4])

// if(operator == '+'){
//     console.log(firstValue+secondValue)
// }
var jsoD= {
    name:'edu',
    id:12
}
let jsonS= JSON.stringify(jsoD)
console.log(jsonS)


let obj= JSON.parse(jsonS)

console.log(obj)

