// Memory forwarding example 
package Lab8s

import chisel3 ._
import chisel3 . util ._

class ForwardingMem extends Module {
val io = IO( new Bundle {
val out = Output ( UInt (32. W))
val rdAddr = Input ( UInt (10. W))
val wrAddr = Input ( UInt (10. W))
val wrData = Input ( UInt (32. W))
val wr_en = Input ( Bool ())
})

val createmem = SyncReadMem(1024, UInt(32.W))
val WriteReg = RegNext(io.wrData)
val DoForwardReg = RegNext ((io.wrAddr==io.rdAddr) && io.wr_en)
val readmem = createmem.read(io.rdAddr)
when(io.wr_en)
{ createmem.write(io.wrAddr,io.wrData)}
io.out := Mux(DoForwardReg,WriteReg,readmem)}

//Memory Forwarding:
//when we have to read out the newly written value
//when write and read operations are on same memory location, during the same cycle.
//It is in memories supporting simultaneous read and write.
//memory with sequential read and write operations do not have this problem.
//The write data is delayed by one clock cycle with a register.
//read operation returns the new write value instead of previously stored value.
//To compatible with expected one-cycle read-after-write latency behavior,give write address and data through register to delay by one cycle.