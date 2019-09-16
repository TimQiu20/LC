class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] charCount = new int[26];
        char[] charArray = S.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            charCount[c - 'a']++;
        }
        int start = 0;
        int count = 0;
        List<Character> sublist = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            count++;
            if (charCount[c - 'a'] > 1 && !sublist.contains(c)) {
                charCount[c - 'a']--;
                sublist.add(c);
                continue;
            }
            if (charCount[c - 'a'] == 1 && sublist.isEmpty()) {
                list.add(count - start);
                start = count + 1;
                count = start;
                continue;
            }
            if (charCount[c - 'a'] == 1 && sublist.contains(c)) {
                sublist.remove((Character)c);
                if (sublist.isEmpty()) {
                    list.add(count - start);
                    start = count++;
                    count = start;
                    continue;
                }
                continue;
            }
            if (charCount[c - 'a'] > 1 && sublist.contains(c)) {
                charCount[c - 'a']--;
                continue;
            }
        }
        return list;
    }
}