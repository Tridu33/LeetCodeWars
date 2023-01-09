module Lib.Test where
import qualified Lib.Notes.Note as Cur

test :: IO ()
test = do
    putStrLn "test!"
    Cur.testNote
