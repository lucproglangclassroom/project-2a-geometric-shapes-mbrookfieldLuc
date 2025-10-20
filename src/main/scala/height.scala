package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object height:
  def apply(s: Shape): Int = 
    DebugLogger.debug(s"computing height for: $s")
    val result = s match
      case Rectangle(_, _) => 1  // base shapes have height 1
      case Ellipse(_, _) => 1    // base shapes have height 1
      case Location(_, _, shape) => 1 + apply(shape)  // location adds 1 level
      case Group(shapes*) => 
        if shapes.isEmpty then 1  // empty group still has height 1
        else 1 + shapes.map(apply).max  // 1 plus the tallest child
    DebugLogger.debug(s"height result: $result")
    result

end height