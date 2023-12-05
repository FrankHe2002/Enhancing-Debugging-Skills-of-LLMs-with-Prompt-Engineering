```java
// Runtime: 27 ms (Top 87.99%) | Memory: 52.8 MB (Top 24.67%)
class ExamRoom {

    private final int max;
    private final TreeSet<Interval> available;
    private final TreeSet<Integer> taken;

    public ExamRoom(int n) {
        this.max = n - 1;
        this.available = new TreeSet<>((a, b) -> {
            var distA = getMinDistance(a);
            var distB = getMinDistance(b);
            return distA != distB ? a.s - b.s : distB - distA;
        });
        this.available.add(new Interval(-1, max));
        this.taken = new TreeSet<>();
    }

    public int seat() {
        var inter = available.pollFirst();

        int seat;
        if (inter.s == -1) {
            seat = 0;
        } else if (inter.e == max) {
            seat = max;
        } else {
            seat = (inter.s + inter.e) / 2;
        }

        taken.add(seat);
        if (inter.s != -1)
            available.add(new Interval(inter.s, seat));
        if (inter.e != max)
            available.add(new Interval(seat, inter.e));
        return seat;
    }

    public void leave(int p) {
        taken.remove(p);
        int pre = -1, next = max;
        for (int seat : taken) {
            if (seat < p) {
                pre = seat;
            }
            if (seat > p) {
                next = seat;
                break;
            }
        }

        available.remove(new Interval(pre, p));
        available.remove(new Interval(p, next));
        available.add(new Interval(pre, next));
    }

    private int getMinDistance(Interval in) {
        return in.s == -1 || in.e == max ? in.e - in.s : (in.e - in.s) / 2;
    }

    private final class Interval {
        private final int s;
        private final int e;

        Interval(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}
```