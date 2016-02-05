package stack.overflow.test;

import java.util.ArrayList;

/**
 * Created by Pankaj Nimgade on 05-02-2016.
 */
public enum Architecture {
    CATEGORYb, CATEGORY1, CATEGORY2, CATEGORY3, CATEGORY4;

    public static Architecture[] getValues(Performance perf) {
        ArrayList<Architecture> categories = new ArrayList<Architecture>();
        Architecture[] empty = null;
        switch (perf) {
            case PLa:
                categories.add(CATEGORYb);
                categories.add(CATEGORY2);
                break;
            case PLb:
                categories.add(CATEGORYb);
                categories.add(CATEGORY2);
                categories.add(CATEGORY3);
                break;
            case PLc:
                categories.add(CATEGORY1);
                categories.add(CATEGORY2);
                categories.add(CATEGORY3);
                break;
            case PLd:
                categories.add(CATEGORY2);
                categories.add(CATEGORY3);
                break;
            case PLe:
                categories.add(CATEGORY4);
                break;
        }
        return categories.toArray(new Architecture[categories.size()]); //runtime error
    }
}
