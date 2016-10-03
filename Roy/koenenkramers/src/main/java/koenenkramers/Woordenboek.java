package koenenkramers;

/**
 * Created by royho on 3-10-2016.
 */
public class Woordenboek {
    public enum enumDict {
        KOENEN, KRAMERS
    }

    private static Woordenboek instance = null;

    private Woordenboek() {

    }

    public Dictionary getDictionary(enumDict enumDictionary) {
        switch (enumDictionary) {
            case KOENEN:
                return new KoenenAdapter();
            case KRAMERS:
                return new KramersAdapter();
            default:
                return null;
        }
    }

    private synchronized static void createInstance() {
        if(instance == null)
            instance = new Woordenboek();
    }

    public static Woordenboek getInstance() {
        if(instance == null)
            createInstance();
        return instance;
    }

    public String translate(String word) {
        if(getDictionary(enumDict.KOENEN).getTranslation(word) != null) {
            return getDictionary(enumDict.KOENEN).getTranslation(word);
        } else if(getDictionary(enumDict.KRAMERS).getTranslation(word) != null) {
            return getDictionary(enumDict.KRAMERS).getTranslation(word);
        }
        return null;
    }
}
