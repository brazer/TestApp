package com.salanevich.testapp.model

import com.google.gson.annotations.SerializedName

data class ItemDetailResponse(
	@field:SerializedName("artObjectPage") val artObjectPage: ArtObjectPage? = null,
	@field:SerializedName("artObject") val artObject: ArtObject? = null,
	@field:SerializedName("elapsedMilliseconds") val elapsedMilliseconds: Int? = null
)

data class PrincipalMakersItem(
	@field:SerializedName("placeOfBirth") val placeOfBirth: String? = null,
	@field:SerializedName("occupation") val occupation: List<String?>? = null,
	@field:SerializedName("dateOfDeath") val dateOfDeath: String? = null,
	@field:SerializedName("roles") val roles: List<String?>? = null,
	@field:SerializedName("productionPlaces") val productionPlaces: List<String?>? = null,
	@field:SerializedName("dateOfBirth") val dateOfBirth: String? = null,
	@field:SerializedName("placeOfDeath") val placeOfDeath: String? = null,
	@field:SerializedName("biography") val biography: Any? = null,
	@field:SerializedName("dateOfDeathPrecision") val dateOfDeathPrecision: Any? = null,
	@field:SerializedName("qualification") val qualification: Any? = null,
	@field:SerializedName("nationality") val nationality: Any? = null,
	@field:SerializedName("unFixedName") val unFixedName: String? = null,
	@field:SerializedName("name") val name: String? = null,
	@field:SerializedName("dateOfBirthPrecision") val dateOfBirthPrecision: Any? = null
)

data class ColorsWithNormalizationItem(
	@field:SerializedName("normalizedHex") val normalizedHex: String? = null,
	@field:SerializedName("originalHex") val originalHex: String? = null
)

data class ArtObjectPage(
	@field:SerializedName("similarPages") val similarPages: List<Any?>? = null,
	@field:SerializedName("audioFileLabel2") val audioFileLabel2: Any? = null,
	@field:SerializedName("adlibOverrides") val adlibOverrides: AdlibOverrides? = null,
	@field:SerializedName("objectNumber") val objectNumber: String? = null,
	@field:SerializedName("audioFileLabel1") val audioFileLabel1: Any? = null,
	@field:SerializedName("id") val id: String? = null,
	@field:SerializedName("plaqueDescription") val plaqueDescription: String? = null,
	@field:SerializedName("audioFile1") val audioFile1: Any? = null,
	@field:SerializedName("updatedOn") val updatedOn: String? = null,
	@field:SerializedName("lang") val lang: String? = null,
	@field:SerializedName("createdOn") val createdOn: String? = null,
	@field:SerializedName("tags") val tags: List<Any?>? = null
)

data class Dating(
	@field:SerializedName("period") val period: Int? = null,
	@field:SerializedName("sortingDate") val sortingDate: Int? = null,
	@field:SerializedName("yearLate") val yearLate: Int? = null,
	@field:SerializedName("yearEarly") val yearEarly: Int? = null,
	@field:SerializedName("presentingDate") val presentingDate: String? = null
)

data class Label(
	@field:SerializedName("date") val date: String? = null,
	@field:SerializedName("notes") val notes: Any? = null,
	@field:SerializedName("description") val description: String? = null,
	@field:SerializedName("title") val title: String? = null,
	@field:SerializedName("makerLine") val makerLine: String? = null
)

data class Acquisition(
	@field:SerializedName("date") val date: String? = null,
	@field:SerializedName("method") val method: String? = null,
	@field:SerializedName("creditLine") val creditLine: String? = null
)

data class NormalizedColorsItem(
	@field:SerializedName("percentage") val percentage: Int? = null,
	@field:SerializedName("hex") val hex: String? = null
)

data class ColorsItem(
	@field:SerializedName("percentage") val percentage: Int? = null,
	@field:SerializedName("hex") val hex: String? = null
)

data class Classification(
	@field:SerializedName("iconClassIdentifier") val iconClassIdentifier: List<String?>? = null,
	@field:SerializedName("places") val places: List<String?>? = null,
	@field:SerializedName("motifs") val motifs: List<Any?>? = null,
	@field:SerializedName("periods") val periods: List<Any?>? = null,
	@field:SerializedName("objectNumbers") val objectNumbers: List<String?>? = null,
	@field:SerializedName("people") val people: List<String?>? = null,
	@field:SerializedName("events") val events: List<Any?>? = null,
	@field:SerializedName("iconClassDescription") val iconClassDescription: List<String?>? = null
)

data class AdlibOverrides(
	@field:SerializedName("titel") val titel: Any? = null,
	@field:SerializedName("etiketText") val etiketText: Any? = null,
	@field:SerializedName("maker") val maker: Any? = null
)

