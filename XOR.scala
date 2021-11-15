Package Lab_01

import chisel3._ 

class XOR extends Module{
    val io = IO(new Bundle{
        val a = Input (SInt (1.W))
        val b = Input (SInt (1.W))
        val output = Input (SInt (1.W))
    })
    io.output := io.a ^ io.b
}