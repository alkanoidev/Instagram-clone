package me.alkanoidev.instagram.ui.post

data class PostModel(
        var imageUrl: String,
        var username: String,
        var location: String?,
        var profilePicture: String,
        var noLikes: Int,
        var noComments: Int,
        var description: String?
)