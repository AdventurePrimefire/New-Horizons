package character.properties.stats;

import file.Recordable;

public interface Stats extends Recordable {
public static final String STR = "Str";
public static final String DEX = "Dex";
public static final String CON = "Con";
public static final String INTL = "Intl";
public static final String WIS = "Wis";
public static final String CAR = "Car";

public default String getHeader() {
    return StatsFactory.header;
}

/**
 * Sets the str.
 * 
 * @param str
 *            new str.
 */
public void setStr(int str);

/**
 * @return
 */
public int getStr();

/**
 * Sets the dex.
 * 
 * @param dex
 *            new dex.
 */
public void setDex(int dex);

/**
 * 
 * @return
 */
public int getDex();

/**
 * Sets the con.
 * 
 * @param dex
 *            new dex.
 */
public void setCon(int dex);

/**
 * 
 * @return
 */
public int getCon();

/**
 * Sets the wis.
 * 
 * @param wis
 *            new wis.
 */
public void setWis(int wis);

public int getWis();

/**
 * Sets the intl.
 * 
 * @param intel
 *            new intl.
 */
public void setIntl(int intel);

public int getIntl();

/**
 * Sets the car
 * 
 * @param car
 *            new car.
 */
public void setCar(int car);

public int getCar();
}
