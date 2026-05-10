package com.example.startupmutipleep0

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform