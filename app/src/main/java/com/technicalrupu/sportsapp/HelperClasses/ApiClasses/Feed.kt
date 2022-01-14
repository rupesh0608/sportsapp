package com.technicalrupu.sportsapp.HelperClasses.ApiClasses

class Feed(
    var id: String,
    var user_id: String,
    var description: String,
    var feed_like: String,
    var feed_comments: String,
    var feed_recreation: String,
    var feed_share: String,
    var is_recreated: String,
    var created_on: String,
    var hashtag: List<Hashtag>,
    var is_like: Int,
    var time: String,
    var images: Array<ImageFeed>,
    var media: Array<String>,
    var user_data: ProfileData
) {
}