Hello.

[POML v0.2.0](https://github.com/mamorum/poml/releases/tag/v0.2.0) was out, 3 days ago.  
In this version, converter `dist` is changed to `pkg`.

**before**

    dist=com.example:demo:0.0.1:jar
    ---
    {{dist}}
  
**after**

    pkg=com.example:demo:0.0.1:jar
    ---
    {{pkg}}


It's configuration and output are not changed.  
[pkg - Converter Reference](https://github.com/mamorum/poml/wiki/pkg)

I'm going to implement `dist` again,  
and make it cover `distributionManagement` tag.


_mamorum_