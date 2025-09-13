import java.util.ArrayList;
import java.util.Random;

public class Main {
    static Random randomeGenerator = new Random();

    public static void main(String[] args) {
        System.out.println("Welcome to my fighting game");

        //Contains the stats of the first charachter HP
        ArrayList<Integer> stat1 = new ArrayList<>();
        stat1.add(100);
        stat1.add(randomeGenerator.nextInt(20,81));
        stat1.add(randomeGenerator.nextInt(20,81));

        ArrayList<Integer> stat2 = new ArrayList<>();
        stat2.add(100);
        stat2.add(randomeGenerator.nextInt(20,81));
        stat2.add(randomeGenerator.nextInt(20,81));

        //Print character info to check it works
        System.out.println("Character 1 has " + stat1.get(1) + " mana");

        int newHp= standardAttack(stat1.get(2), stat2.get(0));
        stat2.set(0, newHp); //Puuts the new Hp to courrent HP in stats2
        System.out.println("Fighter number 2 now has " + stat2.get(0) + " HP");

    }

    //Method for standars attack
    public static int standardAttack(int damage, int hp){
        int chance = randomeGenerator.nextInt(100); //generates a number 0-99

        //Chance of crit is appx 1/3
        if (chance < 67){
            hp = hp - damage / 6;
            System.out.println("Regular hit");
        }else {
            hp = hp - damage;
            System.out.println("Critical hit");
        }
        return hp;

    }
}

//skriv sout + tab för utskrift
//System.out.println("Första");
//System.out.println("andra");