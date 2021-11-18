//Code memory or instruction memory:
//Code memory can be synchronous or asynchronous memories.
//To test working of a processor,load code memory with executable of user program (hexa code by dumping code of venus) 
//use 'loadMemoryFromFile' from Chisel library utility.

package Lab8s
package LM_Chisel

import chisel3 ._
import chisel3 . util ._
import chisel3 . util . experimental . loadMemoryFromFile
import scala .io. Source

class InstMemIO extends Bundle with Config {
val addr = Input ( UInt ( WLEN .W))
val inst = Output ( UInt ( WLEN .W))
}
class InstMem ( initFile : String ) extends Module with Config {
val io = IO( new InstMemIO )
val imem = Mem ( INST_MEM_LEN , UInt ( WLEN .W))
// an annotation generator that loads memory(imem) from a text file(initFile)
loadMemoryFromFile ( imem , initFile )
// INST_MEM_LEN in Bytes or INST_MEM_LEN / 4 in words
io. inst := imem ( io. addr / 4.U)
}

//User executable file, to be loaded to instruction memory, is passed as string parameter by the topm module
//A separate .v file is generated during hardware generation, used for binding instruction memory to executable file.
object Generate_ProcessorTile extends App {
var initFile = " src / test / resources / main . txt "
chisel3 . Driver . execute (args , () => new ProcessorTile ( initFile ))

//memory file consist of ASCII text in hex or binary format.
//A binary file can be similarly constructed.
//'loadMemoryFromFileInline' is annotation generator that load memory from a text file inlined in the Verilog module