package me.hanhngo.homeps.util

sealed class Resource<out T> {
    object Loading: Resource<Nothing>()
    data class Success<out T>(val data: T? = null): Resource<T>()
    class Error<out T>(val message: String? = null): Resource<T>()
}
