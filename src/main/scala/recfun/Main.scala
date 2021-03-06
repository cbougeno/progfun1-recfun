package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c.equals(0)) 1
    else if (c >= r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def iterationBalance(chars: List[Char], countParenthesis: Int): Boolean = {
      if (chars.isEmpty) countParenthesis equals 0
      else {
        val iter =
          if (chars.head equals '(') countParenthesis + 1
          else if (chars.head equals ')') countParenthesis - 1
          else countParenthesis

        if (iter >= 0) iterationBalance(chars.tail, iter)
        else false
      }
    }

    iterationBalance(chars, 0)
  }

  /**
    * Exercise 3. The exchange possibilities for a certain money with a few coins is like
    * the new possibility of money with the highest coin next to that of the money immediately
    * above with all the coins
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0)
      0
    else if (coins.isEmpty)
      if (money == 0) 1 else 0
    else
      countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
}
