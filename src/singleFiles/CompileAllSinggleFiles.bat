for /R %%i in (*.hs) do (ghc --make %%i )
del /a /f /s /q  "*.o" "*.hi"