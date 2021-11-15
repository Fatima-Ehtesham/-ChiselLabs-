package Lab_01

import chisel3._ 

class HalfAdder extends Module{
    val io = IO (new Bundle){
        val a = Input (UInt(1.W))
        val b = Input (UInt(1.W))
        val sum = Output (UInt(1.W))
        val carry = Output (UInt(1.W))
    }
    io.sum := io.a ^ io.b
    io.carry := io.a & io.b
}