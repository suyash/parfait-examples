## counter

the simplest example, simply creates a counter that increases its value each second

to run

```sh
gradle build
cd build/classes/main
java -javaagent:/path/to/parfait.jar Main
```

**NOTE:** this uses parfait 0.3.8 with `io.pcp` namespace, which is not on maven central, so the recommended way to get that is to build parfait locally
