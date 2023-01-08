# LeetCodeWars

my Solutions for problems both in LeetCode and CodeWars(.java &amp; .hs)

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


