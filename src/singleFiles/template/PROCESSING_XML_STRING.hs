-- PROCESSING XML STRING --

{-# LANGUAGE OverloadedStrings #-}
import Text.XML
import Data.Text

main :: IO ()
main = do
    let xml = "\
    \ <pipelines>\
    \   <processor>AddTitle</processor>\
    \   <processor>AddDescription</processor>\
    \ </pipelines>"

    -- NOTE: whitespaces will be also returned as a content.
    
    -- Creating instanse of Document type.
    let doc = parseText_ def xml

    -- Getting a root of the document.
    let root = documentRoot doc

    -- Using 'elementName' also retrieves an instance.
    let tag = elementName root

    -- So to print tag's name there is a method 'nameLocalName'.
    print $ nameLocalName tag

    -- Get children of the root, they might be of any type
    -- like comment, content, another tag.
    let children = elementNodes root
    
    -- To display children a pattern matching method is needed.
    mapM_ printContent children

    where
        printContent :: Node -> IO()

        -- Directly get the tag name.
        printContent (NodeElement Element { elementName = Name { nameLocalName = x } }) = print x
        
        -- Instruction is a special tag like: <?PITarget PIContent?>.
        printContent (NodeInstruction Instruction { }) = return ()

        -- Text inside tag.
        printContent (NodeContent c)
          | strip c == empty = return ()
          | otherwise = print c

        -- Comment is a tag like <!-- Comment -->.
        printContent (NodeComment _) = return ()