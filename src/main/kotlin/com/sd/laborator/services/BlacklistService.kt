package com.sd.laborator.services

import com.sd.laborator.interfaces.BlacklistInterface
import org.springframework.stereotype.Service
import java.io.File
import java.net.URL

@Service
class BlacklistService : BlacklistInterface{
    //lista
    // Folosim try-catch sau inițializare într-un bloc init/companion object dacă sunt proprietăți de clasă
    private val blacklist: List<String> = try {
        File("blacklist.txt").readLines().map { it.trim().lowercase() }
    } catch (e: Exception) {
        println("Eroare la încărcarea blacklist.txt, folosesc listă goală: ${e.message}")
        listOf("bucharest","london","vienna")
    }

    private val blacklistedZones: List<String> = try {
        File("blacklistedZones.txt").readLines().map { it.trim().lowercase() }
    } catch (e: Exception) {
        println("Eroare la încărcarea blacklistedZones.txt, folosesc listă goală: ${e.message}")
        listOf("tokyo","barcelona")
    }
    // o modalitate de dezvoltare ar putea fi preluarea locatiilor restrictionate dintr-un fisier
    override fun isLocationAllowed(locationName: String): Boolean{
        return !blacklist.any{it.equals(locationName, ignoreCase = true)}
    }
    override fun isCurrentNodeRestricted(): Boolean{
        return try{
            //detectam locatia serverului (nodului de calcul) prin IP
            //folosim un api gratuit de geolocalizare
            // o implementare care sa respecte principiile SOLID ar folosi o interfata pentru acest serviciu.
            val myCity = URL("https://ipapi.co/city/").readText().trim().lowercase()
            println("Nodul de calcul se afla in $myCity")
            blacklistedZones.contains(myCity)
        }catch(e: Exception){
            false
        }
    }
}