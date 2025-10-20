package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite

import TestFixtures.*
import Shape.*

class TestScale extends AnyFunSuite:

  def testScale(description: String, s: Shape, factor: Double, expected: Shape): Unit =
    test(description):
      val result = scale(factor)(s)
      assert(result == expected)

  testScale("simple rectangle scale 2", simpleRectangle, 2.0, Rectangle(160, 240))
  testScale("simple ellipse scale 0.5", simpleEllipse, 0.5, Ellipse(25, 15))
  testScale("simple location scale 1.5", simpleLocation, 1.5, Location(105, 45, Rectangle(120, 180)))
  testScale("basic group scale 2", basicGroup, 2.0, Group(Ellipse(100, 60), Rectangle(40, 80)))
  testScale("empty group scale 3", Group(), 3.0, Group())
  
  test("scale factor 1 should preserve shape"):
    val result = scale(1.0)(complexGroup)
    assert(result == complexGroup)

end TestScale