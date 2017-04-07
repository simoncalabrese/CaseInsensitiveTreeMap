import classes.CaseInsensitiveTreeMap;

import java.util.Map;

/**
 * Created by simon.calabrese on 07/04/2017.
 */
public class MainClass {
    public static void main(String[] rgs) {
        CaseInsensitiveTreeMap<Double,Double> map = new CaseInsensitiveTreeMap<>();
        map.put(1D,0D);
        map.put(1.1D,1D);
        for(Map.Entry<Double,Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " + " + entry.getValue());
        }

    }
}
