# Scala

## Day 1: The Castle on the Hill

### Find

* The Scala API
    * [Scala API](http://www.scala-lang.org/node/216)

* A comparison of Java and Scala
    * [Scala Features with reference to Java](http://en.wikipedia.org/wiki/Scala_(programming_language)#Features_.28with_reference_to_Java.29)
    * [A Scala Tutorial for Java Programmers](http://www.scala-lang.org/docu/files/ScalaTutorial.pdf)
    * [Java 8 vs Scala](http://www.infoq.com/articles/java-8-vs-scala)
    * [Roundup: Scala for Java Refugees](http://www.codecommit.com/blog/scala/roundup-scala-for-java-refugees)
    * [The busy Java developer's guide to Scala: Functional programming for the object oriented](http://www.ibm.com/developerworks/java/library/j-scala01228/index.html)
    * [Scala vs. Groovy vs. Clojure](http://stackoverflow.com/questions/1314732/scala-vs-groovy-vs-clojure)
    * [Samples of Scala and Java code where Scala code looks simpler/has fewer lines?](http://stackoverflow.com/questions/2952732/samples-of-scala-and-java-code-where-scala-code-looks-simpler-has-fewer-lines)
    * [Scala: A Scalable Language](http://www.artima.com/scalazine/articles/scalable-language.html)

* A discussion of val versus var
    * [What is the difference between a var and val definition in Scala?](http://stackoverflow.com/questions/1791408/what-is-the-difference-between-a-var-and-val-definition-in-scala)

### Do

* Write a game that will take a tic-tac-toe board with X, O, and blank characters and detect the winner or whether there is a tie or no winner yet. Use classes where appropriate.

* Bonus problem: Let two players play tic-tac-toe.

---

## Day 2: Clipping Bushes and Other New Tricks

### Find

* A discussion on how to use Scala files

[Getting Started with Scala](http://www.scala-lang.org/node/166)
[StackOverflow: Read entire file in Scala?](http://stackoverflow.com/questions/1284423/read-entire-file-in-scala)
[StackOverflow: Load Scala file into interpreter to use functions?](http://stackoverflow.com/questions/7383436/load-scala-file-into-interpreter-to-use-functions)

* What makes a closure different from a code block
[Scala Gotcha: Blocks And Functions](http://downgra.de/2010/08/05/scala_gotcha_blocks_and_functions/)
[Functional Scala: Closures](http://gleichmann.wordpress.com/2010/11/15/functional-scala-closures/)

### Do

* Use `foldLeft` to compute the total size of a list of strings.

foldLeft:

```scala
(0 /: words) { _ + _.size }
(0 /: words) { (sum, word) => sum + word.size }
words.foldLeft(0)( _ + _.size )
words.foldLeft(0) { (sum, word) => sum + word.size }
```

foldRight:
```scala
(words :\ 0) { _.size + _ }
(words :\ 0) { (word, sum) => word.size + sum }
words.foldRight(0)( _.size + _ )
words.foldRight(0) { (word, sum) => word.size + sum }
```

* Write a Censor trait with a method that will replace the curse words Shoot and Darn with Pucky and Beans alternatives. Use a map to store the curse words and their alternatives.

```scala
trait Censor {
  val replacement = Map("Shoot" -> "Pucky", "Darn" -> "Bean")
  def censor(text: String) = (replacement :\ text) {
    case ((key, value), memo) => memo.replaceAll(key, value)
  }
}
new Censor{}.censor("Shoot, Darn")
```

* Load the curse words and alternatives from a file.

```scala
val source = scala.io.Source.fromFile("censor.text")
val lines = source.mkString.split('\n')
val map = (lines :\ Map()) { (line, memo) =>
  println(line)
  val words = line.split(',')
  memo + (words(0) -> words(1))
}
source.close
```

---

## Day 3: Day 3: Cutting Through the Fluff

### Find

* For the sizer program, what would happen if you did not create a new actor for each link you wanted to follow? What would happen to the performance of the application?

### Do

* Take the sizer application and add a message to count the number of links on the page.
* Bonus problem: Make the sizer follow the links on a given page, and load them as well. For example, a sizer for “google.com” would compute the size for Google and all of the pages it links to.