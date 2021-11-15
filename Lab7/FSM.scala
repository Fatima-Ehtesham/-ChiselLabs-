//Finite state machines are used to detect sequence of bits in a
//bitstream.FSM are made with building blocks 
//(Next state logic, State register, Output logic)
//First state register is initialized with default state.
//next state logic implements state transition, using switch or when blocks.
//output logic will update the output & determines the type of 
//FSM(Mealy state machines: Output depends state and input, 
//Moore state machines: Output depends on state only)

//Type enumeration(Enum) used to list and define the different state. 

package Lab7s

import chisel3 . _
import chisel3 . util . _
import chisel3 . iotesters .{
ChiselFlatSpec , Driver , PeekPokeTester
}
import chisel3 . experimental . ChiselEnum

// Sequence to detect is 110
class Detect_Seq extends Module {
val io = IO ( new Bundle {
val in = Input ( Bool () )
val out = Output ( Bool () )
})
val s0 :: s1 :: s2 :: Nil = Enum (3) // Enumeration type
//s0,s1,s2 are 3 states
val state = RegInit ( s0 ) // initial state = s0

io . out := ( state === s2 ) & (! io . in )
// Mealy type state machine b/c output depends on both state and input.

switch ( state ) {
is ( s0 ) {
when ( io . in ) {  // move to next state s1 when input is 1
state := s1 }}
is ( s1 ) {
when ( io . in ) { // move to next state when input is 1
state := s2 } 
.otherwise {
state := s0}}
is ( s2 ) {
when (! io . in ) {
// move to default state when input is zero
// otherwise stays at s2 because input sequence is 111
state := s0}}
}
}
println ( chisel3 . Driver . emitVerilog ( new Detect_Seq ) )