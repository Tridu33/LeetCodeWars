module Lib.Cur.Current   
( current   
) where


import Data.Time.LocalTime   -- 来自 time 库
import Data.List (nub)
import Data.List hiding (sort)
import qualified Data.Map -- Data.Map.filter
import qualified Data.Map as M -- M.filter

import qualified Lib.Geometry.Sphere as Sphere   
import qualified Lib.Geometry.Cuboid as Cuboid   
import qualified Lib.Geometry.Cube as Cube

current :: IO ()
current = do
  now <- getZonedTime
  print now
  putStr "Hey, "
  putStr "the same line."
  print 2
  print "String sentence."
  print (3.2+1.0)
  print [3,4,3]
  putStrLn ("Hey " ++ "!")
  print (Sphere.area 2.0)
  print $ Sphere.volume 1.0
  print (Cube.area 1.0)