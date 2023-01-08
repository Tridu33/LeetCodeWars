module Main where

import qualified Lib.Cur.Current as Cur
main :: IO ()
main = do
  Cur.current
