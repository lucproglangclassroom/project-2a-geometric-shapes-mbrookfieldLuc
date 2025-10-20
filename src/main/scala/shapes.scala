package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Ellipse(w, h) | Location(x, y, Shape) | Group(Shape*) */
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  case Ellipse(width: Int, height: Int)
  case Location(x: Int, y: Int, shape: Shape)
  case Group(shapes: Shape*)

object Shape:
  def rectangle(width: Int, height: Int): Rectangle =
    require(width > 0, "rectangle width must be positive")
    require(height > 0, "rectangle height must be positive")
    Rectangle(width, height)
  
  def ellipse(width: Int, height: Int): Ellipse =
    require(width > 0, "ellipse width must be positive")
    require(height > 0, "ellipse height must be positive")
    Ellipse(width, height)
