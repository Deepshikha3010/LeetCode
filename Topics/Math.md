# Math

## Check if a number beyond MAX_VALUE or MIN_VALUE

`num` keeps its positive or negative

```java
int d = x % 10;
int temp = num * 10 + d;
if (temp / 10 != num) return false; // Beyond the max value.
```

`num` is separated from its positive or negative. E.g.: [8. String to Integer (atoi)](../Solutions/008_String_to_Integer/README.md)

```java
// isNegative is defined already.
long temp = num * 10 + c - '0';
if (temp > Integer.MAX_VALUE) return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
```