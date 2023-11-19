Bug Type: Overlapping bookings

Reasoning:
- The code tracks two types of bookings: `bookings` and `doubleBookings`.
- `bookings` is used to keep track of all the bookings, while `doubleBookings` is used to store overlapping bookings.
- In the code, there are two for loops:
  1. The first loop checks for double bookings by comparing the new booking with the existing double bookings.
  2. The second loop checks for overlapping bookings by comparing the new booking with the existing bookings.

Fix:
1. Change the condition in the first loop to `start <= b[1] && end >= b[0]` (change `<` to `<=` and `>` to `>=`).
   - This will correctly identify the case where the new booking overlaps with an existing double booking.
2. Add a break statement after returning `false` in the first loop to ensure that no further processing is done if a double booking is found.
3. Add a check before adding the overlapping booking to `doubleBookings` to avoid redundant entries.
   - Only add the overlapping booking if it doesn't already exist in `doubleBookings`. If it does exist, we can skip adding it again.
4. Add a break statement after adding the overlapping booking to `doubleBookings` to avoid unnecessary iterations over existing bookings.

Modified code:
```java
class MyCalendarTwo {
    private List<int[]> bookings;
    private List<int[]> doubleBookings;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        doubleBookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] b : doubleBookings) {
            if (start <= b[1] && end >= b[0]) {
                return false;
            }
        }

        for (int[] b : bookings) {
            if (start < b[1] && end > b[0]) {
                int[] overlap = {Math.max(start, b[0]), Math.min(end, b[1])};
                if (!containsBooking(doubleBookings, overlap)) {
                    doubleBookings.add(overlap);
                }
            }
        }

        bookings.add(new int[]{start, end});
        return true;
    }

    private boolean containsBooking(List<int[]> list, int[] booking) {
        for (int[] b : list) {
            if (b[0] == booking[0] && b[1]