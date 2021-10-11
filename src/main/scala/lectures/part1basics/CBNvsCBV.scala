package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + 1257387745764245L)
    println("by value: " + 1257387745764245L)
  }
// x: long -> call by value -> value is computed before call 
// same value used everywhere
  def calledByName(x: => Long): Unit = {
    println("by name: " + System.nanoTime())
    println("by name: " + System.nanoTime())
  }
// x=> long -> call by name -> this is the expression (value that can compute) , so the expression is passed literally
// expression is evaluated at every use with in
  calledByValue(1257387745764245L)
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int ) = println(x)
  //test
// if change y=> to y: it will stack overflow because there valued is computed and die 
// this can be run with call by name because y is not called cause expression is not passed by 
  //  printFirst(infinite(), 34) // stack overflow
  printFirst(34, infinite())
}
