//Example 4:

// when more than two input lines, an alternate of multiple 2-to-1 multiplexers and have equal priority inputs.
// Syntax: MuxCase ( default , Array ( c1 - > a , c2 - > b , ...) )
// 8 to 1 mux using MuxCase

package Lab2s

import chisel3 . _
import chisel3 . util . _

class MuxCase extends Module {
val io = IO ( new Bundle {
val in0 = Input ( Bool () )
val in1 = Input ( Bool () )
val in2 = Input ( Bool () )
val in3 = Input ( Bool () )
val in4 = Input ( Bool () )
val in5 = Input ( Bool () )
val in6 = Input ( Bool () )
val in7 = Input ( Bool () )
val sel = Input ( UInt (3. W ) ) 
// 8 inputs, 2^3=8, so 3 bits sel.
val out = Output ( Bool () )
})
io . out := MuxCase ( false .B , Array (
( io . sel ===0. U ) -> io . in0 ,
( io . sel ===1. U ) -> io . in1 ,
( io . sel ===2. U ) -> io . in2 ,
( io . sel ===3. U ) -> io . in3 ,
( io . sel ===4. U ) -> io . in4 ,
( io . sel ===5. U ) -> io . in5 ,
( io . sel ===6. U ) -> io . in6 ,
( io . sel ===7. U ) -> io . in7 )
)
}
println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new MuxCase () ) )
