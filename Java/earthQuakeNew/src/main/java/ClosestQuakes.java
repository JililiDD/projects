import java.util.ArrayList;

/**
 * Created by Dingdang on 5/24/2017.
 */
public class ClosestQuakes {
    public static ArrayList<QuakeEntry> getClosest(ArrayList<QuakeEntry> rawData, Location loc, int howMany){
        ArrayList<QuakeEntry> resultList = new ArrayList<QuakeEntry>();
        for(int i = 0; i < howMany; i++){
            resultList.add(findClosest(rawData, loc));
        }
        rawData.addAll(resultList);
        return resultList;
    }

    public static QuakeEntry findClosest(ArrayList<QuakeEntry> rawData, Location loc){
        double minDistance = rawData.get(0).distanceTo(loc);
        int indexOfMinQE = 0;
        for (int i = 1; i < rawData.size(); i++){
            double tempDistance = rawData.get(i).distanceTo(loc);
            if(tempDistance < minDistance){
                indexOfMinQE = i;
                minDistance = tempDistance;
            }
        }
        return rawData.remove(indexOfMinQE);
    }
}
