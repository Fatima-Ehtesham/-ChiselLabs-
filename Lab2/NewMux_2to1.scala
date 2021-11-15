package Lab2s

import chisel3 ._

class Mux_2to1_IO extends Bundle {
val in_A = Input ( UInt (32. W)) // traditional mux has three inputs, input1, input2, and select
val in_B = Input ( UInt (32. W))
val select = Input ( Bool ())
val out = Output ( UInt ())
}
// 2 to 1 Mux implementation
class NewMux_2to1 extends Module {
val io = IO( new Mux2to1_IO )

val AND1 := io.A & (~io.select)
val AND2 := io.A & (io.select)
io.out := AND1 || AND2

}
println (( new chisel3 . stage . ChiselStage ). emitVerilog ( new NewMux_2to1 ()))
