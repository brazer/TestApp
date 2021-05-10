package com.salanevich.testapp.model

import com.google.gson.annotations.SerializedName

data class CollectionsResponse(
	@field:SerializedName("artObjects") val artObjects: List<ArtObjectsItem?>? = null,
	@field:SerializedName("countFacets") val countFacets: CountFacets? = null,
	@field:SerializedName("count") val count: Int? = null,
	@field:SerializedName("elapsedMilliseconds") val elapsedMilliseconds: Int? = null,
	@field:SerializedName("facets") val facets: List<FacetsItem?>? = null
)

data class FacetsItem(
	@field:SerializedName("prettyName") val prettyName: Int? = null,
	@field:SerializedName("otherTerms") val otherTerms: Int? = null,
	@field:SerializedName("name") val name: String? = null,
	@field:SerializedName("facets") val facets: List<FacetsItem?>? = null,
	@field:SerializedName("value") val value: Int? = null,
	@field:SerializedName("key") val key: String? = null
)

data class HeaderImage(
	@field:SerializedName("offsetPercentageY") val offsetPercentageY: Int? = null,
	@field:SerializedName("offsetPercentageX") val offsetPercentageX: Int? = null,
	@field:SerializedName("width") val width: Int? = null,
	@field:SerializedName("guid") val guid: String? = null,
	@field:SerializedName("url") val url: String? = null,
	@field:SerializedName("height") val height: Int? = null
)

data class ArtObjectsItem(
	@field:SerializedName("principalOrFirstMaker") val principalOrFirstMaker: String? = null,
	@field:SerializedName("webImage") val webImage: WebImage? = null,
	@field:SerializedName("headerImage") val headerImage: HeaderImage? = null,
	@field:SerializedName("objectNumber") val objectNumber: String? = null,
	@field:SerializedName("productionPlaces") val productionPlaces: List<Any?>? = null,
	@field:SerializedName("links") val links: Links? = null,
	@field:SerializedName("hasImage") val hasImage: Boolean? = null,
	@field:SerializedName("showImage") val showImage: Boolean? = null,
	@field:SerializedName("id") val id: String? = null,
	@field:SerializedName("title") val title: String? = null,
	@field:SerializedName("longTitle") val longTitle: String? = null,
	@field:SerializedName("permitDownload") val permitDownload: Boolean? = null
) {
	data class Links(
		@field:SerializedName("web") val web: String? = null,
		@field:SerializedName("self") val self: String? = null
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

data class CountFacets(
	@field:SerializedName("ondisplay") val ondisplay: Int? = null,
	@field:SerializedName("hasimage") val hasimage: Int? = null
)
