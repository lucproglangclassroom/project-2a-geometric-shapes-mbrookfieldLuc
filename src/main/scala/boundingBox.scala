package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = 
    DebugLogger.debug(s"computing bounding box for: $s")
    s match
      case Rectangle(width, height) =>
        DebugLogger.debug(s"rectangle: ${width}x${height}")
        Location(0, 0, Rectangle(width, height))
      
      case Ellipse(width, height) =>
        DebugLogger.debug(s"ellipse: ${width}x${height}")
        // ellipse params are radii, so bounding box goes from -width to +width
        Location(-width, -height, Rectangle(2 * width, 2 * height))
      
      case Location(x, y, shape) =>
        DebugLogger.debug(s"location: (${x}, ${y})")
        // just move the inner shape's bounding box
        val Location(dx, dy, rect) = apply(shape)
        val Rectangle(w, h) = rect: @unchecked
        Location(x + dx, y + dy, Rectangle(w, h))
      
      case Group(shapes*) =>
        DebugLogger.debug(s"group with ${shapes.length} shapes")
        if shapes.isEmpty then
          Location(0, 0, Rectangle(0, 0))
        else
          // find the box that contains all child boxes
          val boxes = shapes.map(apply)
          
          val coords = boxes.foldLeft((Int.MaxValue, Int.MaxValue, Int.MinValue, Int.MinValue)) {
            case ((minX, minY, maxX, maxY), Location(x, y, rect)) =>
              val Rectangle(w, h) = rect: @unchecked
              (minX min x, minY min y, maxX max (x + w), maxY max (y + h))
          }
          
          val (leftMost, topMost, rightMost, bottomMost) = coords
          Location(leftMost, topMost, Rectangle(rightMost - leftMost, bottomMost - topMost))

end boundingBox
