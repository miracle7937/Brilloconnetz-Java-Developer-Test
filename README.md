# Pancake Simulation

## Non-Concurrent Version

In the non-concurrent version, the program runs sequentially without utilizing multiple threads. The shopkeeper and users' actions are performed one after another. The shopkeeper makes pancakes, and then each user eats their pancakes.

This version may be slower as users wait for their turn to eat, and the simulation doesn't take full advantage of parallelism.

## Concurrent Version

In the concurrent version, each user is represented by a separate thread, allowing for parallel execution. Users eat pancakes simultaneously, which better reflects real-world scenarios. This version can potentially be faster as multiple users can eat in parallel. Synchronization is needed to ensure that shared resources (`pancakesMade`) are accessed safely by different threads.

Overall, the concurrent version better models the real-world scenario of multiple users eating pancakes simultaneously and allows for potentially faster execution through parallelism. However, the concurrent version also introduces complexities related to thread synchronization and management, which can lead to potential issues such as deadlocks or race conditions if not handled carefully.
