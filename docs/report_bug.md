# Testing and Ad Hoc Bug Detection Report

## 1. Test Suite
The test suite was executed successfully, with no issues detected in the implemented test cases. All covered scenarios behaved as expected.

## 2. Ad Hoc Bug Detection
During manual gameplay, an unexpected behavior was identified through ad hoc testing.

**The following board state was observed:**

```text
Score: 96
+-----+-----+-----+-----+
|   16|    8|     |     |
+-----+-----+-----+-----+
|    4|    2|     |     |
+-----+-----+-----+-----+
|    8|    2|     |     |
+-----+-----+-----+-----+
|     |    2|     |     |
+-----+-----+-----+-----+

Enter move: s
Tile moved!
```

**After performing the `s` (DOWN) move, the board became:**

```text
Score: 100
+-----+-----+-----+-----+
|     |     |     |     |
+-----+-----+-----+-----+
|     |    2|     |     |
+-----+-----+-----+-----+
|    4|    2|     |     |
+-----+-----+-----+-----+
|    8|    4|     |     |
+-----+-----+-----+-----+
```

**Expected Result:**

```text
+-----+-----+-----+-----+
|     |     |     |     |
+-----+-----+-----+-----+
|   16|    8|     |     |
+-----+-----+-----+-----+
|    4|    2|     |     |
+-----+-----+-----+-----+
|    8|    4|     |     |
+-----+-----+-----+-----+
```

*Note:* This behavior was not detected by the existing automated tests, as the specific scenario was not covered by the current test cases.

## 3. Next Steps
The next step is to reproduce the exact board configuration and execute the same `s` move in a controlled test case. 

This will allow us to determine whether the observed behavior is actually a bug and, if confirmed, add the scenario to the automated test suite as a regression test.

## 4. Conclusion
The automated test suite passed without detecting any issues. However, an ad hoc testing session led to the detection of a potentially unexpected behavior, which will now be investigated by reproducing the exact scenario.

**Status:** Potential bug identified through ad hoc testing; reproduction pending.

---

## 5. Resolution & Activity Log

**@francisconatale** commented 2 weeks ago:

> Fixed the board traversal order for downward movements by iterating through the rows from the bottom to the top.
> 
> This ensures that tiles closer to the bottom edge are processed first, preserving the expected 2048 movement and merge behavior.

**The Root Cause:**
The loop condition was originally `row > 0`, meaning the top row (`row = 0`) was completely ignored during the downward movement processing.

* **Before the fix:** `for (int row = size - 1; row > 0; row--)`
  * *Actual:* `nonEmpty : {4,2}`
  * *Expected:* `nonEmpty: {4,2,8}` (The top tile was being left behind/ignored)

* **After the fix:** `for (int row = size - 1; row >= 0; row--)`
  * *Actual:* `nonEmpty : {4,2,8}`
  * *Expected:* `nonEmpty: {4,2,8}`

**Status:** Resolved. The bug was fixed and the regression test was presumably added.
