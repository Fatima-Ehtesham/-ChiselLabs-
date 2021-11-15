// Mux - Onehot (Mux1H) 4 to 1
// number of select lines is same as the number of inputs
//only one select line should be high and each select line corresponds to one input
//If more than one select lines are high, the output is undetermined

package Lab2s

import chisel3 . _
import chisel3 . util . _

class Mux1H extends Module {
val io = IO ( new Bundle {
val in0 = Input ( UInt (32. W ) )
val in1 = Input ( UInt (32. W ) )
val in2 = Input ( UInt (32. W ) )
val in3 = Input ( UInt (32. W ) )
val sel = Input ( UInt (4. W ) )
val out = Output ( UInt (32. W ) )
})
io . out := Mux1H ( io . sel , Seq ( io . in0 , io . in1 , io . in2 , io . in3 ) )
}
println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new Mux1H () ) )
