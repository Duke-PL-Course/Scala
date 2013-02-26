# Scala Practice Review Problem

## QuickSort

To demonstrate the expressiveness and power of functional programming, we are going to ask you to implement [quicksort][] Here's a quick definition of quicksort:

For a given list, if the list is not empty, choose one element as a pivot element. It may be easiest to pick the first element as the pivot. Partition the remainder of the elements into two lists, one that contains elements that are less than or equal to the pivote, and one that contains elements that are greater than the pivot. Recursively call quicksort on the left and right partitions; finally, concatenate the left, pivot, and right together.

The signature you should use is:

```scala
def qs[T <% Ordered[T]](list: List[T]): List[T]
```

Example:

```scala
scala> qs(List(1, 34, 65, 3, 3, -1))
res1: List[Int] = List(-1, 1, 3, 3, 34, 65)

scala> qs(List("a", "b", "a", "abc", "bcd","c"))
res2: List[String] = List(a, a, abc, b, bcd, c)
```

## Hint

* You can use pattern matching with recursion to solve this problem very easily
* You can use [for comprehensions][for] to easily partition the list
* You can also use the [`partition` method on `List`][part] to partition the list


[quicksort]: http://en.wikipedia.org/wiki/Quicksort
[for]: http://www.scala-lang.org/node/111
[part]: http://www.scala-lang.org/api/current/index.html#scala.collection.immutable.List