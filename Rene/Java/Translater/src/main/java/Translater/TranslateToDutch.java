package Translater;

public class TranslateToDutch {

    public String translate(String word) {
        String translatedWord = "";
        for (DictionaryTypes dictionaryType : DictionaryTypes.values()) {
            IDictionaryAdapter dictionary = DictionaryFactory.getDictionaryAdapter(dictionaryType);
            translatedWord = dictionary.translate(word);

            if(translatedWord != null && !translatedWord.equals("")){
                break;
            }
        }
        return translatedWord == null ? "" : translatedWord;
    }
}
