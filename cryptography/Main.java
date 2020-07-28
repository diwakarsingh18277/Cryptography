package cryptography;
import java.util.Scanner;

public class Main
{
    //entry point into the application
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\t\t\t****** Cryptography *******\n");
        int choice=0;
        while(choice!=1 && choice!=2)
        {
          System.out.println("\tEnter you choice : ");
          System.out.println("\t1.String Encryption\n\t2.Image Encryption");
          System.out.print("\t");
          choice = sc.nextInt();

          if(choice == 1 || choice == 2)
            break;
          else
          {
              System.out.println("\tInvalid Input");
          }

        }

        if(choice==1)
        {
          // String data = "This is a very important statement.";
          sc.nextLine();
          System.out.println("\tEnter your data which you want to encrypt");
          System.out.print("\t");
          String data=sc.nextLine();
          // System.out.println(data);
          String key = "How old is my computer?";
          KeyGenerator kGen = new KeyGenerator(key);
          String nK = kGen.getNumericKey();
          ArmstrongManager aMgr = new ArmstrongManager(nK);
          ColorManager cMgr = new ColorManager(nK);
          String encData ="";
          int temp;
          int i;
          System.out.println("\n\tdata: "+ data + "  " + data.length());

          for(i =0 ; i < data.length(); i++)
          {
              temp = aMgr.encrypt(data.charAt(i));
              temp = cMgr.encrypt(temp);
              encData = encData  + (char)temp;
          }
          System.out.println("\n\tenc data: "+ encData + "  " + encData.length());
          int ch=2;
          while(ch!=0 && ch!=1)
          {
            System.out.println("\n\tDo you want to decrypt ? \n\t1.Yes\n\t0.No");
            System.out.print("\t");
            ch=sc.nextInt();
          }
          if(ch==1)
          {
            String decData= "";
            for(i =0 ; i < encData.length(); i++)
            {
                temp = cMgr.decrypt(encData.charAt(i));
                temp = aMgr.decrypt(temp);
                decData = decData  + (char)temp;
            }

            System.out.println("\n\tdec data: "+ decData + "  " + decData.length());
          }
      }
      else
      {
        try
        {
            //String src = "d:/a.txt";//images/kids.jpg";
            //String enc = "d:/e_a.txt";//images/e_kids.jpg";
            //String dec = "d:/d_a.txt";//images/d_kids.jpg";
            String src = "d:/images/kids.jpg";
            String enc = "d:/images/e_kids.jpg";
            String dec = "d:/images/d_kids.jpg";

            String key = "How old is my computer?";

            Encryptor objEnc = new Encryptor(key);
            Decryptor objDec = new Decryptor(key);

            objEnc.encrypt(src, enc);
            System.out.println("Encryption Done");

            objDec.decrypt(enc, dec);
            System.out.println("Decryption Done");


          }
          catch(Exception ex)
          {
              System.out.println("Err: " +ex.getMessage());
          }
      }
    }

}
