//to create a 4-to-2 encoder using Mux1H.

package Lab2s

import chisel3 ._
import chisel3 . util ._

class mux_1H_4to2encoder extends Module {
val io = IO( new Bundle {
val in = Input ( Vec(4 ,UInt (32. W)))
val sel = Input (Vec(2, UInt (2. W)))
val out = Output ( Vec(2 ,UInt (32. W)))
})
io. out(0) := Mux1H (io.sel(1), Seq (io.in(0),io.in(1)))
io. out(1) := Mux1H (io.sel(2) , Seq (io.in(2),io.in(3)))
}
println (( new chisel3 . stage . ChiselStage ). emitVerilog ( new mux_onehot_4to1 ()))
