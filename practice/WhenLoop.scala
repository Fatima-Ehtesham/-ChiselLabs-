package Practice

import chisel3._

class WhenLoop(input:int) extends Module{
    val io = IO (new Bundle) {
        
    }
    val MyNode = Wire(5.U(8.W))
    when (input>300.U){
        MyNode := 1.U}
    .otherwise{
        MyNode := 0.U}
}
println(WhenLoop(500))

//OR :

//when (input>300.U){
//    MyNode := 200.U}
//.elsewhen(input>250.U){
//    MyNode := 100.U}
//.otherwise{
//    MyNode := 0.U}