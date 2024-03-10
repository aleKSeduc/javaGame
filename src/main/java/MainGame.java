
import java.util.ArrayList;
import java.util.Random;

import dist.*;
import pers.*;
public class MainGame {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int r = random.nextInt(0, 7);
            int x = i < 10 ? i : i - 10;
            int y = i < 10 ? 0 : 9;
            String team = i < 10 ? "white" : "black";
            if (r == 0){
                new Crossbowman((team + AbsPers.listPers.get(r) + "_" + AbsPers.id), x, y);
            } else if (r == 1) {
                new Monk((team + AbsPers.listPers.get(r) + "_" + AbsPers.id), x, y);
            }else if (r == 2) {
                new Peasant((team + AbsPers.listPers.get(r) + "_" + AbsPers.id), x, y);
            }else if (r == 3) {
                new Rogue((team + AbsPers.listPers.get(r) + "_" + AbsPers.id), x, y);
            }else if (r == 4) {
                new Sniper((team + AbsPers.listPers.get(r) + "_" + AbsPers.id), x, y);
            }else if (r == 5) {
                new Spearman((team + AbsPers.listPers.get(r) + "_" + AbsPers.id), x, y);
            }else if (r == 6) {
                new Warlock((team + AbsPers.listPers.get(r) + "_" + AbsPers.id), x, y);
            }
        } 
        while ((!AbsPers.listWhiteTeam.isEmpty()) && (!AbsPers.listBlackTeam.isEmpty())) {
            
            System.out.println(AbsPers.listWhiteTeam.toString());
            System.out.println(AbsPers.listBlackTeam.toString());
            
            for  (Integer j : AbsPers.mapTeamPers.keySet())
            {
                if  ((AbsPers.mapTeamPers.get(j).get(4) == 3) && (AbsPers.listWhiteTeam.contains(j) || AbsPers.listBlackTeam.contains(j))){
                    if (Dist.seekDist(j) != -1)
                    {
                        AbsPers.mapInstPers.get(j).step(AbsPers.mapInstPers.get(Dist.seekDist(j)));
                    }
                }
            }
        
            for  (Integer j : AbsPers.mapTeamPers.keySet())
            {               
                if  ((AbsPers.mapTeamPers.get(j).get(4) == 2) && (AbsPers.listWhiteTeam.contains(j) || AbsPers.listBlackTeam.contains(j))){
                    if (Dist.seekDist(j) != -1)
                    {
                        AbsPers.mapInstPers.get(j).step(AbsPers.mapInstPers.get(Dist.seekDist(j)));
                    }
                }
            }    
            for  (Integer j : AbsPers.mapTeamPers.keySet())
            {               
                if  ((AbsPers.mapTeamPers.get(j).get(4) == 1) && (AbsPers.listWhiteTeam.contains(j) || AbsPers.listBlackTeam.contains(j))){      
                    if (Dist.seekDistToFriend(j) != -1)
                    {
                        AbsPers.mapInstPers.get(j).step(AbsPers.mapInstPers.get(Dist.seekDistToFriend(j)));
                    } else {AbsPers.mapInstPers.get(j).step(AbsPers.mapInstPers.get(j));}
                }
            }
            for  (Integer j : AbsPers.mapTeamPers.keySet())
            {           
                if  ((AbsPers.mapTeamPers.get(j).get(4) == 0) && (AbsPers.listWhiteTeam.contains(j) || AbsPers.listBlackTeam.contains(j))){
                    if (Dist.seekDistToShooter(j) != -1)
                    {
                        AbsPers.mapInstPers.get(j).step(AbsPers.mapInstPers.get(Dist.seekDistToShooter(j)));
                    }
                }
            }
            
            View.view();
            ArrayList<Integer> a = new ArrayList<Integer>(){{
                add(0);
                add(3);
                add(4);
                add(5);}};

                Integer q = 0;

            for (Integer i : AbsPers.listWhiteTeam){
                if (a.contains(AbsPers.mapTeamPers.get(i).get(1))){
                    q++;
                    if (AbsPers.mapInstPers.get(i).numberOfShorts == 0){q--;};
                }
            }
            for (Integer k : AbsPers.listBlackTeam){
                if (a.contains(AbsPers.mapTeamPers.get(k).get(1))){
                    q++;
                    if (AbsPers.mapInstPers.get(k).numberOfShorts == 0){q--;};
                }
            }
            if (q == 0) {System.out.println("No warries or arrows"); return;}
            }   
    }        
}

