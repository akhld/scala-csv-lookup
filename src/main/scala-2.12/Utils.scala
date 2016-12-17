/**
  * Created by akhld on 17/12/16.
  */
class Utils {

  //Thanks to SO
  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }

  def memInfo(): String ={
    System.gc()
    val mem = Runtime.getRuntime.totalMemory() - Runtime.getRuntime.freeMemory()
    (  mem / 1024.0 / 1024.0 + " MB")
  }

}
