//Bitfield manipulation:
Val abc = x (31)  // x is of 32 bits
val cd = y (0,7) // y is of atleast 8 bits
val highbit = b"1011".U
val highbit = b"1001011".U
val xy = cat (highbit,lowbit) // concatenation
val sd = Fill (3 , b"1011".U) // sd = 101110111011, 3 times 1011.
val a = sd.andR // sets all bits to one, AND reduction.
val b = sd.orR // sets any one bit to one, OR reduction.
val c = cd.xorR // checks parity of data, XOR reduction.

// BitPat(bit pattern):
//A value has even parity if it has an even number of 1 bits like 0110.
//A value has an odd parity if it has an odd number of 1 bits like 1011.
//dont care bits are given by "??"
//BitPat provides literals with masks and generates bit patterns involving don't care bits.

def opCode_BEQ = BitPat (" b000 ?????1100011 ")
def opCode_BLT = BitPat (" b100 ?????1100011 ")
// opcode matching with don 't care bits
when ( opCode_BEQ === " b000110001100011 ".U){
//above comparison evaluates to true .B as bits before and after dont care in opcode_beq are equal.
}
