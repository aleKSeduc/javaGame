package dist;
import pers.*;
import java.lang.Math;

public class Dist {
Integer idSrc = 0;

public static Integer seekDist(Integer idSrc){
    Integer teamSrc = AbsPers.mapTeamPers.get(idSrc).get(0);
    Integer xSrc = AbsPers.mapTeamPers.get(idSrc).get(2);
    Integer ySrc = AbsPers.mapTeamPers.get(idSrc).get(3);

    Integer idTarget = -1;    
    double minDist = Double.MAX_VALUE;
    for (Integer i : AbsPers.mapTeamPers.keySet()){
        if (teamSrc != AbsPers.mapTeamPers.get(i).get(0) && AbsPers.mapInstPers.get(i).currentHP > 0){
            int xTarget = AbsPers.mapTeamPers.get(i).get(2);
            int yTarget = AbsPers.mapTeamPers.get(i).get(3);
            double dist = Math.sqrt(Math.pow(xTarget - xSrc, 2) + Math.pow(yTarget - ySrc, 2));
                if (dist < minDist){
                    minDist = dist;
                    idTarget = i;
                }

        }
    }
    return idTarget;
    }

    public static Integer seekDistToFriend(Integer idSrc){
        Integer teamSrc = AbsPers.mapTeamPers.get(idSrc).get(0);
        Integer xSrc = AbsPers.mapTeamPers.get(idSrc).get(2);
        Integer ySrc = AbsPers.mapTeamPers.get(idSrc).get(3);
    
        Integer idTarget = -1;    
        double minDist = Double.MAX_VALUE;
        for (Integer i : AbsPers.mapTeamPers.keySet()){
            if (teamSrc == AbsPers.mapTeamPers.get(i).get(0) && idSrc != i && AbsPers.mapInstPers.get(i).currentHP > 0 && AbsPers.mapInstPers.get(i).currentHP != 100){
                int xTarget = AbsPers.mapTeamPers.get(i).get(2);
                int yTarget = AbsPers.mapTeamPers.get(i).get(3);
                double dist = Math.sqrt(Math.pow(xTarget - xSrc, 2) + Math.pow(yTarget - ySrc, 2));
                    if (dist < minDist){
                        minDist = dist;
                        idTarget = i;
                    }
    
            }
        }
        return idTarget;
    }    
    public static Integer seekDistToShooter(Integer idSrc){
        Integer teamSrc = AbsPers.mapTeamPers.get(idSrc).get(0);
        Integer xSrc = AbsPers.mapTeamPers.get(idSrc).get(2);
        Integer ySrc = AbsPers.mapTeamPers.get(idSrc).get(3);
    
        Integer idTarget = -1;    
        double minDist = Double.MAX_VALUE;
        for (Integer i : AbsPers.mapTeamPers.keySet()){
            if (teamSrc == AbsPers.mapTeamPers.get(i).get(0) && idSrc != i && AbsPers.mapInstPers.get(i).currentHP > 0 && (AbsPers.mapTeamPers.get(i).get(1) == 0 || AbsPers.mapTeamPers.get(i).get(1) == 4)){
                int xTarget = AbsPers.mapTeamPers.get(i).get(2);
                int yTarget = AbsPers.mapTeamPers.get(i).get(3);
                double dist = Math.sqrt(Math.pow(xTarget - xSrc, 2) + Math.pow(yTarget - ySrc, 2));
                    if (dist < minDist){
                        minDist = dist;
                        idTarget = i;
                    }
            }
        }
        return idTarget;
    }    
}

