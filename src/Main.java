import java.util.ArrayList;
import java.util.Random;

public class Main {
    static Random randomeGenerator = new Random();

    public static void main(String[] args) {
        System.out.println("Welcome to my fighting game");

        //Contains the stats of the first charachter HP
        ArrayList<Integer> stat1 = new ArrayList<>();
        stat1.add(100);
        stat1.add(randomeGenerator.nextInt(20, 81));
        stat1.add(randomeGenerator.nextInt(20, 81));

        ArrayList<Integer> stat2 = new ArrayList<>();
        stat2.add(100);
        stat2.add(randomeGenerator.nextInt(20, 81));
        stat2.add(randomeGenerator.nextInt(20, 81));

        //Print character info to check it works
        System.out.println("Character 1 has " + stat1.get(0) + " hp and " + stat1.get(1) + " mana");
        System.out.println("Character 2 has " + stat2.get(0) + " hp and " + stat2.get(1) + " mana");

        //Character 1 hits charachter 2 with standard attack
        int newHp = standardAttack(stat1.get(2), stat2.get(0));
        stat2.set(0, newHp); //Puts the new Hp to courrent HP in stats2
        System.out.println("Fighter number 2 now has " + stat2.get(0) + " HP");


        ////Character 1 hits charachter 2 with standard attack
        int[] hpMana = specialAttack(stat1.get(2), stat1.get(1), stat1.get(0));
        stat2.set(0, hpMana[0]); //Puts the new Hp to courrent HP in stats2
        stat1.set(0, hpMana[1]); //Puts the new mana to courrent mana in stats1
        System.out.println("Fighter number 2 now has " + stat2.get(0) + " HP");

        //TODO: Fix game loop metofh
        //      starts wit user intraction
        //       After let ai hit back with randome choice
        //     If time: Make AI more clerver in attack choice
        //      Let user choose whick charachter?
    }

    //Method for standars attack
    public static int standardAttack(int damage, int hp) {
        int chance = randomeGenerator.nextInt(100); //generates a number 0-99

        //Chance of crit is appx 1/3
        if (chance < 67) {
            hp = hp - damage / 6;
            System.out.println("Regular hit");
        } else {
            hp = hp - damage;
            System.out.println("Critical hit");
        }
        return hp;

    }

    //Metohod gor special attack
    public static int[] specialAttack(int damage, int mana, int hp) {
        //Special attack is only availbe if therr is enough mana
        if (mana - 20 < 0) {
            System.out.println("You are low on mana. Special attack is not availble");
        } else {
            System.out.println("Special attack");
            hp = (int) (hp - 0.25 * damage);//calculate a double, (int)  cast double
            mana -= 20; //Mana = mana -20
        }
        int[] returnArray = {hp, mana};

        return returnArray; //Contains HP nad mana
    }


}

//skriv sout + tab för utskrift
//System.out.println("Första");
//System.out.println("andra");