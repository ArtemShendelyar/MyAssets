package domain.utils

inline fun <T, R> T.resultOf(block: T.() -> R): Result<R> {
    return try {
        Result.success(block())
    } catch (e: Exception) {
        Result.failure(e)
    }
}
