package Lab3s

import chisel3._ 
import chisel3 . util._ 

class ImmGenerator extends Module {
val io = IO ( new Bundle {
val instr = Input ( UInt (32. W ) )
val ProgramCounter = Input ( UInt (32. W ) )
val split_inst = Output ( UInt (32. W ) )
val immd_se = Output ( UInt (32. W ) )
}
val ItypeImm := (instr[31:20] >> 20)  //sign extend by SRA 20 time


val SImmsplit := (inst[11:7]+instr[31:25]) + (instr[4:0]+instr[11:5])
val StypeImm := (SImmsplit >> 20)  //sign extend by SRA 20 time

val SBImmsplit := (instr[7] + instr[11:8] + instr[30:25] + instr[31]) + (instr[0] + instr[11] + instr[4:1] + instr[10:5] + instr[12])
val SBtypeImm := (((SBImmsplit << 1) >> 21) + ProgramCounter) //SLL 1 time, then sign extend, then adder adding with PC.

val UtypeImm := ((inst[31:12]<<12)>>20) 

val UJImmsplit := (instr[19:12] + instr[20] + instr[30:21] + instr[31]) + (instr[19:12] + instr[11] + instr[10:1] + instr[20])
val UJtypeImm := (((SBImmsplit << 1) >> 10) + ProgramCounter) //SLL 1 time, then sign extend, then adder adding with PC.
  )
}