public class BreakableSolution {
        public static String reverse(){
        String theflag = "ÒdÝ¾¤¤¾ÙàåÐcÝÆ¥ÌÈáÏÜ¦aã";
        String flag = "k33p_1t_in_pl41n";
        int fl = 14;
        char[] input = new char[16];

        for(int i = 2; i < flag.length(); i++){
            input[i-2] = (char) ((int)(theflag.charAt(fl+i-2)) - (int)(flag.charAt(i)));
        }
        for(int i = 0; i < flag.length()-2; i++){
            input[i+2] = (char) ((int) theflag.charAt(i) - (int)flag.charAt(i));
        }

        return String.valueOf(input);
    }
}
