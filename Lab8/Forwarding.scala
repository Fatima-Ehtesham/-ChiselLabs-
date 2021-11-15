package lab8s
import chisel3 . _
import chisel3 .util. _
class Forwarding extends Module {
    val width : Int = 32
    val io = IO ( new Bundle {
        val write = Input ( Bool () )
        val Readadd = Input ( UInt (10. W ) )
        val Writeadd = Input ( UInt (10. W ) )
        val dataIn = Input (UInt ( width . W )) 
        val dataOut = Output (UInt ( width . W )) 
    })
  //  val mem = SyncReadMem (32 , UInt ( width . W ) )
    //val wrDataReg = RegNext ( io .dataIn)
   // val doForwardReg = RegNext ( io.Readadd === io .Writeadd && io .write )
   // val memData = mem . read ( io . Readadd )
   // when ( io .write)
   // {
   // mem . write ( io . Writeadd , io .dataIn)
   // }
   // io .dataOut := Mux ( doForwardReg , wrDataReg , memData )

}