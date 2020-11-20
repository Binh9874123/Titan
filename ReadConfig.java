import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
public class ReadConfig {
    static String INPUT;
    static String OUTPUT;
    static String BUFFER;
    static int BUFF;
    public static boolean IsInt(String str)
    {
        try{
            Integer.parseInt(str);
            return true ;
        }catch (NumberFormatException e ){
            return false;
        }
    }
    public static boolean IsFile(String str)
    {
        File file = new File(str);
        if(file.exists() && !file.isDirectory() )
        {
            return true ;
        }
        else {
            return false;
        }
    }

    public static boolean Read(String Arg )throws IOException
    {

        int count = 3 ;
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        String[] config1 = new String[3];
        int i = 0 ;
        try {
            fileInputStream = new FileInputStream(Arg);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String c ;

            while ((c = bufferedReader.readLine()) != null)
            {
                config1[i] = c;
                i++;

            }

        }catch(FileNotFoundException ex){
            System.out.print("Err");
        }catch(IOException ex){

            System.out.print("Err");
        }

        String[] C0 = config1[0].split("\\s");
        String[] C1 = config1[1].split("\\s");
        String[] C2 = config1[2].split("\\s");
        if(C0[0].equals("INPUT"))
        {
            INPUT = C0[2];
        }
        else if (C1[0].equals("INPUT"))
        {
            INPUT = C1[2];
        }
        else if (C2[0].equals("INPUT"))
        {
            INPUT = C2[2];
        }


        if(C0[0].equals("OUTPUT"))
        {
            OUTPUT = C0[2];
        }
        else if (C1[0].equals("OUTPUT"))
        {
            OUTPUT = C1[2];
        }
        else if (C2[0].equals("OUTPUT"))
        {
            OUTPUT = C2[2];
        }


        if(C0[0].equals("BUFFER"))
        {
            BUFFER = C0[2];
        }
        else if (C1[0].equals("BUFFER"))
        {
            BUFFER = C1[2];
        }
        else if (C2[0].equals("BUFFER"))
        {
            BUFFER = C2[2];
        }
        if(IsInt(BUFFER) && IsFile(INPUT))
        {
            BUFF = Integer.parseInt(BUFFER);
            return true;
        }
        else
        {
            System.out.println("Err.Can't do anything");
            return false;
        }





    }




}
