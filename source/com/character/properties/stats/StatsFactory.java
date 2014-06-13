package character.properties.stats;

import org.w3c.dom.Element;

import file.RecordableFactory;

public class StatsFactory extends RecordableFactory<Stats> {
static final String header = "Stats";

public String getHeader() {
    return header;
}

public Stats newInstance() {
    return new FactoryStats();
}

public Stats fromElement(Element e) throws Exception {
    FactoryStats out = new FactoryStats();
    out.setStr(Integer.parseInt(e.getAttribute(Stats.STR)));
    out.setDex(Integer.parseInt(e.getAttribute(Stats.DEX)));
    out.setCon(Integer.parseInt(e.getAttribute(Stats.CON)));
    out.setIntl(Integer.parseInt(e.getAttribute(Stats.INTL)));
    out.setWis(Integer.parseInt(e.getAttribute(Stats.WIS)));
    out.setCar(Integer.parseInt(e.getAttribute(Stats.CAR)));
    return out;
}

}
