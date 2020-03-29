import java.io.*;
import java.util.HashMap;

public class DuplicateCounter {

    private HashMap<String,Integer> wordCounter;

    public void count(File dataFile){
        int counter;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(dataFile));
            String[] intake;
            intake = reader.readLine().split(" ");
            reader.close();
            wordCounter =  new HashMap<String, Integer>();
            String[] wordsChecked = new String[intake.length];
            int alreadycheckedFlag = 0;


            for (int i = 0;i<intake.length;i++){
                counter=1;
                System.out.printf("intake[%d]:%s%n",i,intake[i]);
                String wordi = intake[i].toUpperCase();
                for(int j =i+1;j<intake.length;j++){
                    for(int x = 0; x<wordsChecked.length;x++)
                    {
                        String wordx = intake[x].toUpperCase();
                        if(wordi.equals(wordx))
                        {
                            alreadycheckedFlag =1;
                        }else alreadycheckedFlag =0;
                    }
                    String wordj = intake[j].toUpperCase();
                    System.out.printf("intake[%d]:%s vs intake[%d]:%s%n",i,intake[i],j,intake[j]);
                    if((wordi.equals(wordj)) && alreadycheckedFlag!=1){
                        counter++;
                        System.out.printf("intake[%d]:%s repeats %d times%n",i,intake[i],counter);
                    }
                }

                wordsChecked[i] = intake[i];

                wordCounter.put(intake[i],counter);
                String keyCheck = intake[i];
                System.out.printf("%s : %d",keyCheck, wordCounter.get(keyCheck));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void write(File outputFile){

        try{
            BufferedWriter outfilewriter = new BufferedWriter(new FileWriter(outputFile));
            for (String i:wordCounter.keySet())
            {
                System.out.printf(i + ":");
                System.out.println(wordCounter.get(i));
                outfilewriter.write(i);
                outfilewriter.write(" ");
                String value = wordCounter.get(i).toString();
                outfilewriter.write(value);
                outfilewriter.newLine();

            }
            outfilewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
