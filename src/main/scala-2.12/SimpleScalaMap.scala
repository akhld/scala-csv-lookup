import java.io.InputStream

import scala.io.Source

/**
  * Created by akhld on 17/12/16.
  */
class SimpleScalaMap(stream: InputStream){

  //Read the file line by line and keep it in a  Map[ String, Map[String, Map[String, Map[ String, String]]]]
  private val holder = Source.fromInputStream(stream, "ISO-8859-1").getLines().flatMap(line => {

    //a little hack since the data I'm using isn't very clean
    val list = line.split(",").toList
    val endorsement = if(list.size > 4 ) list(4) else "Associate"

    Map(list(0) -> Map(list(1) -> Map(list(2) -> Map(list(3) -> endorsement))))

  }).toMap

  def lookup(data: Person): String ={
    holder(data.surname)(data.fname)(data.suburb)(data.surveyorType)
  }

}
