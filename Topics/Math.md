# Math

## Check if a number beyond MAX_VALUE or MIN_VALUE

`num` keeps its positive or negative

```java
int d = x % 10;
int temp = num * 10 + d;
if (temp / 10 != num) return false; // Beyond the max value.
```

`num` is separated from its positive or negative.

- [008. String to Integer (atoi)](../Solutions/008_String_to_Integer/README.md)

```java
// isNegative is defined already.
long temp = num * 10 + c - '0';
if (temp > Integer.MAX_VALUE) return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
```

## Division without operator

Use `Binary Search` and `<<` to figure out how many divisors can sum up to dividend.

- [029. Divide Two Integers](../Solutions/029_Divide_Two_Integers/README.md)