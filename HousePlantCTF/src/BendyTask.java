import java.util.Scanner;

public class BendyTask {
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter flag: ");
        String userInput = scanner.next();
        String input = userInput.substring("rtcp{".length(),userInput.length()-1);
        if (check(input)) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied!");
        }
    }

    public static boolean check(String input){
        boolean h = false;
        //21
        String flag = "r34l_g4m3rs_eXclus1v3";
        String theflag = "";
        int i = 0;
        if(input.length() != flag.length()){
            return false;
        }
        //0 - 7, theflag len = 7, starts at 0
        for(i = 0; i < flag.length()-14; i++){
            theflag += (char)((int)(flag.charAt(i)) + (int)(input.charAt(i+8)));
        }
        // 10 - 15; theflag len = 12, starts at 7
        for(i = 10; i < flag.length()-6; i++){
            theflag += (char)((int)(flag.charAt(i)) + (int)(input.charAt(i-8)));
        }
        // 15 - 21; the flag len = 18, starts at 12
        for(; i < flag.length(); i++){
            theflag += (char)((int)(flag.charAt(i-3)) + (int)(input.charAt(i)));
        }


        //ÒdÝ¾¤¤¾ÙàåÐcÝÆ¥ÌÈáÏÜ¦aã

        //len of flags = 18
        String[] flags = theflag.split("");
        // 0-9 loop; add 20 to each character of flags from 0-9
        for(i=0; i < (int)((flags.length)/2); i++){
            flags[i] = Character.toString((char)((int)(flags[i].charAt(0)) + 20));
        }


        //the flag len = 9
        theflag = theflag.substring(flags.length/2);
        //theflag = "ÄÑÓ¿ÂÒêá" flags = "øz§è§ñy÷¦"

        //0-9 add the flags which we updated before
        for(int k = 0; k < ((flags.length)/2); k++){
            theflag += flags[k];
        }
        return theflag.equals("ÄÑÓ¿ÂÒêáøz§è§ñy÷¦");
    }
}
