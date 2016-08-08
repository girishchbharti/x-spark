package com.knoldus.code.challenge

/**
 * Created by knoldus on 20/7/16.
 */
object GrandParentsApp extends App{

  val distance = FrogAndJumps.distance(11)

  println(s"TOTAL DISTANCE COVERED: $distance")

  val grapdParents = GrandParents.grandParents(Map("A" -> Set("B", "C"), "F" -> Set("B"), "B" -> Set("D", "E")))

  println(s"LIST OF GRAND PARENTS: $grapdParents")
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