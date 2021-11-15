//Seq:
//an iterable collection, used to represent indexed sequences having a defined order of element.
//two primary subtraits of Sequence namely IndexedSeq and LinearSeq.
//IndexexedSeq provides fast and random access of elements 
//LinearSeq provides fast access to the first element only via head, also contains a fast tail operation.
// Initializing sequence
   var seq:Seq[Int] = Seq(1,2,3,4,5,6)
// Printing whole Sequence
 seq.foreach((element:Int) => print(element+","))
// print or access one element of seq through index
 println(seq(2))
     
//Predefined Methods in Sequence 
//apply-> select an element from the sequence
//contains-> check whether a sequence contains the given element
//count-> count the number of elements that satisfies a predicate
//length-> gives the length of the Sequence
//copyToArray-> For copying the elements of Sequence to array
//endsWith-> to check whether a sequence terminates with a given sequence or not
//head->It selects the first element of the sequence.
//indexOf-> To find the index of first occurrence of a value in the sequence
//isEmpty->To test the emptiness of the sequence.
//lastIndexOf-> To find the index of last occurrence of a value in the sequence
//reverse-> To return a new sequence with elements in reverse order.

seq.isEmpty