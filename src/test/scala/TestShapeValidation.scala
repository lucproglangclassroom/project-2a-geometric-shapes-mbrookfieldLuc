package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import Shape.*

class TestShapeValidation extends AnyFunSuite:

  test("Rectangle with positive dimensions should be valid"):
    val rect = Rectangle(10, 20)
    rect match
      case Rectangle(w, h) =>
        assert(w == 10)
        assert(h == 20)
      case _ => fail("Expected Rectangle")

  test("Rectangle with zero width should throw exception"):
    assertThrows[IllegalArgumentException]:
      Shape.rectangle(0, 10)

  test("Rectangle with negative width should throw exception"):
    assertThrows[IllegalArgumentException]:
      Shape.rectangle(-5, 10)

  test("Rectangle with zero height should throw exception"):
    assertThrows[IllegalArgumentException]:
      Shape.rectangle(10, 0)

  test("Rectangle with negative height should throw exception"):
    assertThrows[IllegalArgumentException]:
      Shape.rectangle(10, -5)

  test("Ellipse with positive dimensions should be valid"):
    val ellipse = Ellipse(15, 25)
    ellipse match
      case Ellipse(w, h) =>
        assert(w == 15)
        assert(h == 25)
      case _ => fail("Expected Ellipse")

  test("Ellipse with zero width should throw exception"):
    assertThrows[IllegalArgumentException]:
      Shape.ellipse(0, 15)

  test("Ellipse with negative width should throw exception"):
    assertThrows[IllegalArgumentException]:
      Shape.ellipse(-3, 15)

  test("Ellipse with zero height should throw exception"):
    assertThrows[IllegalArgumentException]:
      Shape.ellipse(15, 0)

  test("Ellipse with negative height should throw exception"):
    assertThrows[IllegalArgumentException]:
      Shape.ellipse(15, -3)

end TestShapeValidation