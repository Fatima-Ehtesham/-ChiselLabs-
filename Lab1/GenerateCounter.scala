// Example 3
// creating a counter using function:

package Lab1s

import chisel3 . _

class GenerateCounter ( size : Int , maxValue : UInt ) extends Module {
val io = IO ( new Bundle {
val result = Output ( Bool () )
})

// ' genCounter ' function with counter size 'n '
def genCounter ( n : Int , max : UInt ) = {
val count = RegInit (0. U ( n . W ) )
when ( count === max ) {
count := 0. U
} .otherwise {
count := count + 1. U
}
count
}

// genCounter instantiation
val counter1 = genCounter ( size , maxValue )
io . result := counter1 ( size -1)
}

println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new GenerateCounter (8 , 255. U ) ) )
