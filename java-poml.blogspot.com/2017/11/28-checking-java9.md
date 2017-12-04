Hello.

I checked whether Poml v1.1.0 work on Java9.

Poml v1.1.0 is compiled by JDK8. Its source and target options are set to `1.8`. 

I find one problem at command option `poml -v` or `poml version`. This command option outputs `null` on Java9 runtime.

This issue is posted to GitHub issues. I'm considering correspondence.

[Java9: "poml -v" outputs null](https://github.com/mamorum/poml/issues/6)

But, Poml core function (convert poml to xml) works fine on Java9.

Thanks for reading.

_mamorum_