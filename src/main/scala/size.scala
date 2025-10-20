package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object size:
  def apply(s: Shape): Int = 
    DebugLogger.debug(s"computing size for: $s")
    val result = s match
      case Rectangle(_, _) => 1  // rectangles count as 1
      case Ellipse(_, _) => 1    // ellipses count as 1
      case Location(_, _, shape) => apply(shape)  // locations don't add to count
      case Group(shapes*) => shapes.map(apply).sum  // add up all the shapes inside
    DebugLogger.debug(s"size result: $result")
    result

end size