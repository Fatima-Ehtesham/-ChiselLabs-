package Lab_01

import chisel3._ 

class Adder extends Module{
    val io = IO (new Bundle){
        val a = Input (UInt(1.W))
        val b = Input (UInt(1.W))
        val output = Output (UInt(1.W))
    }
    io.output = io.a + io.b
}