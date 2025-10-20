package edu.luc.cs.laufer.cs371.shapes

object DebugLogger:
  private val debugEnabled = sys.props.get("shapes.debug").contains("true")
  
  def debug(message: String): Unit =
    if debugEnabled then
      println(s"[debug] $message")

end DebugLogger