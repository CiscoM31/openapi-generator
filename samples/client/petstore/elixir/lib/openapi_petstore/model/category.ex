# NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
# https://openapi-generator.tech
# Do not edit the class manually.

defmodule OpenapiPetstore.Model.Category do
  @moduledoc """
  
  """

  @derive [Poison.Encoder]
  defstruct [
    :id,
    :name
  ]

  @type t :: %__MODULE__{
    :id => integer() | nil,
    :name => String.t
  }
end

defimpl Poison.Decoder, for: OpenapiPetstore.Model.Category do
  def decode(value, _options) do
    value
  end
end

