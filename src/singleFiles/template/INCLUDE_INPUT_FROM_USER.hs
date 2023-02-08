-- INCLUDE INPUT FROM USER --

main = do  
    putStrLn "Please enter your name:"  
    name <- getLine  
    putStrLn ("Hello " ++ name)