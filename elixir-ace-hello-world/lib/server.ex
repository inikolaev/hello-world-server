defmodule HelloWorldServer.Server do
  use Ace.HTTP.Service, [cleartext: true]

  def handle_request(_request, _state) do
    response(:ok)
    |> set_header("content-type", "text/plain")
    |> set_body("Hello, World!")
  end
end

