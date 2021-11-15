//Exercise3:
// Modify the counter to make max parameter of type Int and then use typecasting to make it work.

package Lab1s

import chisel3 . _
import scala.language.postfixOps;

class CounterEx ( size : Int , maxValue : UInt. asInstanceOf [Int] ) extends Module {
val io = IO ( new Bundle {
val result = Output ( Bool () )
})
// ' genCounter ' with counter size 'n '
def genCounter ( n : Int , max : UInt. asInstanceOf [Int] ) = {
val count = RegInit ((0. U). asInstanceOf [Int] ( n . W ) )
when ( count === max ) {
count := (0.U). asInstanceOf [Int]
} .otherwise {
count := count + (1. U). asInstanceOf [Int]
}
count
// genCounter instantiation
val counter1 = genCounter ( size , maxValue )
io . result := counter1 ( size -1)
}
println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new CounterEx (8 , (255. U). asInstanceOf [Int] ) ) )
