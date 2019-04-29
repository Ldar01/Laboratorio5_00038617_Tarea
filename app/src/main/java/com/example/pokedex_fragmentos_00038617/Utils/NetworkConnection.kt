package com.example.pokedex_fragmentos_00038617.Utils

import android.net.Uri
import android.util.Log

import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.Scanner

object NetworkUtils {

    private const val POKEMON_API_BASE_URL = "https://pokeapi.co/api/v2/"
    private const val POKEMON_INFO = "pokemon"

    private val TAG = NetworkUtils::class.java.simpleName

    fun buildUrl(): URL? {
        val builtUri = Uri.parse(POKEMON_API_BASE_URL)
            .buildUpon()
            .appendPath(POKEMON_INFO)
            .build()

        var url: URL? = null
        try {
            url = URL(builtUri.toString())
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }

        Log.d(TAG, "Built URI " + url!!)

        return url
    }

    fun buildUrl2(url_pokemon: String): URL? {
        val builtUri = Uri.parse(url_pokemon)


        var url2: URL? = null
        try {
            url2 = URL(builtUri.toString())
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }

        Log.d("Built URI 2 ", url2.toString())

        return url2
    }

    @Throws(IOException::class)
    fun getResponseFromHttpUrl(url: URL): String? {
        val urlConnection = url.openConnection() as HttpURLConnection
        try {
            val `in` = urlConnection.inputStream

            val scanner = Scanner(`in`)
            scanner.useDelimiter("\\A")

            val hasInput = scanner.hasNext()
            return if (hasInput) {
                scanner.next()
            } else {
                null
            }
        } finally {
            urlConnection.disconnect()
        }
    }
}