package Lab3s

import chisel3 . _
import chisel3 . util . _

class Branch extends Module{
    val io = IO(new Bundle{
    val fnct3 = Input ( UInt (3. W ) ) //funstion 3
    val branch = Input ( Bool () )   // branch control signal
    val arg_x = Input ( UInt (32. W ) ) //input 1
    val arg_y = Input ( UInt (32. W ) ) //input 2
    val br_taken = Output ( Bool () ) }) //output
io.br_taken := 0.B
    switch(io.branch){
        is(1.B){
        switch(io.fnct3){
        is("b000".U){
            when(io.arg_x === io.arg_y){
            io.br_taken := 1.B }}
        is("b001".U){
            when(io.arg_x =/= io.arg_y){
            io.br_taken := 1.B }}
        is("b100".U){
            when(io.arg_x > io.arg_y){
            io.br_taken := 1.B }}
        is("b101".U){
            when(io.arg_x < io.arg_y){
            io.br_taken := 1.B }}}