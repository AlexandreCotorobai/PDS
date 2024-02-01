import java.util.HashMap;
import java.util.Map;

import startypes.*;

public class StarFactory {
    static Map<String, StarType> starTypes = new HashMap<String, StarType>();
    
    public static StarType getStarType(String classification) {
        StarType starType = starTypes.get(classification);
        if (starType == null) {
            switch (classification) {
                case "A":
                    starType = new AStar();
                    break;
                case "B":
                    starType = new BStar();
                    break;
                case "O":
                    starType = new OStar();
                    break;
                case "F":
                    starType = new FStar();
                    break;
                case "G":
                    starType = new GStar();
                    break;
                case "K":
                    starType = new KStar();
                    break;
                case "M":
                    starType = new MStar();
                    break;
                default:
                        throw new IllegalArgumentException("Unknown star type: " + classification);
            }
            starTypes.put(classification, starType);
        }
        return starType;
    }
}
