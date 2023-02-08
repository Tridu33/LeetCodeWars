-- SWITCH OF --

-- As in many languages haskell has
-- its own analog of switch/case
-- but it uses words case/of
getDataSource state = 
  case state of
    "online" -> "Network"
    "offline" -> "Database"
    _ -> "File System"

-- note, that there is no breaks
-- and default is _

-- This construction also works with
-- pattern matching

getZoneScores zone = 
  case zone of
    Left "Red" -> 1
    Left _ -> 2
    Right "Red" -> 2
    Right _ -> 4
    _ -> 0