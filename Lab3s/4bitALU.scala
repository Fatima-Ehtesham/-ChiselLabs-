package lab3

import chisel3._
import chisel3.util._

class ALU extends Module{
    val io = IO (new Bundle{
        val rs1 = Input (UInt(32.W))
        val rs2 = Input (UInt(32.W))
        val sel = Input(UInt(5.W))
        val out = Output(UInt(32.W))
       })

io.out := 0.U
//Acc to ALU Op
switch(io.sel){
is (0.U){
    io.out := io.rs1 + io.rs2 }
is (1.U){
    io.out := io.rs1 << io.rs2(4,0) }  //5 bit max shift i.e (4,0)
is (2.U){
    when(io.rs1 < io.rs2){
    io.out:= 1.U }
    .otherwise{
    io.out:=0.U }}
is(4.U){
    io.out := io.rs1^io.rs2 }
is(5.U){
    io.out := io.rs1 >> io.rs2(4,0) }
is(6.U){
    io.out := io.rs1 | io.rs2 }
is(7.U){
    io.out := io.rs1 & io.rs2 }
is(8.U){
    io.out := io.rs1 - io.rs2} }    
}