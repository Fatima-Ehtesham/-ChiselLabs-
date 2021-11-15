package Practice

import chisel3._

class 2To4Decoder extends Module{
    val io = IO (new Bundle){
     val input = Input (UInt(2.W))
     val D1 = Output (UInt(2.W))
     val D2 = Output (UInt(2.W))
     val D3 = Output (UInt(2.W))
     val D4 = Output (UInt(2.W))         
    }
    when(io.input==="b00".U){
        io.D1 := }
    .elsewhen(io.input==="b01".U){
        io.D2 := 
    }
    .elsewhen(io.input==="b10".U){
        io.D3 :=
    }
    .otherwise{
        io.D4 :=
    }
    }