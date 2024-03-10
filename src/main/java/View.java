import pers.AbsPers;
import java.util.Collections;
public class View {
    private static int step = 1;
    private static final int[] l = {0};
    private static final String top10 = formatDiv("a  ") + String.join("  ", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("  -c");
    private static final String midl10 = formatDiv("d  ") +  String.join("  ", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("  -f");
    private static final String bottom10 = formatDiv("g  ") + String.join("  ", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("  -i");
    private static void tabSetter(int cnt, int max){
        int dif = max - cnt + 2;
        if (dif>0) System.out.printf("%" + dif + "s", "\t"); else System.out.print("\t");
    }
    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
    private static String getChar(int x, int y){
        String out = "|   ";
        for (Integer i : AbsPers.mapTeamPers.keySet()){
            if (AbsPers.mapTeamPers.get(i).get(2) == x && AbsPers.mapTeamPers.get(i).get(3) == y){
                if (AbsPers.mapInstPers.get(i).currentHP < 0) {
                    String s = i > 9 ? "" + i : "0" + i;
                    out = "|" + (AnsiColors.ANSI_RED + AbsPers.mapInstPers.get(i).getInfo().charAt(5) + s + AnsiColors.ANSI_RESET);
                    break;
                }
                if (AbsPers.listBlackTeam.contains(i)) out = "|" + (AnsiColors.ANSI_GREEN + AbsPers.mapInstPers.get(i).getInfo().charAt(5) + i + AnsiColors.ANSI_RESET);
                if (AbsPers.listWhiteTeam.contains(i)) out = "|" + (AnsiColors.ANSI_BLUE + AbsPers.mapInstPers.get(i).getInfo().charAt(5) + 0 + i + AnsiColors.ANSI_RESET);
                break;
            }
        }
        return out;
    }
    public static void view() {
        if (step == 1 ){
            System.out.print(AnsiColors.ANSI_RED + "First step" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step:" + step + AnsiColors.ANSI_RESET);
        }
        step++;
        //Main.allTeam.forEach((v) -> l[0] = Math.max(l[0], v.toString().length()));
        l[0] = 20;
        System.out.print("_".repeat(l[0]*2));
        System.out.println("");
        System.out.print(top10 + "    ");
        System.out.print("White side             ");
        ////for (int i = 0; i < l[0]-9; i++)
        //System.out.print(" ".repeat(l[0]-9));
        tabSetter(22, 20);
        System.out.println("\tBlack side");
        for (int i = 0; i < 10; i++) {
            System.out.print(getChar(0, i));
        }
        System.out.print("|    ");
        System.out.print(AbsPers.mapInstPers.get(0).getInfo());
        tabSetter(22, 20);
        //tabSetter(Main.holyTeam.get(0).toString().length(), l[0]);
        System.out.println(AbsPers.mapInstPers.get(10).getInfo());
        System.out.println(midl10);

        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.print(AbsPers.mapInstPers.get(i).getInfo());
            //System.out.print(Main.holyTeam.get(i-1));
            tabSetter(22, 20);
            //tabSetter(Main.holyTeam.get(i-1).toString().length(), l[0]);
            System.out.println(AbsPers.mapInstPers.get(10 + i).getInfo());
            //System.out.println(Main.darkTeam.get(i-1));
            System.out.println(midl10);
        }
        for (int j = 0; j < 10; j++) {
            System.out.print(getChar(9, j));
        }
        System.out.print("|    ");
        System.out.print(AbsPers.mapInstPers.get(9).getInfo());
        //System.out.print(Main.holyTeam.get(9));
        tabSetter(26, 20);
        //tabSetter(Main.holyTeam.get(9).toString().length(), l[0]);
        System.out.println(AbsPers.mapInstPers.get(19).getInfo());
        //System.out.println(Main.darkTeam.get(9));
        System.out.println(bottom10);
    }
}
