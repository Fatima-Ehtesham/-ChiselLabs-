package Lab2

import chisel3._ 
import chisel3.util._

class barrel_shift extends Module{
val io = IO(new Bundle{
val in = Vec(4, Input(Bool())) 
val sel = Vec(2, Input(Bool())) 
val shift_type = Input(Bool()) 
val out = Vec(4, Output(Bool())) })

val mux1 = Mux(shift_type,0,in(0))
val mux2 = Mux(shift_type,0,in(0))
val mux3 = Mux(shift_type,0,in(1))
val mux4 = Mux(shift_type,0,in(2))

io. out(0) := MuxLookup (io. sel , false .B, Array (
(b"00". U) -> io.in(0) ,
(b"01". U) -> io.in(1) ,
(b"10". U) -> io.in(2) ,
(b"11". U) -> io.in(3) ))
io. out(1) := MuxLookup (io. sel , false .B, Array (
(b"00". U) -> io.in(1) ,
(b"01". U) -> io.in(2) ,
(b"10". U) -> io.in(3) ,
(b"11". U) -> mux1 ))  
io. out(2) := MuxLookup (io. sel , false .B, Array (
(b"00". U) -> io.in(2) ,
(b"01". U) -> io.in(3) ,
(b"10". U) -> mux2,
(b"11". U) -> mux3 )) 
io. out(3) := MuxLookup (io. sel , false .B, Array (
(b"00". U) -> io.in(3) ,
(b"01". U) -> mux1 ,
(b"10". U) -> mux3 ,
(b"11". U) -> mux4 )) 


} println((new chisel3.stage.ChiselStage).emitVerilog(new barrel_shift))