package Lab_01

import chisel3._ 

class FullAdder extends Module{
    val io = IO (new Bundle){
        val a = Input (UInt(1.W))
        val b = Input (UInt(1.W))
        val cin = Input (UInt(1.W))
        val xor1 = Output (UInt(1.W))
        val and1 = Output (UInt(1.W))
        val and2 = Output (UInt(1.W))
        val sum = Output (UInt(1.W))
        val cout = Output (UInt(1.W))
    }
    io.xor1 := io.a ^ io.b
    io.and1 := io.a & io.b
    io.and2 := io.cin & io.xor1
    io.sum := io.cin ^ io.xor1
    io.cout := io.and1 | io.and2
}