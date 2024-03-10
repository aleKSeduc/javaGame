package pers;

public class Spearman extends AbsPers {
    {
    idDead = AbsPers.id - 1;
    strength = 11;
    magic = 4;
    armor = 6;
    weapon = 8;
    passHP = 11;
    initiative = 2;   
    }

    public Spearman(String name, int x, int y){
        super(name, x, y);
        AbsPers.mapTeamPers.get(idDead).set(4, initiative);
    }
    @Override
    public void step(AbsPers target){
        if (this.currentHP > 0){
            int xTarg = target.x;
            int yTarg = target.y;
            if ((Math.abs(xTarg - this.x) == 1 && yTarg == this.y) || (Math.abs(yTarg - this.y) == 1 && xTarg == this.x)){
                super.attack(target);
            }
            else {
                if (Math.abs(xTarg - this.x) >= Math.abs(yTarg - this.y)){
                    if (xTarg > this.x && yTarg != this.y){
                        while (xTarg != this.x){this.x++;}  
                    } else if (xTarg < this.x && yTarg != this.y){
                        while (xTarg != this.x) {this.x++;}
                    }else if (xTarg > this.x && yTarg == this.y){
                        while (xTarg != this.x + 1){this.x++;}
                        super.attack(target);
                        AbsPers.mapTeamPers.get(idDead).set(2, this.x);
                        AbsPers.mapTeamPers.get(idDead).set(3, this.y);
                            return;  
                    } else if (xTarg < this.x && yTarg == this.y){
                        while (xTarg != this.x - 1) {this.x++;}
                        super.attack(target);
                        AbsPers.mapTeamPers.get(idDead).set(2, this.x);
                        AbsPers.mapTeamPers.get(idDead).set(3, this.y);
                            return; 
                    }
                } else {
                    if (yTarg > this.y && xTarg != this.x){
                        while (yTarg != this.y){this.y++;}  
                    } else if (yTarg < this.y && xTarg != this.x){
                        while (yTarg != this.y) {this.y--;}
                    }else if (yTarg > this.y && yTarg == this.x){
                        while (yTarg != this.y + 1){this.y++;}
                        super.attack(target);
                        AbsPers.mapTeamPers.get(idDead).set(2, this.x);
                        AbsPers.mapTeamPers.get(idDead).set(3, this.y);
                            return;   
                    } else if (yTarg < this.y && yTarg == this.x){
                        while (yTarg != this.y - 1) {this.y--;}
                        super.attack(target);
                        AbsPers.mapTeamPers.get(idDead).set(2, this.x);
                        AbsPers.mapTeamPers.get(idDead).set(3, this.y);
                            return; 
                    }
                }  
                if (xTarg == this.x){
                    if (yTarg > this.y){
                        while (yTarg != this.y + 1) {this.y++;};
                    } else {
                        while (yTarg != this.y - 1) {this.y--;};}
                }
                if (yTarg == this.y){
                    if (xTarg > this.x){
                        while (xTarg != this.x + 1) {this.x++;};
                } else {
                    while (xTarg != this.x - 1) {this.x--;};}
                }
                super.attack(target);
                AbsPers.mapTeamPers.get(idDead).set(2, this.x);
                AbsPers.mapTeamPers.get(idDead).set(3, this.y);
                    return;
            }
            
            AbsPers.mapTeamPers.get(idDead).set(2, this.x);
            AbsPers.mapTeamPers.get(idDead).set(3, this.y);
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
    "      \"startHP\":         " + this.startHP + ",\n" +
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
