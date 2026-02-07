package challenge_interface;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Mappable> mappables = new ArrayList<>();
        mappables.add(new Building("City Hall", UsageType.GOVERNMENT));
        mappables.add(new Building("Central Park", UsageType.ENTERTAINMENT));
        mappables.add(new Building("Sunset Apartments", UsageType.RESIDENTIAL));
        mappables.add(new Building("Tech Factory", UsageType.INDUSTRIAL));

        mappables.add(new UtilityLine("Main Street Power Line", UtilityType.ELECTRICITY));
        mappables.add(new UtilityLine("Downtown Water Line", UtilityType.WATER));
        mappables.add(new UtilityLine("Gas Line A", UtilityType.GAS));
        mappables.add(new UtilityLine("Fiber Optic Line 1", UtilityType.FIBER_OPTIC));
        mappables.add(new UtilityLine("Sewer Line B", UtilityType.SEWER));
        mappables.add(new UtilityLine("Telecom Line X", UtilityType.TELECOMMUNICATION));

        for (Mappable mappable : mappables) {
            Mappable.mapIt(mappable);
        }
    }
}
