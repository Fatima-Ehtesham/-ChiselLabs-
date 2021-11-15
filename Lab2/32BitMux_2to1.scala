//Example 2:
package Lab2s

import chisel3 . _

// Mux IO interface class
class Mux_2to1_IO extends Bundle {
val in_A = Input ( UInt (32. W ) )
val in_B = Input ( UInt (32. W ) )
val select = Input ( Bool () )
val out = Output ( UInt () )
}

// 2 to 1 Mux implementation
class 32BitMux_2to1 extends Module {
val io = IO ( new Mux2to1_IO )
// update the output
io . out := Mux ( io . select , io . in_A , io.in_B )    //Mux(sel,in1,in2)
}

println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new 32BitMux_2to1 () ) )
