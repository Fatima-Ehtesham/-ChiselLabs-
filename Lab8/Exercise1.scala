package Lab8s

import chisel3._

class Ex1 extends Module {
    val io = IO(new Bundle {
    val en = Input(Bool())
    val write = Input(Bool())
    val addr = Input(UInt(10.W))
    val mask = Input(UInt(2.W))
    val dIn = Input(UInt(32.W))
    val dOut = Output(UInt(32.W))
})


   // val mem = SyncReadMem (1024, UInt(32.W))

   // when (io.mask === 0.U) {
   //     mem.write(io.addr , io.dIn(7,0))
    }

    .elsewhen (io.mask === 1.U) {
        mem.write(io.addr , io.dIn(15,0))
    }

    .elsewhen (io.mask === 2.U) {
        mem.write(io.addr , io.dIn(23,0))
    }

    .otherwise {
        mem.write(io.addr , io.dIn(31,0))
    }
    
    io.dOut := mem.read(io.addr , io.en)
}