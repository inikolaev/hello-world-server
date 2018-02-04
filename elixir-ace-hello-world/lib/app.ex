defmodule HelloWorldServer.Application do
  use Application

  def start(_type, _args) do
    children = [
      {HelloWorldServer.Server, [%{greeting: "test"}, [port: 8080]]},
    ]

    opts = [strategy: :one_for_one, name: HelloWorldServer.Supervisor]
    Supervisor.start_link(children, opts)
  end
end
