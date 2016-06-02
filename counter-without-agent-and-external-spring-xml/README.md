## counter

the simplest example, simply creates a counter that increases its value each second

this runs on its own, just run

```
gradle run
```

**NOTE:** this uses parfait 0.3.8 with `io.pcp` namespace, which is not on maven central, so the recommended way to get that is to build parfait locally

also, this exports metrics to `/var/lib/pcp/tmp/mmv` so make sure the current user owns it with

```
sudo chown user /var/lib/pcp/tmp/mmv
```

this **does not** register inbuilt jmx metrics by default, simply one metric which is `mmv.test.counter`
