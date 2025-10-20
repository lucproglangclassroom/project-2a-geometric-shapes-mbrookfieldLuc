package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object scale:
  def apply(factor: Double)(s: Shape): Shape = 
    DebugLogger.debug(s"scaling by factor $factor: $s")
    val result = s match
      case Rectangle(width, height) => 
        Rectangle((width * factor).toInt, (height * factor).toInt)
      
      case Ellipse(width, height) => 
        Ellipse((width * factor).toInt, (height * factor).toInt)
      
      case Location(x, y, shape) => 
        Location((x * factor).toInt, (y * factor).toInt, apply(factor)(shape))
      
      case Group(shapes*) => 
        Group(shapes.map(apply(factor))*)
    DebugLogger.debug(s"scale result: $result")
    result

end scale