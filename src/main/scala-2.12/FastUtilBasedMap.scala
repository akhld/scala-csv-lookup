import java.io.InputStream

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap

import scala.io.Source

/**
  * Created by akhld on 17/12/16.
  */
class FastUtilBasedMap(stream: InputStream){

    private var map = Source.fromInputStream(stream, "ISO-8859-1").getLines().flatMap(line => {

    //a little hack since the data I'm using isn't very clean
    val list = line.split(",").toList
    val endorsement = if(list.size > 4 ) list(4) else "Associate"

    //Compute a hash of the keys
    val hash = s"${list(0)}${list(1)}${list(2)}${list(3)}".toLowerCase.hashCode
    Map(hash -> endorsement)

  }).toMap

  private val holder = new Int2ObjectOpenHashMap[String](map.unzip._1.toArray, map.unzip._2.toArray)

  map = null

  def lookup(data: Person): String ={
    val hash = s"${data.surname}${data.fname}${data.suburb}${data.surveyorType}".toLowerCase.hashCode
    holder.get(hash)
  }

}
