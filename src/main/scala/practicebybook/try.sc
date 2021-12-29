import java.util.jar.Attributes.Name

"3".toInt
'a'
//"foo".toInt
"earth".toUpperCase
"earth dkf rt"split(" ")
"abcdef".take(3)
"foo".take(1)
"foo" take(2)
1+2+3
1.+(2).+(3)
6
6.0
6.0f
6L
"the\nusual\tescape characters apply"
"hello"//string
println("hello")//unit
println("a" + 1.toString)
//= println("a"+1)


////-------------------------object------------------
object Test
Test

object Test2 {
  def name: String = "kak"
}
Test2.name

object  Test3 {
  def hello(name: String) = "hello" + name
}// name in this is parameter
Test3.hello("Earthja")

object Test4{
  val name = "Earthhhhh"// val is immunation (cant change)
  var name2 = "earthhhhh" //var can changed value
  def hello2(other: String): String =  name + " hello " + other
}//name is field other is parameter
Test4.hello2("world")

object Test5{
  val simpleField = {
    println("Evaluating simpleField")
    42
  }
  def noParameterMethod = {
    println("Evaluating noParameterMethod")
    42
  }
}
Test5
Test5.simpleField //try 2 time (2nd no println shown )
Test5.noParameterMethod


//task
object Oswald {
  val Colour = "black"
  val Food : String = "Milk"
}
object Henderson{
  val Colour = "Ginger"
  val Food : String = "Chips"
}
object Quentin {
  val Colour = "white"
  val Food : String = "Curry"
}

//task2
object calc {
  def square(x: Double) = x * x
  def cube(x: Double) = x * square(x)
}
calc.square(2)

//task3
object calc2 {
  def square(value: Double) = value * value
  def cube(value: Double) = value * square(value)
//overload (samename but diff parameter)
  def square(value: Int) = value * value
  def cube(value: Int) = value * square(value)
}
calc2.square(2)
calc2.square(2.0)
//val x : Int = calc2.square(2.0) this one is error
val x : Int = calc2.square(2.0).toInt





////----------------order of eval------------
object argh {
  def a = {
    println("a")
    1
  }

  val b = {
    println("b")
    a + 2
  }

  def c = {
    println("c")
    a
    b + "c"
  }
}
argh.c + argh.b + argh.a

//----------------------------------------
object person{
  val firstname = "seth "
    val lastname = "sud"
}
object alien{
  def greet(p: person.type )  =
    "greeting, " + p.firstname + p.lastname
}
alien.greet(person)
//person.type is singleton type only for person object

////-----------------test-----------------------
def square (in: Double) : Double = in*in//in*in

assert(square(2.0) == 4.0)
assert(square(-2.0)==4.0)
//assert(square(4)==10) run this test will failure



////-----------------conditional----------------
if(1>2) "yes" else "no"
if(1>2) println("yes") else println("no")



////---------------------blocks----------------
//{expression}
def name: String = {
  val title = "Professor"
  val name = "Funkenstein"
  title + " " + name
}
name

if(1 > 2) "alien" else "predator"
if(1 > 2) "alien" else 2001
if(false) "hello"








//-------------------------------
//next chapper
//class make many object

class personC {
  val firstN = "Noel"
  val LastN = "Vvvvv"
  def nameC = firstN + "" + LastN

}
// personC no object created because this is class
// object1 created by class
val person1 = new personC
person1.firstN
// object2 created by class
val person2 = new personC

//--------alien call person that made by class---
object alien {
  def greet(p: personC) =
    "Greetings, " + p.firstN + " " + p.LastN
}
alien.greet(person1)
alien.greet(person2)




////--------constructor-------------------------
//As it stands our Person class is rather useless:
// we can create as many new objects as we want but they all have the same firstName and lastName. What if we want to give each person a different name?
class personC(first: String, last: String) {// overload class same name but not parameter
  val firstName = first
  val lastName = last
  def name = firstName + " " + lastName
}
//same with
//class personC(val firstName: String, val lastName: String) {
//  def name = firstName + " " + lastName
//}

val dave = new personC("Dave", "Gurnell")
dave.name


////---------default keyword parameter-------------
def greet(title: String = "Citizen", firstName: String = "Some", lastName: String = "Body") =
  "Greetings, " + title + " " + firstName + " " + lastName + "!"

greet("Busy") // this is now incorrect
// res10: String = Greetings, Busy Some Body!

greet(firstName = "Busy") // this is still correct
// res11: String = Greetings, Citizen Busy Body!

////---------------scala type hierachy--------------
def badness = throw new Exception("Error")
// badness: Nothing

def otherbadness = null
// otherbadness: Null

val bar = if(true) 123 else badness
// bar: Int = 123

val baz = if(false) "it worked" else otherbadness
// baz: String = null


//// excercise for class -----------------------------
class Cat(val colour: String, val food: String)

val oswald = new Cat("Black", "Milk")
val henderson = new Cat("Ginger", "Chips")
val quentin = new Cat("Tabby and white", "Curry")

//ex2 return true if cat like chips
object chipshop{
  //class is type same as (singleton: object.type) -> put in method(*type) like (cat:Cat) next line
  def willserve(cat: Cat) = {
    if (cat.food == "Chips" ) true else false
  }
}
chipshop.willserve(oswald)
chipshop.willserve(henderson)


////directorial debut --------------------------------
class Director(val firstname: String, val lastname: String, val yearofbirth: Int){
  def name: String =
    s"$firstname $lastname"
}
class Film (val name: String,val yearofrelease: Int,val imdbrating:Double, val director: Director) {
  def directorage = yearofrelease - director.yearofbirth

  def isDirectedBy(director: Director) =
    this.director == director
}

val eastwood          = new Director("Clint", "Eastwood", 1930)
val mcTiernan         = new Director("John", "McTiernan", 1951)
val nolan             = new Director("Christopher", "Nolan", 1970)
val someBody          = new Director("Just", "Some Body", 1990)

val memento           = new Film("Memento", 2000, 8.5, nolan)
val darkKnight        = new Film("Dark Knight", 2008, 9.0, nolan)
val inception         = new Film("Inception", 2010, 8.8, nolan)

val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
val outlawJoseyWales  = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
val unforgiven        = new Film("Unforgiven", 1992, 8.3, eastwood)
val granTorino        = new Film("Gran Torino", 2008, 8.2, eastwood)
val invictus          = new Film("Invictus", 2009, 7.4, eastwood)

val predator          = new Film("Predator", 1987, 7.9, mcTiernan)
val dieHard           = new Film("Die Hard", 1988, 8.3, mcTiernan)
val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)
eastwood.yearofbirth
dieHard.director.name
invictus.isDirectedBy(nolan)
memento.directorage