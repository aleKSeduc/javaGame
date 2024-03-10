package pers;

import Interfaces.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public abstract class AbsPers implements Stepable {
    public static HashMap<Integer, AbsPers> mapInstPers;
    public static HashMap<Integer, ArrayList<Integer>> mapTeamPers;
    public ArrayList<Integer> listTeamPers;
    public static ArrayList<String> listPers;
    public static ArrayList<Integer> listWhiteTeam;
    public static ArrayList<Integer> listBlackTeam;
    
    public static Integer id;
    protected String name;
    public Integer idDead;

    public Random random;
    protected int intellectVal;
    protected int enduranceVal;
    protected int agilityVal;
    
    protected int strength;
    protected int startHP;
    public int currentHP;
    protected int passHP;
    protected int magic;
    protected int armor;
    protected int weapon;
    public int numberOfShorts;
    protected int initiative;
    protected int mana;
    
    public int x;
    public int y;
    
    static {
        id = 0;
        mapInstPers = new HashMap<>();
        mapTeamPers = new HashMap<>();
        listWhiteTeam = new ArrayList<>();
        listBlackTeam = new ArrayList<>();
    }
    
    {
        random = new Random();    
        intellectVal = random.nextInt(0, 4);
        enduranceVal = random.nextInt(0, 4);
        agilityVal = random.nextInt(0, 4);
    }
    {
        startHP = 100;
        currentHP = 100;
        passHP = 0;
        strength = 0;
        magic = 0;
        armor = 0;
        weapon = 0;
        numberOfShorts = 0;
        initiative = 0;
        mana = 0;
    }    
    
    static {
        listPers = new ArrayList<String>(){{
            add("Crossbowman");
            add("Monk");
            add("Peasant");
            add("Rogue");
            add("Sniper");
            add("Spearman");
            add("Warlock");
        }};
    } 
    
    private AbsPers(){
        mapInstPers.put(AbsPers.id, this);
        AbsPers.id = id + 1;
    }
    
    public AbsPers(String name, int x, int y) {
        this();
        this.name = name;
        this.x = x;
        this.y = y;
        createMapPers();
        createListTeam();
    }
    public static void printMapTeamPers(){
        System.out.println(mapTeamPers.toString());
    }

    public void createMapPers(){
        mapTeamPers.put(AbsPers.id - 1, createListPers());
    }

    public ArrayList<Integer> createListPers(){
        ArrayList<Integer> listTeamPers = new ArrayList<>();
        Integer i = 0;
        if (this.name.startsWith("white")){i = 0;}
        else if (this.name.startsWith("black")){i = 1;}
        Integer j = (Integer) (listPers.indexOf(this.getClass().getSimpleName()));
        
            listTeamPers.add(i);
            listTeamPers.add(j);
            listTeamPers.add(this.x);
            listTeamPers.add(this.y);
            listTeamPers.add(this.initiative);
                return listTeamPers;
    }
     
    public void createListTeam(){ 
        if (this.name.startsWith("white")){listWhiteTeam.add(id - 1);}
        else if (this.name.startsWith("black")){listBlackTeam.add(id - 1);} 
    }

    public String getInfo() {
        int a = this.currentHP > 0 ? this.currentHP : 0;
        return String.format("%s HP: %d S: %d M: %d",
        this.name, a, this.numberOfShorts, this.mana);
    }

    // protected void healed() {
    //     this.currentHP = currentHP + passHP > this.startHP ? this.startHP : currentHP + passHP;
    // }

    public void attack(AbsPers target) {
        target.currentHP = target.currentHP - this.powerAttack();    
        if (target.currentHP < 1){
                AbsPers.listWhiteTeam.remove(target.idDead);
                AbsPers.listBlackTeam.remove(target.idDead);
        }
    }

    protected int powerAttack() {
        return this.strength + this.magic + this.weapon + this.intellectVal + this.enduranceVal + this.agilityVal;
    }
    
}
