/*
OpenAPI Petstore

This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\

API version: 1.0.0
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

package petstore

import (
	"encoding/json"
)

// checks if the Foo type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &Foo{}

// Foo struct for Foo
type Foo struct {
	Bar *string `json:"bar,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _Foo Foo

// NewFoo instantiates a new Foo object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewFoo() *Foo {
	this := Foo{}
	var bar string = "bar"
	this.Bar = &bar
	return &this
}

// NewFooWithDefaults instantiates a new Foo object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewFooWithDefaults() *Foo {
	this := Foo{}
	var bar string = "bar"
	this.Bar = &bar
	return &this
}

// GetBar returns the Bar field value if set, zero value otherwise.
func (o *Foo) GetBar() string {
	if o == nil || IsNil(o.Bar) {
		var ret string
		return ret
	}
	return *o.Bar
}

// GetBarOk returns a tuple with the Bar field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *Foo) GetBarOk() (*string, bool) {
	if o == nil || IsNil(o.Bar) {
		return nil, false
	}
	return o.Bar, true
}

// HasBar returns a boolean if a field has been set.
func (o *Foo) HasBar() bool {
	if o != nil && !IsNil(o.Bar) {
		return true
	}

	return false
}

// SetBar gets a reference to the given string and assigns it to the Bar field.
func (o *Foo) SetBar(v string) {
	o.Bar = &v
}

func (o Foo) MarshalJSON() ([]byte, error) {
	toSerialize,err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o Foo) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Bar) {
		toSerialize["bar"] = o.Bar
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *Foo) UnmarshalJSON(bytes []byte) (err error) {
	varFoo := _Foo{}

	if err = json.Unmarshal(bytes, &varFoo); err == nil {
		*o = Foo(varFoo)
	}

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(bytes, &additionalProperties); err == nil {
		delete(additionalProperties, "bar")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableFoo struct {
	value *Foo
	isSet bool
}

func (v NullableFoo) Get() *Foo {
	return v.value
}

func (v *NullableFoo) Set(val *Foo) {
	v.value = val
	v.isSet = true
}

func (v NullableFoo) IsSet() bool {
	return v.isSet
}

func (v *NullableFoo) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableFoo(val *Foo) *NullableFoo {
	return &NullableFoo{value: val, isSet: true}
}

func (v NullableFoo) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableFoo) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}


