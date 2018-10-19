class Solution {
    class Person {
        int account;
        Set<Person> friends;

        Person(int account) {
            this.account = account;
            this.friends = new HashSet<>();
        }
    }

    class Helper {
        Person p;
        int amount;
        
        Helper(Person p, int amount) {
            this.p = p;
            this.amount = amount;
        }
    }

    public Set<Person> commonFriends(Person p1, Person p2) {
        Set<Person> res = new HashSet<>();
        if (p1 == null || p2 == null) {
            return res;
        }

        for (Person friend : p1.friends) {
            if (p2.friends.contains(friend)) {
                res.add(friend);
            }
        }

        return res;
    }

    public List<Person> recommendFriends(Person p1, Person p2) {
        List<Person> res = new ArrayList<>();
        if (p1 == null || p2 == null) {
            return res;
        }

        Queue<Helper> pq = new PriorityQueue<Helper>((o1, o2) -> {
            return o2.amount - o1.amount;
        });

        for (Person friend : p2.friends) {
            Helper p = new Helper(friend, 0);
            if (p1.friends.contains(friend)) {
                continue;
            }
            Set<Person> set = commonFriends(p1, friend);
            p.amount = set.size();
            pq.offer(p);
        }

        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }

        return res;
    }
}


