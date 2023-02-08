-- DOWNLOAD STRING --

-- Package http-client.
import Network.HTTP.Client
-- Package http-client-tls.
import Network.HTTP.Client.TLS
-- Package bytestring.
import qualified Data.ByteString.Lazy as BL

main = do

  -- Create a connection manager.
  manager <- newManager tlsManagerSettings

  -- Create a request.
  request <- parseRequest "https://www.google.com/robots.txt"

  -- Execute the request by the manager.
  response <- httpLbs request manager

  -- Get the contents as a lazy ByteString.
  let contents = responseBody response
  
  -- Show the content in console.
  BL.putStr contents