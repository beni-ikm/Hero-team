package HeroCreationBetterVersion;

public class Stats {

    private int stat;

    public Stats(int stat){
        if (validStat(stat)){
            this.stat = stat;
        }
    }

    public boolean validStat(int stat){
        if (stat > 2 || stat < 21) {
            return true;
        }
        return false;
    }

}
