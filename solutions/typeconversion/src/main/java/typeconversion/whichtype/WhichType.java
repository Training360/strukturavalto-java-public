package typeconversion.whichtype;

import java.util.ArrayList;
import java.util.List;

public class WhichType {

    public List<Type> whichType(String s) {
        List<Type> types = new ArrayList<>();
        for (Type type: Type.values()) {
            Long value = Long.parseLong(s);
            if (value > type.getMinValue() && value < type.getMaxValue()) {
                types.add(type);
            }
        }
        return types;
    }
}
