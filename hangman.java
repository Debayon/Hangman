import java.util.Random;
import java.util.Scanner;

public class hangman {
    private int correctGuess = 0;
    private int remainingAttempts = 8;
    private char[] word;
    private char curChar;
    private char[] outputArr;
    private int discovered = 0;
    private int Congratulate = 0;
    //private int letterCount;

//    private void getLetterCount(){
//        this.letterCount = this.word.length;
//    }
    private void welcome(){
        System.out.println("Welcome to Hangman");
    }

    private void wordRetrieve(){
        Random rand = new Random();
        int randInt = rand.nextInt(10);
        HangmanLexicon hL = new HangmanLexicon();
        this.word = (hL.getWord(randInt)).toCharArray();
    }

    private void checkInput(char outArr[]){
        int flag = 0;
        for(int i=0;i<this.word.length;i++){
            if(this.curChar == this.word[i]){
                flag = 1;
                outArr[i] = this.curChar;
                this.discovered = this.discovered + 1;
                if(this.discovered == this.word.length){
                    this.Congratulate = 1;
                }
            }
        }
        if(flag == 0){
            this.remainingAttempts = this.remainingAttempts - 1;
        }
    }

    private void getInput(){
        Scanner scan = new Scanner(System.in);
        this.curChar = scan.next().charAt(0);
        System.out.println("Your current guess: "+this.curChar);
//        this.checkInput(this.curChar);

    }

    private void curDiscovery(char outArr[]){
        System.out.print("The word now looks like this: ");
        for(int i = 0;i<this.word.length;i++){
            System.out.print(outArr[i]+" ");
        }
        System.out.print("\n");
        System.out.println("\nYou have " + this.remainingAttempts+" attempts left.");
    }

    private void outputArrInit(char outArr[]){
        for(int i=0;i<this.word.length;i++){
            outArr[i] = '_';
        }
    }




    public void playHangman(){
        this.welcome();
        this.wordRetrieve();
        char[] outArr = new char[this.word.length];
        this.outputArrInit(outArr);

        while(this.remainingAttempts>0 && discovered < this.word.length){
            this.curDiscovery(outArr);
            this.getInput();
            this.checkInput(outArr);
        }

        if(this.Congratulate == 1){
            System.out.println("You completely guessed the word: "+String.valueOf(this.word)+"\nYou win!");
        }
        else {
            System.out.println("You're completely hung.\nThe word was "+String.valueOf(this.word)+"\nYou Lose.");
        }

//        this.getLetterCount();



//        System.out.print("\n");
//        System.out.print(this.word);

//        System.out.println("Your guess: "+this.curChar);
//        this.curChar = Character.toUpperCase(this.curChar);
//        for(int i = 0; i<this.word.length; i++){
//            if(this.curChar == this.word[i]){
//                System.out.print(this.curChar+" ");
//            }
//            else {
//                System.out.print("_ ");
//            }
//        }
    }
}
