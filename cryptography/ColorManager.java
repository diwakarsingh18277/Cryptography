package cryptography;
class ColorManager{
    private int rgb[];
    private int enc_index=-1,dec_index=-1;
    ColorManager(String nk)
    {
        int partB=Integer.parseInt(nk.substring(12));
        rgb=new int[3];
        rgb[0]=Integer.parseInt(nk.substring(0,4)+partB)%256;
        rgb[1]=Integer.parseInt(nk.substring(4,8)+partB)%256;
        rgb[2]=Integer.parseInt(nk.substring(8,12)+partB)%256;
    }
    int encrypt(int data)
    {
          int[] nibble=new int[2];
          nibble=ByteManager.byteToNibble(data);
          enc_index=(enc_index+1)%rgb.length;
          return (rgb[enc_index]+nibble[0]*16+nibble[1])%256;
    }
    
    int decrypt(int data)
    {
         dec_index=(dec_index+1)%rgb.length;
         int temp=(data-rgb[dec_index]+256)%256;
         int[]  nibble=new int[2];
         nibble[0]=temp/16;
         nibble[1]=temp%16;
         return ByteManager.nibbleToByte(nibble);
    }
}
