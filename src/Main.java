import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String command = args[0];
        String fileName;
        File file;
        if(args.length == 2){
            fileName = args[1];
            file = new File(fileName);
            System.out.println(getLines(file) + "  "+getWords(file)+"  "+getBytes(file)+" "+fileName);
            return;
        }
        String flag = args[1];
        fileName = args[2];
        file = new File(fileName);

        switch (flag)
        {
            case "-c":
                System.out.println(getBytes(file) + " " + fileName);
                break;
            case "-l":
                System.out.println(getLines(file)+" "+fileName);
                break;
            case "-w":
                System.out.println(getWords(file)+" "+fileName);
                break;
            case "-m":
                System.out.println(getCharacters(file)+" "+fileName);
                break;
            default:
                System.out.println("OOps seems like you lost");
                System.out.println("check this article for list of commands and how i implemented wc tool");
                System.out.println("https://codingchallenges.fyi/challenges/challenge-wc#step-one");

        }


    }



    private static  long getBytes(File file) throws IOException {
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        long byteCount =0;
        while(fs.read() != -1){
            byteCount++;
        }
        fs.close();
        return byteCount;
    }

    private static long getLines(File file) throws IOException {
        long lineCount =0;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while(reader.readLine() != null){
            lineCount++;
        }
        reader.close();
        return lineCount;
    }

    private static long getWords(File file) throws IOException {
        long wordCount =0;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;
        while((line = reader.readLine()) != null){
           String[] words = line.split("\\s+");
            for(String word : words){
                if(word.length() >0)
                    wordCount++;
            }
        }
        reader.close();
        return wordCount;
    }

    private static long getCharacters(File file) throws IOException {
        long characterCount=0;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(reader.read() != -1){
            characterCount++;
        }
        reader.close();
        return characterCount;
    }


}