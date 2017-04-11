import classes.CaseInsensitiveTreeMap;
import classes.GenericCouple;

import java.util.Map;

/**
 * Created by simon.calabrese on 07/04/2017.
 */
public class MainClass {
    public static void main(String[] rgs) {
        CaseInsensitiveTreeMap<GenericCouple<Double,Double>,Double> map = new CaseInsensitiveTreeMap<>();
        map.put(new GenericCouple<>(1D,2D),0D);
        map.put(new GenericCouple<>(1D,2D),1D);
        map.entrySet().forEach(e -> {
            System.out.println(e.getKey());
        });


    }
}
