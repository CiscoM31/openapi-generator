//
// DogAllOf.swift
//
// Generated by openapi-generator
// https://openapi-generator.tech
//

import Foundation
#if canImport(AnyCodable)
import AnyCodable
#endif

@objc public class DogAllOf: NSObject, Codable {

    public var breed: String?

    public init(breed: String? = nil) {
        self.breed = breed
    }

    public enum CodingKeys: String, CodingKey, CaseIterable {
        case breed
    }

    // Encodable protocol methods

    public func encode(to encoder: Encoder) throws {
        var container = encoder.container(keyedBy: CodingKeys.self)
        try container.encodeIfPresent(breed, forKey: .breed)
    }
}

