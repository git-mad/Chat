package club.gitmad.chat

data class Message(
        val id: String = MainActivity.userId,
        var message: String? = "",
        var sender: String? = "",
        val time: Long = System.currentTimeMillis()
)