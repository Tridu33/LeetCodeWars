module Main where

-- git ignore this file "Main.hs" for changes many times when practicing.
import qualified Lib.Cur.Current as Cur

main :: IO ()
main = do
  Cur.current
