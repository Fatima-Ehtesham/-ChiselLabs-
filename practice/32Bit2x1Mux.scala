package Practice

import chisel3._

class 32Bit2x1Mux(sel:Bool) extends Module{
    val io = IO (new Bundle){
        val in1 = Input (UInt(32.W))
        val in2 = Input (UInt(32.W))
        val output = Output (UInt(32.W))
    }
    when(sel === false){
        io.output := io.in1
    }
    .otherwise{
        io.output := io.in2
    }
}