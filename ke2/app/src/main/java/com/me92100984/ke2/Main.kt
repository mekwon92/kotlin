package com.me92100984.ke2

//class Main {
//}
fun main() {
    // val(불변), var(가변)

    var num1:Int= 5;
    var num2 = 10;
    var num3 = num1 + num2;
    var num4:Byte; //타입추론을 할수있도록 자료형이라도 지정해줘야함(type assign)

    println("Hello, world!!!")
    println(num3);

    if(num1 > num2) {
        println("num1")
    }
    else {
        println("num2")
    }

    // when: switch와 비슷하지만 결과를 할당할수 있고 조건식 작성이 가능함
    when(num1) {
        5 -> println("value 5");
        10 -> println("value 10");
        //default처럼
        else -> println("invalid value")
    }

    // 결과할당
    var result = when(num3) {
        10 -> "value is 10"
        15 -> "value is 15"
        else -> "unknown"
    }

    println(result);

//    case1:, case2:
    val day = "화";
    when(day) {
        "월","화","수","목","금" -> println("weekday")
        "토","일" -> println("weekend")
    }

    // 범위 조건
    // score = 85
    // A, B, C

    //IF
    val score = 90;
    if(score >= 90) {
        println("A")
    }
    else if( score >= 80) {
        println("B")
    }
    else {
        println("C")
    }

    //WHEN
    when(score) {
        in 90..100 -> println("A")
        in 80..89 -> println("B")
        else -> println("C");
    }

    //IS -> 타입체크(true or false)
    println(score is Int);
    var value:Any = "hello";

    result = when(value) {
        is String -> "I'm string"
        is Char -> "I'm char"
        is Double -> "I'm double"
        else -> "unknown"
    }
    println(result)

    // odd, even
    when {
        num1 % 2 == 1 -> println("odd")
        else -> println("even")
    }
    println(getGrade(95))

    for(x in 2..9){
            println("===${x}단===")
        for(y in 2..9)
            println("${x} * ${y} = ${x * y}")
    }

    //list immutable: java의 new ArrayList(Stream.of(...).toList())
    mutableListOf(1,2,3,"ac");

    //array
    val numbers = arrayOf(1,2,3,4,5)
    val numbers2 = Array(5) { 0 }

    for(x in numbers) {
        println(x)
    }

    println(numbers2.joinToString())

    //기본 자료형 대상의 함수
    doubleArrayOf()
    intArrayOf()

    // array -> index
    println(numbers[2])
    println(numbers.size)

    // numbers의 값 내부 변경
    // 1번 인덱스의 값을 10으로
    numbers.set(1, 10)
    // 3번 인덱스의 값을 20으로
    numbers.set(3, 20)
    // 변경 후 출력
    numbers.forEach { i -> println(i) };

    for ((i, value ) in numbers.withIndex()) {
        println("index : ${i}, value : ${value}")
    }

    println(numbers.sortedArray().joinToString())
    println(numbers.sortedArrayDescending().joinToString())

    //배열은 println 시 주소가 나오고 리스트는 [] 안에 값이 나옴;
    // map, sum
    println(numbers.map { i -> i * i }.toIntArray()) //map { it * it } 이런식으로 사용
    numbers.map { i -> i * i }.forEach{ i -> println(i) };
    println(numbers.sum());

    val animal = Animal("곰", 3);
    val person = Person("saeddong",12);
    person.age = 30;
    person.name = "poopoo";

    println(animal)
    println(person)
    person.info()

    val student = Student(1, "kd");
    println(student) //data 저장목적으로 사용 -> toString, equals, hashcode 자동생성됨

    //object -> 단일객체로 인식 -> DI를 위한 준비물
    Obj.c++;
    println(Obj.c)
    Obj.c++;
    println(Obj.c)

    // 익명함수?
    val a = fun() { println("hello a") }
    a()

    // Unit -> 반환타입이 없음.
    val b: () -> Unit = { println("hello b") }
    b()

    // 반환타입이 있는 경우
    val c : (Int) -> Int = { it * it }
    println(c(5))

    val d : (Int, Int) -> Int = {a, b -> a + b}
    println(d(3, 4))
}

fun getGrade(score:Int): String = when(score) {
    in 90..100 -> "A"
    in 80..89 -> "B"
    else -> "C"
}

class Animal (
    var name: String,
    var count:Int
)

//상속하기위해 open
open class Person {
    var name:String = ""
    var age = 0

    constructor(name:String, age:Int) {
        this.name = name
        this.age = age
    }

    init {
        //초기화 블록

    }

    fun info() {
        println("name : ${name} age : ${age}")
    }
}

// data, object
data class Student (val no:Int, val name: String)

// singleton을 하기위한 목적
object Obj {
    var c = 0;
}

