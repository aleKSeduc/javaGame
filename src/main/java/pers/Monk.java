package pers;


public class Monk extends AbsPers {
    {
    idDead = AbsPers.id - 1;
    strength = 11;
    magic = 4;
    armor = 6;
    weapon = 8;
    passHP = 11;
    initiative = 1;
    
    mana = 10;
}

    public Monk(String name, int x, int y){
        super(name, x, y);
        AbsPers.mapTeamPers.get(idDead).set(4, initiative);
    }
    
    @Override
    public void step(AbsPers target){
        if (this.currentHP > 0){
            if (this.mana > 9 && this.idDead < 10 && AbsPers.listWhiteTeam.size() < 8){
                for (Integer i : AbsPers.mapInstPers.keySet())
                {
                    if (i < 10 && AbsPers.mapInstPers.get(i).currentHP <= 0){
                        AbsPers.mapInstPers.get(i).currentHP = 100;
                        AbsPers.listWhiteTeam.add(i);
                        this.mana -= 10;
                        return;
                    }
                }

            } else if (this.mana > 9 && this.idDead > 9 && AbsPers.listBlackTeam.size() < 8){
                for (Integer i : AbsPers.mapInstPers.keySet())
                {
                    if (i > 9 && AbsPers.mapInstPers.get(i).currentHP <= 0){
                        AbsPers.mapInstPers.get(i).currentHP = 100;
                        AbsPers.listBlackTeam.add(i);
                        this.mana -= 10; 
                        return;
                    }
                }
            
            } else if (this.mana >= 2 && target.idDead != this.idDead){
                target.currentHP = 100;
                this.mana -= 2;
                return;
            } else if (this.mana < 2 && target.idDead != this.idDead) {this.mana++;}
        }
    }

    
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
