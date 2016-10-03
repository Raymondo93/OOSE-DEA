package Translater;

public class DictionaryFactory {
    public static IDictionaryAdapter getDictionaryAdapter(DictionaryTypes dictType) {

        if(dictType == null)
            return null;

        switch (dictType){
            case KOENEN:
                return new KoenenAdapter();
            case KRAMERS:
                return new KramerAdapter();
            default:
                return null;
        }
    }
}
