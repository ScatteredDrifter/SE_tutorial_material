// this file was written and provided by jiribenes 
// 

import scala.io.Source

// You can find the original task in the file ./ORIGINAL_TASK.md

enum AdsPayOff {
  case Yes, No

  override def toString: String =
    this match {
      case Yes => "YES ADS"
      case No => "NO ADS"
    }
}

case class Product(profitWithAds: Int, profitWithoutAds: Int, priceOfAds: Int) {
  def payOff: AdsPayOff = {
    val pureProfitWithAds = profitWithAds - priceOfAds
    if (pureProfitWithAds < profitWithoutAds) {
      AdsPayOff.No
    } else {
      AdsPayOff.Yes
    }
  }
}

object Product {
  def fromString(line: String): Option[Product] = {
    val productPrices: Array[String] = line.split(" ")

    try {
      val profitWithAds = productPrices(0).toInt
      val profitWithoutAds = productPrices(1).toInt
      val priceOfAds = productPrices(2).toInt
      return Some(Product(profitWithAds, profitWithoutAds, priceOfAds))
    } catch {
      case _: Exception => return None
    }
  }
}

case class InvalidInputException(message: String) extends Exception(message)

def loadInput(input: List[String]): List[Product] = {
  var products = List[Product]()
  var loadedT = false

  input.foreach { line =>
    if (!loadedT) {
      // ignore, we never use it anyways ;)
      loadedT = true
    } else {
      val product = Product.fromString(line)
      product match
        case Some(value) => products = products.appended(value)
        case None => throw InvalidInputException(s"Error while parsing product: $line")
    }
  }

  products
}

@main
def main() = {
  val filename = "examples/input.txt"
  val input = Source.fromFile(filename).getLines().toList

  try {
    val products = loadInput(input)
    products.foreach { product =>
      println(product.payOff)
    }
  } catch {
    case e: InvalidInputException => println(e.getMessage())
  }
}
