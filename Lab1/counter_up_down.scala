//Task:

//implements an up-down counter. counter starts from 0,
//counts up to a pre-defined value and then counts down to zero. 
//It must repeats it counting and set io.out to high for one clock 
//cycle when it reach either maximum or minimum values.

package Lab1s
package Counter

import chisel3 . _
import chisel3 . util . _
import java . io . File

class counter_up_down ( n : Int ) extends Module {
val io = IO ( new Bundle {
val data_in = Input ( UInt ( n . W ) )
val reload = Input ( Bool () )
val out = Output ( Bool () )
})
val counter = RegInit (0. U ( n . W ) )
val max_count = RegInit (6. U ( n . W ) )
reload := 0.U
when (counter === max_count){
    counter := counter - 1.U
    io . out := 1.U
}
.elsewhen (counter === reload)
    counter := counter + 1.U}
     io . out := 1.U
}
.otherwise{
    counter := counter + 1.U
}

io . out := counter (n-1)
}
println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( counter_up_down ( 8.U ) )
