package character.properties.stats;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Element;

import file.Property;
import file.Recordable;
import file.RecordableFactory;
import file.XMLEntry;

public class FactoryStats implements Stats {
private XMLEntry save;
private Map<String, Property> properties = new HashMap<String, Property>();
private int str;
private int dex;
private int con;
private int intl;
private int wis;
private int car;

public FactoryStats() {
    this.save = new XMLEntry((Recordable) this);
    this.setStr(10);
    this.setCon(10);
    this.setDex(10);
    this.setIntl(10);
    this.setWis(10);
    this.setCar(10);
    
}

public FactoryStats(int str, int dex, int con, int intl, int wis, int car) {
    this.save = new XMLEntry((Recordable) this);
    this.str = str;
    this.dex = dex;
    this.con = con;
    this.intl = intl;
    this.wis = wis;
    this.car = car;
}

public int getStr() {
    return str;
}

public void setStr(int str) {
    this.str = str;
}

public int getDex() {
    return dex;
}

public void setDex(int dex) {
    this.dex = dex;
}

public int getCon() {
    return con;
}

public void setCon(int con) {
    this.con = con;
}

public int getIntl() {
    return intl;
}

public void setIntl(int intl) {
    this.intl = intl;
}

public int getWis() {
    return wis;
}

public void setWis(int wis) {
    this.wis = wis;
}

public int getCar() {
    return car;
}

public void setCar(int car) {
    this.car = car;
}

@Override
public void updateSave() {
    this.save.addAtribute("Str", "" + this.str);
    this.save.addAtribute("Dex", "" + this.dex);
    this.save.addAtribute("Con", "" + this.con);
    this.save.addAtribute("Intl", "" + this.intl);
    this.save.addAtribute("Wis", "" + this.wis);
    this.save.addAtribute("Car", "" + this.car);
}

@Override
public XMLEntry getEntry() {
    this.updateSave();
    return this.save;
}

public Stats fromElement(Element e) {
    FactoryStats out = new FactoryStats();
    out.setStr(myParse(e.getAttribute("Str")));
    out.setCon(myParse(e.getAttribute("Con")));
    out.setDex(myParse(e.getAttribute("Dex")));
    out.setIntl(myParse(e.getAttribute("Intl")));
    out.setWis(myParse(e.getAttribute("Wis")));
    out.setCar(myParse(e.getAttribute("Car")));
    return null;
}

private static int myParse(String str) {
    if (str == null || str.isEmpty()) {
        throw new InvalidParameterException();
    } else {
        return Integer.parseInt(str);
    }
}

public String toString() {
    String out = new String();
    out += "Stats [";
    out += " Str: " + this.getStr();
    out += " Con: " + this.getCon();
    out += " Dex: " + this.getDex();
    out += " Intl: " + this.getIntl();
    out += " Wis: " + this.getWis();
    out += " Car: " + this.getCar();
    out += " ]";
    return out;
}

@Override
public RecordableFactory<?> getFactory() {
    return new StatsFactory();
}

public void addProperty(Property property) {
    this.properties.put(property.getHeader(), property);
}

@Override
public String getHeader() {
    return StatsFactory.header;
}

@Override
public Property getProperty(String property) {
    return this.properties.get(property);
}
}
