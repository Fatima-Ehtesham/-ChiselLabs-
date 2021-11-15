package Practice 

import chisel3._

class 4x1Mux extends Module{
    val io = IO (new Bundle){
        val in1 = Input(Bool())
        val in2 = Input(Bool())
        val in3 = Input(Bool())
        val in4 = Input(Bool())
        val sel1 = Input(Bool())
        val sel2 = Input(Bool())
        val out1 = Output(Bool())
        val out2 = Output(Bool())
        val output = Output(Bool())
    }
    out1 := Mux(sel1,in1,in2)
    out2 := Mux(sel1,in3,in4)
    output := Mux(sel2,out1,out2)
}