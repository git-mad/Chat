package club.gitmad.chat

data class Message(
        val id: String,
        var message: String?,
        var sender: String?,
        val time: Long
)