package com.example.kotlin_app.activities

//class LibraryClass {
//}

open class LibraryClass{
    var x: Int = 0

    fun setMyX(x_: Int){
        x = x_
    }
}


//open class LibraryClass{
//    var x: Int = 0
//
//    fun setMyX(x_: Int){
//        x = x_
//    }
//}

interface MyInterface{
    var y: Int
    var z: Int
    var abc: Int

    fun myMethod(y_: Int){
        y = y_
        z = y*y
    }
}

open class InheritanceTest: LibraryClass(), MyInterface {
    override var y: Int = 0
    override var z: Int = 0
    override var abc: Int = 0

    fun print() {
        println("My values: $x, $y, $z")
    }
}