package com.example.pokedex_fragmentos_00038617

import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.pokedex_fragmentos_00038617.Models.Pokemon_dummy
import com.example.pokedex_fragmentos_00038617.Utils.AppConstants
import com.example.pokedex_fragmentos_00038617.Utils.NetworkUtils
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var pokemon : MutableList<Pokemon_dummy>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initRecycler()
        FetchPokemonTask().execute()

        /*pokemon_button.setOnClickListener {
            val pokemonNumber = pokemon_id.text.toString().trim()
            if (pokemonNumber.isEmpty()) {
                results_pokedex.setText(R.string.text_nothing_to_show)
            } else {

                FetchPokemonTask().execute(pokemonNumber)
            }
        }*/
    }

    fun initRecycler() {

        viewManager = LinearLayoutManager(this)
        viewAdapter = PokemonAdapter(pokemon){
                v:Pokemon_dummy->pokemonClickListener(v)
        }

        pokemon_list.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }

    fun pokemonClickListener(pokemonClick: Pokemon_dummy){
        /*
        var intent= Intent(this@MainActivity,SecondActivity::class.java)
        intent.putExtra(AppConstants.TEXT_KEY_POKEMON_URL,pokemonClick.url)
        startActivity(intent)*/

    }

    private inner class FetchPokemonTask : AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg params: Void): String? {
/*
            if (pokemonNumbers.isEmpty()) {
                return null
            }*/

            // val idPoke = pokemonNumbers[0]


            val pokeAPI = NetworkUtils.buildUrl()!!

            return try {
                NetworkUtils.getResponseFromHttpUrl(pokeAPI)
            } catch (e: IOException) {
                e.printStackTrace()
                "Error :(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  "
            }

        }

        override fun onPostExecute(pokemonInfo: String?) {
            super.onPostExecute(pokemonInfo)
            Log.d("pokemon",pokemonInfo)


            if (pokemonInfo != null || pokemonInfo != "") {
                //val res = gson.fromJson(pokemonInfo,Pokemon::class.java)
                //Log.d("GSON", res.abilities.toString())
                var respuesta:JSONObject = JSONObject(pokemonInfo)
                var pokemonResult : JSONArray = respuesta.getJSONArray("results")
                Log.d("Info_Poke", pokemonResult.getString(0))
                pokemon = MutableList(10){
                    Pokemon_dummy(
                        JSONObject(pokemonResult[it].toString()).getString("url"),
                        JSONObject(pokemonResult[it].toString()).getString("name")
                    )
                }
                initRecycler()
                //results_pokedex.text = res.name+" Ability: "+ res.abilities!![0].ability!!.name
            } else {
                results_pokedex.text= "Nothing :'v"
            }
        }
    }
}

