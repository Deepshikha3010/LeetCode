/**
 * Godaddy
 * Texas Poker
 * 让写一个function whoWins（hand1, hand2）{}, params hand1, hand2 是两个string， 
 * 每个hand是这样子的'JD 10C 4H 2H 5H', 代表手里的五张牌，每两张牌之间用空格分开，
 * 每一张牌第一个或者前两个letter代表value，最后一个letter代表花色。
 * 然后只需要考虑flush，straight， three of a kind， two pair， one pair， high card这几种。
 * 一边写一边和面试官聊，感觉面试官对code的structure要求很高。还好最后都写完了，test case也过了
 * 
 * Solution 1: 时间复杂度nlogn, 空间复杂度n
 */

/**Solution 1 */
class Solution {
    private class Poker{
        int number;
        String letter;
        Poker(int number, String letter){
            this.number = number;
            this.letter = letter;
        }
    }

    Comparator<Poker> comp = new Comparator<Poker>(){
        public int compare(Poker p1, Poker p2){
            return p1.number - p2.number;
        }
    };

    public boolean whoWins(String hand1, String hand2){
        Poker[] pokers1 = getPokers(hand1);
        Poker[] pokers2 = getPokers(hand2);
        if(isFlush(pokers1) && isFlush(pokers2)){
            return highCards(pokers1) - highCards(pokers2);
        }else if(isFlush(pokers1)){
            return true;
        }else if(isFlush(pokers2)){
            return false;
        }else if(isStraight(pokers1) && isStraight(pokers2)){
            return pokers1[0].number > pokers2[0].number;
        }else if(isStraight(pokers1)){
            return true;
        }else if(isStraight(pokers2)){
            return false;
        }else if(howManyPairs(pokers1) > howManyPairs(pokers2)){
            return true;
        }else if(howManyPairs(pokers1) < howManyPairs(pokers2)){
            return false;
        }else{
            return highCards(pokers1) - highCards(pokers2);
        }
        return 0;
    }

    private int highCards(Pokers[] pokers){
        int score = 0;
        for(Poker poker : pokers){
            score += poker.number;
        }
        return score;
    }

    private boolean isFlush(Poker[] pokers){
        String cur = pokers[0].letter;
        for(Poker poker : pokers){
            if(!poker.letter.equals(cur)){
                return false;
            }
        }
        return true;
    }

    private boolean isStraight(Poker[] pokers){
        for(int i = 1; i < pokers.length; i++){
            if(pokers[i].number - pokers[i - 1].number != 1){
                return false;
            }
        }
        return true;
    }

    private int howManyPairs(Poker[] pokers){
        Map<String, Integer> map = new HashMap<>();
        for(Poker poker : pokers){
            if(map.containsKey(poker.letter)){
                map.put(poker.letter, map.get(letter) + 1);
            }else{
                map.put(poker.letter, 0);
            }
        }
        int numOfPairs = 0;
        for(int num : map.values()){
            numOfPairs = Math.max(numOfPairs, num);
        }
        return numOfPairs;
    }

    private Poker[] getPokers(String hand){
        Map<String, Integer> pokerValue = getPokerValue();
        String[] pokerStrs = hand.split(" ");
        Poker[] pokers = new Poker[5];
        PriorityQueue<String[]> pq = new PrioriyQueue<>(comp);
        for(String pokerStr : pokerStrs){
            String letter = pokerStr.substring(pokerStr.length() - 1);
            String number = pokerValue.get(pokerStr.substring(0, pokerStr.length() - 1));
            Poker poker = new Poker(number, letter);
            pq.offer(poker);
        }
        int i = 0;
        while(!pq.isEmpty()){
            Poker poker = pq.poll();
            pokers[i] = poker;
        }
        return pokers;
    }

    private Map<String, Integer> getPokerValue(){
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10", 10);
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
    }
}