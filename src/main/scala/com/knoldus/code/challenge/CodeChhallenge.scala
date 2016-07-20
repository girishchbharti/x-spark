package com.knoldus.code.challenge

/**
 * Created by knoldus on 19/7/16.
 */
object CodeChhallenge extends App{

  val distance = FrogAndJumps.distance(11)
  println(s"TOTAL DISTANCE COVERED: $distance")

  val grapdParents = GrandParents.grandParents(Map("A" -> Set("B", "C"), "F" -> Set("B"), "B" -> Set("D", "E")))

  println(s"LIST OF GRAND PARENTS: $grapdParents")
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
  def distance(attempts: Int): Int = if(attempts >= 0){distance(attempts - 1) +  (((attempts % 3) + 1) * 5 )}else{0}
}


object GrandParents{

  /**
   * Given in input that has relationships between a person and their children, for all the people in this data, identify grandparents of all the people in the input.
   *
   * Input: A map of all the people and their children
   * Map[String, Set[String]]
   *
   * Output: A map of all people and their grandparents
   * Map[String, Set[String]]
   *
   * Example:
   * Input
   * Map("A" -> Set("B", "C"), "B" -> Set("D"))
   *
   * Output:
   * Map("D"->Set("A"))
   */
  def grandParents(family: Map[String, Set[String]]): Map[String, Iterable[String]] = {
    family.keys.flatMap { grandParent =>
      family.get(grandParent).getOrElse(Set.empty).flatMap { parent =>
        family.get(parent).getOrElse(Set.empty).map { child => (child, grandParent)}
      }
    }.groupBy(_._1).map { case (k,v) => (k,v.map(_._2))}
  }

}