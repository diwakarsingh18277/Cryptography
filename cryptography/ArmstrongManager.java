package  cryptography;
class ArmstrongManager{
    private String numericKey;
    private int enc_ind;
    private int dec_ind;
    ArmstrongManager(String nk)
    {
        numericKey=nk;
        enc_ind=-1;
        dec_ind=-1;
    }
    int encrypt(int data)
    {
        try{
        return data^(numericKey.charAt(++enc_ind));
        }
        catch (StringIndexOutOfBoundsException ex)
        {
            enc_ind=-1;
            return data^(numericKey.charAt(++enc_ind));
        }
    }
    int decrypt(int data)
    {
        try{
            return data^(numericKey.charAt(++dec_ind));
        }
        catch (StringIndexOutOfBoundsException ex)
        {
            dec_ind=-1;
            return data^(numericKey.charAt(++dec_ind));
        }
    }
}
