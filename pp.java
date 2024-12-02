import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Source {
    private HashMap<Character, String> map;
    
    public Source() {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        
        if (digits == null || digits.isEmpty()) {
            return result; // Return empty for invalid input
        }
        
        result.add(""); // Initialize with an empty string for combination logic
        
        for (int i = 0; i < digits.length(); i++) {
            char digit = digits.charAt(i);
            if (!map.containsKey(digit)) {
                continue; // Skip invalid digits
            }
            
            String letters = map.get(digit);
            ArrayList<String> temp = new ArrayList<>();
            
            for (String str : result) {
                for (char letter : letters.toCharArray()) {
                    temp.add(str + letter);
                }
            }
            
            result = temp;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Source source = new Source();
        
        String digits = scanner.nextLine();
        
        ArrayList<String> combinations = source.letterCombinations(digits);
        System.out.println(combinations);
        
        scanner.close();
    }
}
