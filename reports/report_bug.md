# Coverage and Mutation Analysis Findings

During the coverage and mutation analysis (Phase 2), several unobservable behaviors, dead code paths, and missing edge cases were identified and subsequently addressed:

**1. Unobservable Returns (`addRandomTile`)** *(Commit `c7c5d9c`)*
The `addRandomTile` method previously returned a boolean indicating success, but there were no tests verifying this return value, and it was never actually used by the caller. To clean up the unobservable behavior, the method's return type was simply changed to `void` and the return statement was removed.

**2. Unreachable Code (Random Generation Coverage)** *(Commit `c7c5d9c`)*
Mutation tests revealed that the random number generation (e.g., the 90% chance of spawning a '2' tile) was unobservable and impossible to reliably cover. Mutants altering the `0.90` probability threshold survived because the tests couldn't deterministically access or test that branch. To resolve this, dependency injection was implemented for `java.util.Random`, allowing tests to control the generation values and cover those specific edge cases.

**3. Missing Edge Cases in Boundary Conditions** *(Commit `d859255`)*
The tests originally lacked coverage for edge cases involving merges at the absolute limits of the board (last rows and columns). New tests (`EdgeCaseWithOneMergeInLimitCasesRow` and `EdgeCaseWithOneMergeInLimitCasesCol`) were added to guarantee that the `isLosingGame`/`isLosingBoard` logic correctly checks for possible merges right at the borders of the board.

**4. Dead / Redundant Code (`validate()`)** *(Commit `89eb2d4`)*
The `validate()` method was intended to check if cell indices were within the board limits. However, it was never actually executed. Attempting to assign or read outside the grid limits would naturally trigger Java's native `IndexOutOfBoundsException`, which was exactly the same exception `validate()` was trying to throw. Consequently, the redundant method was entirely removed.
