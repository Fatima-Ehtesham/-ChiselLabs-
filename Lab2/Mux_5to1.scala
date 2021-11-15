package Lab2s

import chisel3._

class LM_IO_Interface extends Bundle {
val s0 = Input(Bool()) 
val s1 = Input(Bool())
val s2 = Input(Bool()) 
val out = Output(UInt(32.W))
}
class Mux_5to1 extends Module { val io = IO(new LM_IO_Interface)

val ifeq = b"1??".U
when(s0s1s2===b"000".U){ io.out := 0.U }
.elsewhen(s0s1s2===b"001".U){ io.out := 8.U }
.elsewhen(s0s1s2===b"010".U){ io.out := 16.U }
.elsewhen(s0s1s2===b"011".U){ io.out := 24.U }
.elsewhen(s0s1s2===ifeq){ io.out := 32.U }
.otherwise{io.out :=False.B}
} println((new chisel3.stage.ChiselStage).emitVerilog(new Mux_5to1))