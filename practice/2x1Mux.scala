package Practice

import chisel3._

class 2x1Mux(sel:Bool) extends Module{
    val io = IO (new Bundle){
        val in1 = Input (UInt(1.W))  // Or // val in1 = Input (Bool())
        val in2 = Input (UInt(1.W))
                                    // val sel = Input (Bool())
        val output = Output (UInt(1.W))
    }
    when(sel === false){
        io.output := io.in1
    }
    .otherwise{
        io.output := io.in2
    }
}