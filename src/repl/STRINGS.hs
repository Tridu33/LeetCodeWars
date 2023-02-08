-- STRINGS --

-- Multiline string:
-- make string more readable
-- use '\' character. Be carefule, it does
-- not add new line by default.
sql = "\
\SELECT * \
\FROM companies \
\WHERE company = 'Witty Lion'\
\"
-- SELECT * FROM companies WHERE company = 'Witty Lion'

-- New line is \n character
pretty_sql = "\
\SELECT * \n\
\FROM companies \n\
\WHERE company = 'Witty Lion'\n\
\"

-- Join strings with space.
space_joined = unwords [
    "SELECT *",
    "FROM companies",
    "WHERE company = 'Witty Lion'"]

-- Join strings with new line character.
line_joined = unlines [
    "There is a house in New Orleans",
    "They call the Rising Sun"]