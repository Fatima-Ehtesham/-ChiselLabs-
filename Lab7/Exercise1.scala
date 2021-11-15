package Lab7

import chisel3._
import chisel3.util._

class Ex1_Arbiter extends Module {
    val io = IO(new Bundle {
        val in = Flipped(Vec(2, Decoupled(UInt(8.W))))
        val out = Decoupled(UInt(8.W)) 
})

        val queue = Queue(io.in(0), 5) 
        val queue_1 = Queue(io.in(1), 5) 

        queue.nodeq()
        queue_1.nodeq()

        //io.out.bits := 0.U
        io.out.valid := 1.B
        //io.out.valid(1.B)

        val arb_priority = Module(new Arbiter(UInt(),2))

        arb_priority.io.in(0) <> queue
        arb_priority.io.in(1) <> queue_1

        // connect the output to consumer
        io.out <> arb_priority.io.out

        //Or

        // package lab7
// import chisel3 . _
// import chisel3 . util . _

// class Arbitor extends Module {
//     val io = IO ( new Bundle {
//         val in = Flipped (Vec(2,Decoupled ( UInt (16. W ) ) ) )// valid = Input , ready = Output , bits = Input
//         val out = Decoupled ( UInt (16. W ) )   // valid = Output , ready =Input , bits = Output
//     })

//     val queue0 = Queue (io.in(0),2)
//     val queue1 = Queue (io.in(1),2)
//     queue0.nodeq()
//     queue1.nodeq()
//     io.out.bits:=0.U
//     // io.out.valid:=0.U
//     io.out.valid (1.B)
//     // switch ( queue1.valid && io.out.ready){
//     //    is(1.B) {
//     //     io.out.enq(queue1.deq())
//     // }}
//     val arbi = Module (new Arbiter(UInt(),2))
//         arbi.io.in(0)<>queue1
//         arbi.io.in(1)<>queue0
//         io.out <> arbi.io.out
// }
    