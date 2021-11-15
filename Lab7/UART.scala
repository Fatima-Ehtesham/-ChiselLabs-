//Universal asynchronous receiver-transmitter (UART) 
//it is device-to-device digital communication b/w 2 nodes using pair of wires and a ground.
//One chip’s Tx (transmit) pin connects directly to the other’s Rx (receive) pin and vice versa. 
//& transmission is at 3.3 or 5V.
//Data travels in parallel from UART to controlling device (e.g., a CPU).
//on Tx pin 1st UART translates parallel info into serial and transmits it to Rx
//2nd UART Rx pin transforms it into parallel to communicate with its controlling device. 
//it is asynchronous— no clock regulates data transmission speed (baud rate) in bits per second (bps).
//baud rate must be same for both UART.
//(bit rate derived from the clock using baud divisor parameter given by the user).

//baud divisor or UART configuration parameters.
package Lab7s

import chisel3 . _
import chisel3 . stage . ChiselStage72
import chisel3 . util . _

case class UART_Params (
dataBits : Int = 8 ,
stopBits : Int = 2 ,
divisorBits : Int = 5 ,
oversample : Int = 2 ,
nSamples : Int = 3 ,
nTxEntries : Int = 4 ,
nRxEntries : Int = 4) {
def oversampleFactor = 1 << oversample
require ( divisorBits > oversample )
require ( oversampleFactor > nSamples )}

class UART_Tx ( c : UART_Params ) extends Module {
val io = IO ( new Bundle {
val en = Input ( Bool () )
val in = Flipped ( Decoupled ( UInt (( c. dataBits ) . W ) ) )
val out = Output ( Bool () )
val div = Input ( UInt (( c . divisorBits ) .W ) )
val nstop = Input ( UInt (( c . stopBits ) . W ) )})
// pulses generated at baud rate using prescaler
val prescaler = RegInit (0. U (( c . divisorBits ) .W ) )
val pulse = ( prescaler === 0. U )
private val n = c . dataBits + 1
val counter = Reg ( UInt ( n . W ) )
val shifter = RegInit ( true . B )
val out := out
io . out = RegInit (0. U (( log2Floor ( n + c . stopBits ) +1) . W ) )
val busy = io . en && ! busy
val state1 = busy
val state2 := state1
io . in . ready = ( counter =/= 0. U )

when ( state1 )
shifter :=
counter :=
(0 until
)
}
{
Cat ( io . in . bits , false . B )
Mux1H (
c . stopBits ) . map ( i = > ( io . nstop === i . U ) -> ( n + i +2) . U )
when ( state2 ) {
prescaler := Mux ( pulse , ( io . div - 1. U ) , prescaler - 1. U )