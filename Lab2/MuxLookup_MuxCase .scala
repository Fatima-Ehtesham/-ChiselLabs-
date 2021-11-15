// 8 to 1 mux using MuxLookup, muxlookup in muxcase

Package Lab2s

import chisel3 ._
import chisel3 . util ._

class MuxLookup_MuxCase extends Module {
val io = IO( new Bundle {
val in0 = Input ( Bool ())
val in1 = Input ( Bool ())
val in2 = Input ( Bool ())
val in3 = Input ( Bool ())
val in4 = Input ( Bool ())
val in5 = Input ( Bool ())
val in6 = Input ( Bool ())
val in7 = Input ( Bool ())
val sel = Input ( UInt (3. W))
val out = Output ( Bool ())
})
val muxlookup1 := MuxLookup (io. sel , false .B, Array (
(0. U) -> io.in0 ,
(1. U) -> io.in1 ))
val muxlookup2 := MuxLookup (io. sel , false .B, Array (
(2. U) -> io.in2 ,
(3. U) -> io.in3 ))
val muxlookup3 := MuxLookup (io. sel , false .B, Array (
(4. U) -> io.in4 ,
(5. U) -> io.in5 ))
val muxlookup4 := MuxLookup (io. sel , false .B, Array (
(6. U) -> io.in6 ,
(7. U) -> io.in7 ))

io.out := MuxCase( false .B, Array (
((io.sel === 0.U)||(io.sel === 1.U)) -> muxlookup1 ,
((io.sel === 2.U)||(io.sel === 3.U)) -> muxlookup2 ,
((io.sel === 4.U)||(io.sel === 5.U)) -> muxlookup3 ,
((io.sel === 6.U)||(io.sel === 7.U)) -> muxlookup4 )
}
println (( new chisel3 . stage . ChiselStage ). emitVerilog ( new MuxLookup_MuxCase  ()))
