## Reproduce issue

run:

```sh
./run.sh
```

which is a shortcut for:

```sh
javac -d out src/com/example/Application.java src/com/example/MyIssue.java
java -cp out com.example.Application
```

## Actual results

```
aa
null
```

## Expected results

```
aa
aa
```

Tested on: openjdk 8,11,17,21,23

Summary:

The sheer fact that the interface defines a default method influences how the static fields gets initialized and breaks the initialization chain.

---

My more-or-less correct understanding of things:

There are three things that come into play in here:

1. static block initialization
   In Java, when a static field has a complex initialization, the compiler may move it into a static block instead of
   keeping it inline. This happens due to the way Java handles class loading and initialization.
   When a field involves method calls, object creation, or lambda expressions, the compiler often moves it into a static
   block.
2. interface and inner classes static blocks initialization
   Interfaces are not "instantiated" in the same way as classes, but their static blocks execute when:

   - A static field or method in the interface is accessed.
   - A class implementing the interface is loaded.

   Static blocks in an interface execute when the interface is first used.
   Inner static classes are independent—their static blocks execute only when the inner class is accessed for the first
   time.
   If the interface's static block relies on a static field or method from its inner static class, the inner class gets
   initialized first before the interface.
   Java loads classes and executes their static initializers in the order they appear in the source code.
   **Java ensures that referenced classes are initialized before they are accessed.**

3. Existance of default method in the interface that messes with static block initialization
