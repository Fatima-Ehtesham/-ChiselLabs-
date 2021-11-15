//Exercise2:
// Make the counter to reset its count to 0 when its MSB (most significant bit) changes from 0 to 1.

package Lab1s

Import chisel3._

class ResetCounterAccToMSB (counterbit:Int=32) extends Module{
    val io = IO ( new Bundle{
    val result = Output ( Bool () )
    })
    val counter = RegInit (0.U (32.W))

    when (counter(31.U)===1){
    counter := 0.U }
    .otherwise{
    counter := counter + 1.U }

io . result := count (31. U )
println (getVerilog (new ResetCounterAccToMSB))
}
