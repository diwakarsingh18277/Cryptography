package cryptography;
class ByteManager{
      static int[] byteToNibble(int x){
          int nibble[]=new int[2];
          nibble[0]=(x)>>4; //upper
          nibble[1]=(x&15); // lower
         // System.out.println(nibble[0]+" "+nibble[1]);
          return nibble;
      }
      static int nibbleToByte(int []nibble)
      {
          return ((nibble[0])<<4|nibble[1]);
      }
}
