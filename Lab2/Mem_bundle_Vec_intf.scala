package Lab2s

import chisel3 . _

class LM_IO_Interface extends Bundle {
val data_in = Input ( Vec (4 ,( UInt (32. W ) ) ) )
val data_selector = Input ( UInt (2. W ) )
val data_out = Output ( UInt (32. W ) )
val addr = Input ( UInt (5. W ) )
// The signal is high for write
val wr_en = Input ( Bool () )
}

class Mem_bundle_Vec_intf extends Module {
val io = IO ( new LM_IO_Interface )

io . data_out := 0. U
val memory = Mem (32 , UInt (32. W ) )
when ( io . wr_en ) {
// Write for wr_en = 1
memory . write ( io . addr , io . data_in ( io . data_selector ) )
} .otherwise {
// Asyncronous read from addr location
io . data_out := memory . read ( io . addr )
}}
println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new Mem_bundle_Vec_intf () ) )
