```java
// Runtime: 91 ms (Top 91.57%) | Memory: 51.6 MB (Top 89.43-)
class TopVotedCandidate {
    int[] persons;
    int[] times;
    int length;
    TreeMap<Integer, Integer> voteCount;
    TreeMap<Integer, Integer> voteLead;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        length = times.length - 1;
        int leadCount = 0;
        int leadPerson = - 1;
        voteCount = new TreeMap<>();
        voteLead = new TreeMap<>();
        for (int i = 0; i <= length; i++) {
            int newCount = voteCount.getOrDefault(persons[i], 0) + 1;
            voteCount.put(persons[i], newCount);
            if (newCount >= leadCount) {
                leadCount = newCount;
                leadPerson = persons[i];
            }
            voteLead.put(times[i], leadPerson);
        }
    }

    public int q(int t) {
        int leadPerson = - 1;
        if (voteLead.containsKey(t)) {
            leadPerson = voteLead.get(t);
        } else if (t < times[0]) {
            leadPerson = voteLead.get(times[0]);
        } else if (t > times[length]) {
            leadPerson = voteLead.get(times[length]);
        } else {
            int candidateTime = times[(voteLead.floorKey(t) != null) ? (voteLead.floorKey(t)) : 0];
            leadPerson = voteLead.get(candidateTime);
        }
        return leadPerson;
    }
}
```