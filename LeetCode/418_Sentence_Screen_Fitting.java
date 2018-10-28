class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (rows == 0 || cols == 0) {
            return 0;
        }
        
        String record = "";
        for (String s : sentence) {
            record += s + " ";
        }
        
        int count = 0;
        int len = record.length();
        for (int i = 0; i < rows; i++) {
            count += cols;
            if (record.charAt(count % len) == ' ') {
                count++;
            } else {
                while (count > 0 && record.charAt((count - 1) % len) != ' ') {
                    count--;
                }
            }
        }
        
        return count / len;
    }
}