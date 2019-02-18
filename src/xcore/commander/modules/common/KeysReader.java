package xcore.commander.modules.common;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class for work with keys on command input
 *
 * @author Arthur Kupriyanov
 * @version 1.1
 */
public class KeysReader {
    /**
     * Map with theirs values, if key value not stated, value - empty ("")
     * version: 1.2
     * @param words array of keys and values, keys must start with "-" or "--"
     * @return map as format key=value
     */
    public static Map<String, String> readKeys(String[] words){
        Map<String, String> keyMap = new HashMap<>();

        String reservedKey = null;

        StringBuilder value = new StringBuilder();

        boolean firstWord = true;
        boolean isOneWord = true;

        for (String word: words
             ) {

            if (word.matches("-[a-z]") || word.matches("--[a-z#_]*")) {
                // Если ключ пустой
                if (reservedKey != null){
                    if(isOneWord) keyMap.put(reservedKey, value.toString());
                    else{
                        keyMap.put(reservedKey, value.toString());

                    }

                    isOneWord = true;
                    firstWord = true;
                    value = new StringBuilder();
                }

                reservedKey = word;

            } else if (reservedKey != null) {
                if (!firstWord){
                    value.append(" ");
                    isOneWord = false;
                }
                else firstWord = false;

                value.append(word);
            }

            if (word.matches("-[a-z]*")){
                String[] keys = word.split("");
                for (String key: keys
                     ) {
                    if(key.matches("[a-z]")) {
                        keyMap.put("-"+key, "");
                    }
                }
            }
        }

        if (reservedKey != null){ keyMap.put(reservedKey, value.toString()); }

        if (keyMap.isEmpty()){
            keyMap.put("error","empty");
        }
        return keyMap;
    }

    /**
     * Ordered keys of values map
     * version: 1.0
     * @param words array of keys and values, keys must start with "-" or "--"
     * @return map as format [index, [key, value]]
     */
    public static TreeMap<Integer, Map<String, String>> readOrderedKeys(String[] words){
        TreeMap<Integer, Map<String, String>> response = new TreeMap<>();

        String reservedKey = null;

        int counter = 0;

        for (String word: words
        ) {

            if (word.matches("-[a-z]") || word.matches("--[a-z]*")) {

                // If key is empty

                if (reservedKey != null){
                    Map<String, String> keyMap = new HashMap<>();
                    keyMap.put(reservedKey, "");
                    response.put(counter, keyMap);
                    counter++;

                }

                reservedKey = word;
            } else if (reservedKey != null){
                Map<String, String> keyMap = new HashMap<>();
                keyMap.put(reservedKey, word);
                reservedKey = null;

                response.put(counter, keyMap);
                counter++;

            }else if (word.matches("-[a-z]*")) {
                String[] keys = word.split("");
                for (String key : keys
                ) {
                    if (key.matches("[a-z]")) {
                        Map<String, String> keyMap = new HashMap<>();
                        keyMap.put("-" + key, "");
                        response.put(counter, keyMap);
                        counter++;
                    }
                }
            }



        }

        if (reservedKey != null) {
            Map<String, String> temp = new HashMap<>();
            temp.put(reservedKey, "");
            if (response.isEmpty()) {
                response.put(1, temp);
            } else {
                response.put(response.lastKey() + 1, temp);
            }
        }
        return response;
    }

}
