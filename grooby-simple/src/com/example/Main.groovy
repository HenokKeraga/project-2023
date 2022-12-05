package com.example


void main() {
    def courses = ["A", "B", "C"]
    courses.each { println(it) }
}

main()
println("hello")

class Person {
    String name
    Integer age

    Person(name) {
        this.name = name;
    }

    def increaseAge(Integer i) {
        this.age += i
    }
    def useClosure(Closure c){
        c.delegate=this;
        c()
    }
}

def p1= new Person("sol")


p1.useClosure {
    println(name)
}

