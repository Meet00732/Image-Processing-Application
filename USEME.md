# USEME - Image Processor Application Usage Instructions

## Running Script Commands:

### Running a Script at Program Start:
To execute a script on start of the application, use the following syntax:
```bash
    java -jar program.jar -file <filename>
```
- Place your script file (example: commands.txt) in the `res` folder of your project.
- Run the jar file by using the command `java -jar program.jar -file res/commands.txt`.
- The application will sequentially execute commands from `commands.txt`, storing the results to the specified directory and exit program execution.

### Running a Script After Program Start:
A user can also run a script after the application has started by following the below steps:

```bash
    run <filename>
```

- Place the script file (example: commands.txt) in the `res` folder of your project.
- Run the `jar` file by using the command `java -jar program.jar`.
- When prompted for commands, type out: `run res/commands.txt`.
- The application will sequentially execute commands from `commands.txt`, outputting results to the specified directory.

### Running Individual Commands using Command Line:

