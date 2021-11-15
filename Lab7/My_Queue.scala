package Lab7s

import chisel3 . _
import chisel3 . util . _
import chisel3 . iotesters .{
ChiselFlatSpec , Driver , PeekPokeTester
}
class My_Queue extends Module {
val io = IO ( new Bundle {
val in_f1 = Input ( Bool () )
val in_f2 = Input ( Bool () )
val in_r1 = Input ( Bool () )
val in_r2 = Input ( Bool () )
val out = Output ( Bool () )
})
val s0 :: s1 :: s2 :: s3 :: s4 :: s5 :: Nil = Enum (6) 
//six states (s0,s1,s2,s3,s4,s5), four inputs, and one output.
val state = RegInit ( s0 )

io.out := 0.U

// Mealy type state machine
switch(state){
    is (s0){       //so is current state, s0,s1,s5 are next possible states.
        when (!(io.in_f1) & !(io.in_f2)){
            state := s0          //if f1 and f2 are 0, s0 to s0
        }
        .elsewhen(io.in_f1){
            state := s1          //if f1 is 1, s0 to s1
        }
        .elsewhen(io.in_f2){
            (state := s5)        //if f2 is 1, s0 to s5
        }
        .otherwise{
            DontCare     //Default case, no condition true.  
            //use dontcare when output signals were never driven
        }

    }
    is (s1){
        when(!(io.in_r1) & !(io.in_f1){  // or: when((io.in_r1===0) & (io.in_f1===0){
            state := s1
        }
        .elsewhen(io.in_f1){
            state:=s2
        }
        .elsewhen(io.in_r1){
            state := s0
        }
        .otherwise{
            DontCare
        }
    }
    is(s2){   // f1 and r1 has priority with output 3
        when(!(io.in_r1) & !(io.in_f1)){
            state := s2
            io.out := 3.U
        }
        .elsewhen(io.in_f1){
            state := s3
            io.out := 3.U
        }
        .elsewhen(io.in_r1){
            state := s1
            io.out := 3.U
        }
         .otherwise{
            DontCare
        }

    }
    is (s3){  //all inputs are dontcare.
        state := s0
    }

    is (s4){   // f2 and r2 has priority(value=1) with output 7
        when(!(io.in_r2) & !(io.in_f2)){
            state := s4
            io.out := 7.U
        }.elsewhen(io.in_r2){
            state := s5
            io.out := 7.U
        }
        .elsewhen(io.in_f2){
            state :=s3
            io.out := 7.U
        }
        .otherwise{
            DontCare
        }}

    is(s5){
        when(!(io.in_r2) & !(io.in_f2)){
            state := s5
        }
        .elsewhen(io.in_f2){
            state := s4

        }
        .elsewhen(io.in_r2){
            state := s4

        }
        .otherwise{
            DontCare
        }
        }}}}