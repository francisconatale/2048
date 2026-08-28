# Phase 4 Report: Design Improvements and Refactoring

When reviewing the original code, I noticed that the main logic was quite overloaded. The game score was handled loosely as simple variables, and there was a lot of duplicated code when processing movements in different directions. 

To solve this, I applied a series of refactorings based on the following design decisions:

**1. Score Handling:**
To avoid cluttering the board logic and to respect the Single Responsibility Principle (SRP), I decided to extract the scoring system. I created a `Score` class that is now exclusively responsible for keeping track of the points.

**2. Row and Column Abstraction:**
To clean up the main methods, I abstracted utility functions that were previously deeply nested. Specifically, I extracted the logic to fetch and process cells by creating helper methods like `fillRow` and `fillCol`, which significantly reduced code duplication.

**3. Strategy for Movements:**
I still had the issue where moving up, down, left, or right required 4 massive, nearly identical methods. To fix this, I implemented a **Strategy** pattern. This way, the board no longer cares about which direction the tile is moving; it simply executes the move by delegating the exact calculations to the corresponding strategy.

**4. Provider to Optimize Instances:**
Finally, I needed a way to choose which movement strategy to use based on the input direction. Instead of making a traditional *Factory* that creates a `new` object every time the user presses a key, I implemented a **Provider** using an Enum. 
The decision to use a Provider was made strictly to **avoid instantiating movements all the time**. By initializing the 4 strategies just once and storing them in the Provider, we avoid unnecessary memory consumption by recycling the exact same instances every turn.

**Testing:**
To prove that none of these decisions broke the game's logic, I ran the full test suite (20 tests in total). All tests passed successfully, confirming that the refactoring was completely safe and that the game works identically, but with much cleaner code.
