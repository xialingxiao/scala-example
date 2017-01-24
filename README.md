# Scala Examples

All examples are prepared in `Ubuntu 16.04` with `scala-2.12.1` and `sbt-0.13.13` installed.

## ./program1
#### GetRolesById
This program is pre-populated with two users each with a different list of roles: 

```
{
    1: {
        "name":"mickey",
        "roles":[
            "admin",
            "content manager"
        ]
    },
    2: {
        "name":"donald",
        "roles":[
            "user"
        ]
    }
}
```

It treats the first command-line input argument as user id and prints the corresponding user's roles on the screen if the user exists, otherwise prints nothing.

Run the program from directory `./program1/`

Below lists the commands to run and expected results:

```
./program1$ scalac GetRolesById.scala 
./program1$ scala GetRolesById
./program1$ scala GetRolesById 1
Role: admin
Role: content manager
./program1$ scala GetRolesById 2
Role: user
./program1$ scala GetRolesById 3
./program1$ scala GetRolesById random stuff
./program1$ scala GetRolesById 1 k
Role: admin
Role: content manager
./program1$
```

## ./program2
#### GetResult
This program defines 3 `case class`es: `Foo`, `Bar` and `Baz`. Each of them is equipped with a method which would return an instance of the next class, or in `Baz`'s case its `result:String` attribute, with `0.84` probability and `null` with `0.16` probability. Similarly, the main program is equiped with a function which would return an instance of `Foo` with `0.84` probability and `null` with `0.16` probability. 

The main program tries to get an instance of `Foo` first and then, if successful, tries repeatedly to get an instance of the next class with the last initiated class's method until we get the `result:String` value of `Baz` and prints it on screen, which, in this case, is `Test result`. It does not print anything to screen otherwise. 

Since each step only succeeds with probability `0.84` and there are four steps, the probability that we actually get `Test result` is `0.84^4 ~= 0.50`. 

Run the program from directory `./program2/`

Below lists the commands to run and possible sequence of results:

```
./program2$ scala GetResult
./program2$ scala GetResult
Test result
./program2$ scala GetResult
Test result
./program2$ scala GetResult
./program2$ scala GetResult
Test result
```