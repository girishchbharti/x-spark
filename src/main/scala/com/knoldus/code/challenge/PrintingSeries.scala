package com.knoldus.code.challenge

import scala.collection.immutable.{IndexedSeq, List}

/**
 * Created by knoldus on 25/7/16.
 */
object PrintingSeriesExamples extends App with PrintingSeries{

  println("\n\n\n\n")

  /*val result1 = seriesOne(3, List(1,2,3,4))
  println("Result1: ", result1)


  val result2 = filterArray(3, List(10, 9, 8, 2, 7, 5, 1, 3, 0))
  println("Result 2: ", result2)

  val result3 = filterByPosition(List(10, 9, 8, 2, 7, 5, 1, 3, 0))
  println("Result 2: ", result3)

  val actualtArr = List(10, 9, 8, 2, 7, 5, 1, 3, 0)
  val result4 = reverseArr(actualtArr)
  println(s"ACTUAL ARR: $actualtArr \nREVERSED ARR: $result4")

  val arr = List(-17 -8, 2, -4, 20, 25, 0, -21, -29, 9, 9, 3, 16, 2, -29, -27, 17, 25, -7, 7, -18, -27, 18, -4, -4, 28, 11, -21, -17,
  27)
  val result = sumOfOddElements(arr)
  println("RESULT>...................", result)

  val arr = List(1,2,3,4,5,6)
  val result = listLength(arr)
  println(s"ARRY: $arr\nTOTAL COUNT: $result")


  val arr = List(1,2,-2,-1,4,5,6)
  val res = absoluteValue(arr)
  println("RESULT: ", res)*/

 /* val res = camelCaseCounter()

  println("Res...........", res)
 */

  pangram
}


trait PrintingSeries{

  /**
   * The output has the computed values of  corresponding to each test case. They are correct up to  decimal places and on separate lines.
   * @param x
   * @return
   */
  def eX(x: Float):Float ={

    def fact(f: Int): Int={if(f > 0){fact(f - 1) * f}else{f}}

    def sqrt(i: Float, j: Int): Float={
      if(j > 0){
        sqrt(i, j -1) * i
      }else{
        i
      }
    }

    def exF(x: Float, i: Int = 0): Float={
      if(x == 1){
        exF(x, i + 1) + (1)
      }else if(1 > 1 && i <= 10){
        exF(x, i + 1) + (sqrt(x, i) / fact(i))
      }else{
        x
      }
    }

    exF(x)
  }

  def pangram ={

    val line = scala.io.Source.stdin.getLines().next()
    if(line.length < 26){
      println("not pangram")
    }else{
      List.range(97, 123).map{ alphabet =>
        if(line.contains(alphabet.toChar)){
          true
        }else{
          println("not pangram")
        }
      }
    }

  }

  def camelCaseCounter ={
    val line = scala.io.Source.stdin.getLines().next()
    val lineArr = line.toArray
    if(lineArr.length <= 0){ 0 }else {
      List.range(0, lineArr.length).map { index =>
        if (lineArr(index).isUpper) {1} else {0}
      }.sum + 1
    }

  }

  def absoluteValue(arr:List[Int]):List[Int] ={
    arr.map(element => if(element < 0) (-element) else element)
  }

  def listLength(args: List[Int]): Int = {
    def count(arr: List[Int], index: Int = 0): Int = {
      if(!arr.isEmpty){
        count(arr.tail, index + 1)
      }else{
        index
      }
    }
    count(args)
  }

  def counter(args: Array[String]): Int = {
    def count(arr: Array[String], index: Int = 0): Int = {
      if(!arr.isEmpty){
        count(arr.tail, index + 1)
      }else{
       index
      }
    }
    count(args)
  }


  /**
   * Printing series
   * Input:
   * 3, List(1,2,3,4)
   * Output:
   * List(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4)
   *
   * @param num
   * @param list
   * @return
   */
  def seriesOne(num: Int, list: List[Int]): List[Int] = {list.flatMap{ elem => List.range(0,num).map{ num => elem}}}


  /**
   * Filter a given array of integers and output only those values that are less than a specified value .
   * The output integers should be in the same sequence as they were in the input. You need to write a function
   * with the recommended method signature for the languages mentioned below. For the rest of the languages,
   * you have to write a complete code.
   *
   * @param delim
   * @param arr
   * @return
   */
  def filterArray(delim:Int, arr:List[Int]): List[Int] = {
    arr.flatMap { elem =>
      if(elem < delim) Some(elem) else{ None}
    }
  }

  /**
   * For a given list with  N integers, return a new list removing the elements at odd positions.
   * The input and output portions will be handled automatically.
   * You need to write a function with the recommended method signature.
   */
  def filterByPosition(arr:List[Int]):List[Int] = {
    List.range(0, arr.size).flatMap{ elem =>
      if(elem % 2 == 1){
        Some(arr(elem))
      }else{
        None
      }
    }
  }

  /**
   * You are given a list of  elements. Reverse the list without using the reverse function. The input and output portions
   * will be handled automatically. You need to write a function with the recommended method signature.
   * @param arr
   * @return
   */
  def reverseArr(arr:List[Int]):List[Int] = {
    def rev(list: List[Int]): List[Int] = {
      if(list.isEmpty){ Nil }else{List((list.head)).:::(rev(list.tail))}
    }
    rev(arr)
  }


  /**
   * You are given a list. Return the sum of odd elements from the given list. The input and output portions
   * will be handled automatically. You need to write a function with the recommended method signature.
   */
  def sumOfOddElements(arr:List[Int]): Int={
    List.range(0, arr.size).flatMap{ elem =>
      if(arr(elem) % 2 == 1 || arr(elem) % 2 == -1){
        Some(arr(elem))
      }else{
        None
      }
    }.sum
  }

}