data class Normalized32ColorsItem(
	@field:SerializedName("percentage") val percentage: Int? = null,
	@field:SerializedName("hex") val hex: String? = null
)

data class DimensionsItem(
	@field:SerializedName("unit") val unit: String? = null,
	@field:SerializedName("part") val part: Any? = null,
	@field:SerializedName("type") val type: String? = null,
	@field:SerializedName("value") val value: String? = null
)

data class ArtObject(
	@field:SerializedName("associations") val associations: List<Any?>? = null,
	@field:SerializedName("scLabelLine") val scLabelLine: String? = null,
	@field:SerializedName("principalOrFirstMaker") val principalOrFirstMaker: String? = null,
	@field:SerializedName("labelText") val labelText: Any? = null,
	@field:SerializedName("principalMaker") val principalMaker: String? = null,
	@field:SerializedName("objectNumber") val objectNumber: String? = null,
	@field:SerializedName("normalizedColors") val normalizedColors: List<NormalizedColorsItem?>? = null,
	@field:SerializedName("description") val description: String? = null,
	@field:SerializedName("language") val language: String? = null,
	@field:SerializedName("principalMakers") val principalMakers: List<PrincipalMakersItem?>? = null,
	@field:SerializedName("hasImage") val hasImage: Boolean? = null,
	@field:SerializedName("showImage") val showImage: Boolean? = null,
	@field:SerializedName("title") val title: String? = null,
	@field:SerializedName("colors") val colors: List<ColorsItem?>? = null,
	@field:SerializedName("physicalProperties") val physicalProperties: List<Any?>? = null,
	@field:SerializedName("physicalMedium") val physicalMedium: String? = null,
	@field:SerializedName("webImage") val webImage: WebImage? = null,
	@field:SerializedName("subTitle") val subTitle: String? = null,
	@field:SerializedName("copyrightHolder") val copyrightHolder: Any? = null,
	@field:SerializedName("artistRole") val artistRole: Any? = null,
	@field:SerializedName("plaqueDescriptionEnglish") val plaqueDescriptionEnglish: String? = null,
	@field:SerializedName("catRefRPK") val catRefRPK: List<Any?>? = null,
	@field:SerializedName("links") val links: Links? = null,
	@field:SerializedName("priref") val priref: String? = null,
	@field:SerializedName("dating") val dating: Dating? = null,
	@field:SerializedName("id") val id: String? = null,
	@field:SerializedName("acquisition") val acquisition: Acquisition? = null,
	@field:SerializedName("objectCollection") val objectCollection: List<String?>? = null,
	@field:SerializedName("colorsWithNormalization") val colorsWithNormalization: List<ColorsWithNormalizationItem?>? = null,
	@field:SerializedName("makers") val makers: List<Any?>? = null,
	@field:SerializedName("inscriptions") val inscriptions: List<Any?>? = null,
	@field:SerializedName("documentation") val documentation: List<String?>? = null,
	@field:SerializedName("productionPlaces") val productionPlaces: List<String?>? = null,
	@field:SerializedName("normalized32Colors") val normalized32Colors: List<Normalized32ColorsItem?>? = null,
	@field:SerializedName("titles") val titles: List<String?>? = null,
	@field:SerializedName("label") val label: Label? = null,
	@field:SerializedName("plaqueDescriptionDutch") val plaqueDescriptionDutch: String? = null,
	@field:SerializedName("classification") val classification: Classification? = null,
	@field:SerializedName("historicalPersons") val historicalPersons: List<String?>? = null,
	@field:SerializedName("materials") val materials: List<String?>? = null,
	@field:SerializedName("techniques") val techniques: List<Any?>? = null,
	@field:SerializedName("exhibitions") val exhibitions: List<Any?>? = null,
	@field:SerializedName("location") val location: String? = null,
	@field:SerializedName("objectTypes") val objectTypes: List<String?>? = null,
	@field:SerializedName("dimensions") val dimensions: List<DimensionsItem?>? = null,
	@field:SerializedName("longTitle") val longTitle: String? = null
) {
	data class Links(
		@field:SerializedName("search") val search: String? = null
	)
	data class WebImage(
		@field:SerializedName("offsetPercentageY") val offsetPercentageY: Int? = null,
		@field:SerializedName("offsetPercentageX") val offsetPercentageX: Int? = null,
		@field:SerializedName("width") val width: Int? = null,
		@field:SerializedName("guid") val guid: String? = null,
		@field:SerializedName("url") val url: String? = null,
		@field:SerializedName("height") val height: Int? = null
	)
}
