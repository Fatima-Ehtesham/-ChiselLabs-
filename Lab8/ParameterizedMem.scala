package Lab8s

import chisel3 . _
import chisel3 . util . _

class Parameterized_Mem ( val size : Int = 32 , val width : Int = 32) extends Module {

val io = IO ( new Bundle {
val dataIn = Input ( UInt ( width . W ) )
val dataOut = Output ( UInt ( width . W ) )
val addr = Input ( UInt ( log2Ceil ( size ) . W ) )
val rd_enable = Input ( Bool () )
val wr_enable = Input ( Bool () )
})

// create a synchronous mem of 32 mem loc (mem size) and type is unsigned int and each of width 32 
val Sync_memory = SyncReadMem ( size , UInt ( width . W ) )

// perform write operation on mem
when ( io . wr_enable ) {
Sync_memory . write ( io . addr , io . dataIn )
}

// perform read operation on mem
io . dataOut := Sync_memory . read ( io . addr , io . rd_enable )
}

println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new Parameterized_Mem ) )