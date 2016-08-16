

```java
import com.google.common.io.Files;

FluentIterable<File> dirFiles = 
    Files.fileTreeTraverser().breadthFirstTraversal(
      new File("{ディレクトリのパス}")
    );
```

```java
ArrayList<File> files = new ArrayList<>();
for (File f : dirFiles) {
    if (f.isFile()) files.add(f);
}
```