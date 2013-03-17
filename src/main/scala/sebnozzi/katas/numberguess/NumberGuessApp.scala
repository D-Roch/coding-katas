package sebnozzi.katas.numberguess

object NumberGuessApp extends App with GameDelegate {

  import sebnozzi.katas.numberguess.Answer

  def nextGuess: Option[Int] = {
    println("Guess a number:")
    val input = Console.in.readLine()
    try {
      Some(Integer.parseInt(input))
    } catch {
      case e: NumberFormatException => None
    }
  }

  def onAnswer(answer: Answer) {
    answer match {
      case Correct => println("Correct! You win")
      case TooLow => println("Try higher")
      case TooHigh => println("Try lower")
    }
  }

  val game = new Game(delegate = this)

  game.playGame

}