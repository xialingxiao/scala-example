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