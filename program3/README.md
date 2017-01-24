### GetFutureResult
This program demonstrates the vary basic use of `Future` in `scala`. It allows the result of asynchronous processes to be handled in the future with very clean syntax.

Run the program from directory `./program3/`

Below lists the commands to run and expected results:

```
./program3$ scalac GetFutureResult.scala 
./program3$ scala GetFutureResult
Process 1. main process starts
Process 1. the curent value of result: 0
Process 1. doing something else
Process 2. asynchronous process starts
Process 1. finishes other stuff, will wait for process 2 to complete if it hasn't already
Process 2. asynchronous process ends
Process 1. the curent value of result: 2
```
