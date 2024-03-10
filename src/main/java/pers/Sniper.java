package pers;


public class Sniper extends AbsPers {
    {
    idDead = AbsPers.id - 1;
    strength = 11;
    magic = 4;
    armor = 6;
    weapon = 8;
    passHP = 11;
    initiative = 3;
    numberOfShorts = 10;
    }

    public Sniper(String name, int x, int y){
        super(name, x, y);
        AbsPers.mapTeamPers.get(idDead).set(4, initiative);
    }


    @Override
    public void step(AbsPers target){
        if (currentHP > 0 && numberOfShorts > 0){
            super.attack(target);
            this.numberOfShorts -= 1;
        }}
    
    @Override
    public String toString(){
    return String.format("{\n" +
    "    \"init_Pers\": {\n " +
    "      \"id\":              " + idDead + ",\n" +
    "      \"hero\":            " + this.getClass().getSimpleName() + ",\n" +
    "      \"name\":            " + name  + "\n" +
    "     }\n" +
    "    \"property\": {\n" +
    "      \"intellectVal\":    " + intellectVal + ",\n" +
    "      \"enduranceVal\":    " + enduranceVal + ",\n" +
    "      \"agilityVal\":      " + agilityVal + "\n" +
    "     }\n" + 
    "    \"state\": {\n" +
    "      \"startHP\":         " + startHP + ",\n" +
    "      \"currentHP\":       " + this.currentHP + ",\n" +
    "      \"passHP\":          " + passHP + ",\n" +
    "      \"strength\":        " + strength  + "\n" +
    "      \"magic\":           " + magic + ",\n" +
    "      \"armor\":           " + armor + ",\n" +
    "      \"weapon\":          " + weapon + ",\n" +
    "      \"numberOfShorts\":  " + numberOfShorts + ",\n" +
    "      \"initiative\":      " + initiative + ",\n" +
    "    \"point\": {\n" +
    "      \"x\":               " + this.x + ",\n" +
    "      \"y\":               " + this.y + ",\n" +
    
    "}\n");
    }


}
