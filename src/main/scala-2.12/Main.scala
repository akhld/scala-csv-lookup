import scala.io.Source

/**
  * Created by akhld on 17/12/16.
  */

object Main extends Utils{

  def main(args: Array[String]): Unit = {

    val stream  = getClass.getResourceAsStream("/persons.csv")

     memInfo()

    val person = Person(surname = "Zannes", fname = "Dave", suburb = "CORNUBIA", surveyorType = "Surveyor")

    val simpleMap = new FastUtilBasedMap(stream)

    println("Memory usage: " + memInfo())

    println(time(simpleMap.lookup(person)))

  }

}

case class Person(surname: String, fname: String, suburb: String, surveyorType: String)

