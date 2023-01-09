# LeetCodeWars

my Solutions for problems both in LeetCode and CodeWars(.java &amp; .hs), rename "[Main.bak.hs](https://github.com/Tridu33/LeetCodeWars/blob/main/src/Main.bak.hs "Main.bak.hs")" to "Main.hs", and then:

```
cabal v2-build 
cabal v2-run <executable name> [executable args]
cabal v2-repl
```

or

```bash
cabal new-build && cabal v2-run
```

Open javaOJ folder by IDEA.

## deploy

- gh-pages

```md
cd docs && mkdocs gh-deploy --clean && mkdocs new . && mkdocs build
mkdocs serve
```

- main

```bash
git status && git add . && git commit -m "upgrade for my LeetCodeWars."  && git push
```

The root directory is for Windows 10, Folder 'HaskellCodeSpace' is for `Linux codespaces-5e05fb 5.4.0-1098-azure #104~18.04.2-Ubuntu SMP Tue Nov 29 12:13:35 UTC 2022 x86_64 x86_64 x86_64 GNU/Linux` in Github CodeSpace.