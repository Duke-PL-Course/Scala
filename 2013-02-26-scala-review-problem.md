# Scala Practice Review Problem

## QuickSort

To demonstrate the expressiveness and power of functional programming, we are going to ask you to implement [quicksort][] Here's a quick definition of quicksort:

For a given list, if the list is not empty, choose one element as a pivot element. It may be easiest to pick the first element as the pivot. Partition the remainder of the elements into two lists, one that contains elements that are less than or equal to the pivote, and one that contains elements that are greater than the pivot. Recursively call quicksort on the left and right partitions; finally, concatenate the left, pivot, and right together.

The signature you should use is:

```scala
def qs[T <% Ordered[T]](list: List[T]): List[T]
```

[quicksort]: http://en.wikipedia.org/wiki/Quicksort


