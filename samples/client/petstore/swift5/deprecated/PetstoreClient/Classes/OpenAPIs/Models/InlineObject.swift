//
// InlineObject.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation


public struct InlineObject: Codable { 


    /** Updated name of the pet */
    public var name: String?
    /** Updated status of the pet */
    public var status: String?

    public init(name: String?, status: String?) {
        self.name = name
        self.status = status
    }

}
