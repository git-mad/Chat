package club.gitmad.chat

data class Message(
        val userId: String? = "",
        var userName: String? = "",
        var message: String? = "",
        val time: Long = System.currentTimeMillis()
)