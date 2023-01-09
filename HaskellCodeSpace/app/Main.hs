module Main where
import qualified Lib.Test as Cur 

main :: IO ()
main = do
    putStrLn "Hello, Haskell in CodeSpace - cabal 2.4!"
    Cur.test