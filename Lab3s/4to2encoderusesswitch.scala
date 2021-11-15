package Lab3s

import chisel3 . _

class EncoderIO extends Bundle {
val in = Input ( UInt (4. W ) )
val out = Output ( UInt (2. W ) )
}
class 4to2encoderusesswitch extends Module {
val io = IO ( new EncoderIO )
io . out := 0. U
switch(io.in)
is(" b0001 " . U ) {
io . out := " b00 " . U }
is ( " b0010 " . U ) {
io . out := " b01 " . U }
is (" b0100 " . U ) {
io . out := " b10 " . U } 
is("b0011"){
io . out := " b11 " . U } }