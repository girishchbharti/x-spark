package com.knoldus.code.challenge

/**
 * Created by knoldus on 19/7/16.
 */
object FrogAndJumpsApp extends App{
  val distance = FrogAndJumps.distance(11)
  println(s"TOTAL DISTANCE COVERED: $distance")
}

/**
 * This class contain a function to calculate the distance covered by a frog
 * CONDOTIONS:
 * A frog hops in his
 * 1st attempt-5 mt.
 * 2nd attempt-10 mt.
 * 3rd attempt-20 mt.
 *
 * Write an algo to count the total number of distance covered by frog on the basis of user input attempts.
 * for eg.
 * INPUT- 11
 * OUTPUT- 120 mt
 */
object FrogAndJumps{

  def distance(attempts: Int): Int = {
    def cover(attempt: Int): Int={if(attempt >= 0){cover(attempt - 1) + (if((attempt % 3) > 0)((2 * (attempt % 3) * 5))else(5))}else{0}}
    cover(attempts - 1)
  }
}
