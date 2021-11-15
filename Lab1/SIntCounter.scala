//Exercise 1:
//Modify counter to use SInt type count.
package Lab1s

import chisel3 . _

class SIntCounter ( counterBits : SInt ) extends Module {
val io = IO ( new Bundle {
val result = Output ( Bool () )
})

val max = (1. S < < counterBits ) - 1. S
val count = RegInit (0. S (16. W ) )
when ( count === max ) {
count := 0. S
} .otherwise {
count := count + 1. S
}
io . result := count (15. S )
println ( s " counter created with max value $max " )

// OR

//package Lab1s    
//import chisel3 . _

//class SIntCounter ( counterBits : UInt. asSInt) extends Module {
//val io = IO ( new Bundle {
//val result = Output ( Bool () )
//})
//val max = ((1. U < < counterBits ) - 1. U) . asSInt
//val count = RegInit ((0. U). asSInt (16. W ) )
//when ( count === max ) {
//count := (0. U). asSInt
//} .otherwise {
//count := count + 1. S}
//io . result := count (15. U ). asSInt
//println ( s " counter created with max value $max " )
//}
