import java.io.*;
import java.util.Scanner;

public class DuplicateRemover {

    private String[] uniqueWord;

    private int uniqueCounter = 0;


    public void remove(File dataFile) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(dataFile));

            String[] intake;
            intake = reader.readLine().split(" ");
            reader.close();
            int sizeofIntake = intake.length;
            uniqueWord = new String[sizeofIntake];
            String noDups = "";
            int flag4dup = 0;
            int i,j;
            /*for(i=0;i<sizeofIntake;i++){
                System.out.printf("Intake[%d]:%s%n",i,intake[i]);
            }*/
            for(i=0; i<sizeofIntake; i++){

                for(j=0; j<uniqueCounter ;j++){
                    if((intake[i].toUpperCase()).equals(uniqueWord[j].toUpperCase())){
                        //System.out.printf("Intake[%d]:%s is a dupe of uniqueWord[%d]:%s%n",i,intake[i],j,uniqueWord[j]);
                        flag4dup = 1;

                        break;
                    }else {
                        flag4dup=0;

                    }
                }

                if(flag4dup == 0){
                    if(noDups ==""){
                        noDups = intake[i];
                    }else{
                        noDups = noDups + " "+ intake[i];
                    }

                    uniqueWord[uniqueCounter] = intake[i];
                    uniqueCounter++;
                }


            }
           /* for(i=0;i<uniqueCounter;i++){
                System.out.printf("uniqueWord[%d]:%s%n",i,uniqueWord[i]);
            }*/
            //System.out.printf("noDups has : %s : in it%n",noDups);
            FileWriter fw = new FileWriter(dataFile);
            fw.write(noDups);
            fw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void write(File outputFile) {

        try {

            String uniques = "";
            for(int i =0; i<uniqueCounter;i++) {
                if(uniques == ""){
                uniques = uniqueWord[i];
                }else{
                    uniques = uniques + " "+ uniqueWord[i];
                }
            }
           // System.out.printf("%nunique is : %s %n",uniques);

            FileWriter outputFilefw = new FileWriter(outputFile);

            outputFilefw.write(uniques);

            outputFilefw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

/*
This is what is in my version of problem 1 kept here for while I am testing
The dog barked and ran Jack and Jill went up a hill Arnold and Juan play cricket every evening The cat and the dog yowled and howled respectively
 */

}

