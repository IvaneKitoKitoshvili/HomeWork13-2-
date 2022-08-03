package com.example.homework132

import com.squareup.moshi.Json

data class ItemModel(
    val id: String,
    val projectId: String,
    val equipmentId: String,
    val stats: String? = "",
    val requestedBy: String,
    val acceptedBy: String?,
    val author: String,
    val category: String,
    val locations: Location,
    val filters: List<Filter>,
    val type: String,
    val organization: String,
    val address: String,
    val endDate: String,
    val description: String?,
    val prolongDates: List<String>,
    val releaseDates: List<String>,
    val isDummy: Boolean,
    val hasDriver: Boolean,
    val overwriteDate: String?,
    val metaInfo: String?,
    val warehouseId: String?,
    val rentalDescription: String?,
    val internalTransportations: InternalTransformations,
    val startDateMilliseconds: Long,
    val emdDateMilliseconds: String? = "",
    val equipment: Equipment
) {
    data class Filter(
        val name: String,
        val value: Value
    ) {
        data class Value(
            val max: Long,
            val min: Int
        )
    }

    data class Equipment(
        val id: String,
        val title: String,
        val invNumber: String,
        val categoryId: String,
        val modelId: String,
        val brandId: String,
        val year: Int,
        val specifications: List<Specification>,
        val weight: Int,
        @Json(name = "additional_specifications")
        val additionalSpecifications: Any?,
        val structureId: String,
        val organizationId: String,
        val beaconType: String?,
        val beaconId: String,
        val beaconVendor: String,
        @Json(name = "RFID")
        val rFID: String,
        val dailyPrice: String?,
        val inactive: Boolean?,
        val tag: Tag,
        val telematicBox: Any?,
        val createdAt: String,
        @Json(name = "special_number")
        val SpecialNumber: String?,
        @Json(name = "last_check")
        val lastCheck: String,
        @Json(name = "next_check")
        val nextCheck: String,
        @Json(name = "responsible_person")
        val responsiblePerson: String?,
        @Json(name = "test_type")
        val testType: String?,
        @Json(name = "unique_equipment_id")
        val uniqueEquipmentId: String,
        @Json(name = "bgl_number")
        val bglNumber: String,
        @Json(name = "serial_number")
        val serialNumber: String?,
        val inventory: Any?,
        val warehouuseId: String? = null,
        val trackingTag: String?,
        val workingHours: String?,
        @Json(name = "navaris_criteria")
        val navarisCriteria: Any?,
        @Json(name = "dont_send_to_as400")
        val dontSendToAs400: Boolean,
        val model: Model,
        val category: Category,
        val structure: Structure,
        val wareHouse: Any?,
        val equipmentMedia: List<EquipmentMedia>,
        val telematics: List<Telematic>,
        val isMoving: Boolean
    )

    data class Category(
        val id: String,
        val name: String,
        @Json(name = " name_de")
        val nameDe: String? = null,
        val createdAt: String,
        val media: List<Any>
    )

    data class EquipmentMedia(
        val id: String,
        val name: String,
        val files: List<File>,
        val type: String,
        val modelId: String,
        val main: Boolean,
        val modelType: String,
        val createdAt: String,
    ) {
        data class File(
            val size: String,
            val path: String
        )

    }

    data class Model(
        val id: String,
        val name: String,
        val createdAt: String,
        val brand: Brand
    ) {
        data class Brand(
            val id: String,
            val name: String,
            val cratedAt: String? = null,
        )
    }

    data class Specification(
        val key: String,
        val value: Any
    ) {
        data class ValueHLW(
            val H: Double,
            val L: Int,
            val W: Double
        )
    }

    data class Structure(
        val id: String,
        val name: String,
        val type: String,
        val color: String
    )

    data class Tag(
        val date: String,
        val authorName: String?,
        val media: List<Any>
    )

    data class Telematic(
        val timestamp: Long,
        val eventType: String,
        val projectId: String,
        val equipmentId: String,
        val locationName: String,
        val location: TelematicLocation,
        val costCenter: String,
        val lastLatitude: Double,
        val lastLongitude: Double,
        val lastLatLonPrecise: Boolean,
        val lastAddressBtLatLon: String? = null
    ) {
        data class TelematicLocation(
            val type: String,
            val coordinates: List<List<List<List<Double>>>>
        )
    }

    data class InternalTransformations(
        val id: String,
        val projectRequestId: String,
        val pickUpDate: String,
        val deliveryDate: String,
        val description: String?,
        val Status: String? = null,
        val startDateOption: Any?,
        val endDateOption: Any?,
        val pickUpLocation: PickUpLocation,
        val deliveryLocation: DeliveryLocation,
        val provider: String,
        val pickUpLocationAddress: String,
        val deliveryLocationAddress: String,
        val pGroup: String,
        val isOrganizedWithoutSam: Boolean?,
        val templatePGroup: String,
        val pickupDateMilliSeconds: Long? = null,
        val deliveryDateMilliseconds: Long,
        val startDateOptionMilliseconds: Any?,
        val endDateOptionMilliseconds: Any?,
    )

    data class DeliveryLocation(
        val type: String,
        val coordinates: List<Double>
    )

    data class PickUpLocation(
        val type: String,
        val coordinates: List<Double>
    )

    data class Location(
        val type: String,
        val coordinates: List<Double>
    )
}