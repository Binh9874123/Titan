import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        ReadConfig readConfig = new ReadConfig();
        if(args.length == 1 && readConfig.Read(args[0]))
        {
            Reader MyReader = new Reader();
            Writer MyWriter = new Writer();

            DoCode MyJob = new DoCode();
            while(!MyReader.EOFCheck())
            {
                byte[] buf = MyReader.Read(readConfig.INPUT ,readConfig.BUFF);
                MyWriter.Write(readConfig.OUTPUT , MyJob.Change(buf));
                System.out.println("Complete");

            }

        }

    }
}
