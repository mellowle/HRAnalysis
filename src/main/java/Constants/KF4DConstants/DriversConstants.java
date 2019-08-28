package Constants.KF4DConstants;

import entity.ScoreInterval;

import java.util.LinkedHashMap;
import java.util.Map;

public class DriversConstants {
    public static final Map<String, ScoreInterval> DRIVERS_SCORE_INTERVAL;
    public static final String TABLE_INTERVAL = "d_drivers_interval";
    public static final double POINT_DRIVER = 100d / 6;

    public static final double UCP_BALANCE = 3;
    public static final double UCP_CHALLENGE = 7;
    public static final double UCP_COLLABORATION = 6.25;
    public static final double UCP_INDEPENDENCE = 6;
    public static final double UCP_POWER = 5.75;
    public static final double UCP_STRUCTURE = 3;

    static {
        DRIVERS_SCORE_INTERVAL = new LinkedHashMap<>();
        DRIVERS_SCORE_INTERVAL.put("balance", new ScoreInterval("balance", 0, DriversConstants.POINT_DRIVER));
        DRIVERS_SCORE_INTERVAL.put("challenge", new ScoreInterval("challenge", 0, DriversConstants.POINT_DRIVER));
        DRIVERS_SCORE_INTERVAL.put("collaboration", new ScoreInterval("collaboration", 0, DriversConstants.POINT_DRIVER));
        DRIVERS_SCORE_INTERVAL.put("independence", new ScoreInterval("independence", 0, DriversConstants.POINT_DRIVER));
        DRIVERS_SCORE_INTERVAL.put("power", new ScoreInterval("power", 0, DriversConstants.POINT_DRIVER));
        DRIVERS_SCORE_INTERVAL.put("structure", new ScoreInterval("structure", 0, DriversConstants.POINT_DRIVER));
    }
}
