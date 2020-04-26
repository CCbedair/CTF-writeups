public class BendySolution {
    public static String reverse() {
        char[] input = new char[21];
        //String theflag = "ÄÑÓ¿ÂÒêáøz§è§ñy÷¦";
        String theflag="äfÔÝeãÄÑÓ¿ÂÒêá";
        String flag = "r34l_g4m3rs_eXclus1v3";

        // 15 - 21; the flag len = 18
        for(int i=15; i < flag.length(); i++){
            input[i] = (char)((int)theflag.charAt(12+i-15) -(int)flag.charAt(i-3));
        }
        // 10 - 15; theflag len = 12
        for(int i = 10; i < flag.length()-6; i++){
            input[i-8] = (char)((int)theflag.charAt(7+i-10) - (int)flag.charAt(i));
        }

        //0 - 7, theflag len = 7, starts at 0
        for(int i = 0; i < flag.length()-14; i++){
            input[i+8] = (char)((int) theflag.charAt(i) - (int) flag.charAt(i));
        }

        return String.valueOf(input);
    }

}
