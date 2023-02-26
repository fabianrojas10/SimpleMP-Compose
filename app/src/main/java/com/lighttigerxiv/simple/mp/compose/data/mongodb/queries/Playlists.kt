package com.lighttigerxiv.simple.mp.compose.data.mongodb.queries

import android.util.Log
import com.lighttigerxiv.simple.mp.compose.Song
import com.lighttigerxiv.simple.mp.compose.data.mongodb.items.Playlist
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.ext.toRealmList
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmList
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId

class PlaylistsQueries(
    private val realm: Realm
) {

    private fun String.getMongoID(): BsonObjectId {

        val bsonId = BsonObjectId(this)

        return BsonObjectId(bsonId.toByteArray())
    }

    fun getPlaylists(): RealmResults<Playlist> {
        return realm.query<Playlist>().find()
    }

    fun getPlaylist(playlistID: String): Playlist {

        return realm.query<Playlist>("_id == $0", playlistID.getMongoID()).find().first()
    }

    fun createPlaylist(
        playlistName: String
    ) {

        realm.writeBlocking {
            this.copyToRealm(Playlist().apply {
                name = playlistName
            })
        }
    }

    suspend fun deletePlaylist(playlistID: String) {

        realm.write {
            val playlist = this.query<Playlist>("_id == $0", playlistID.getMongoID()).find().first()

            delete(playlist)
        }
    }

    suspend fun updatePlaylistSongs(playlist: Playlist, songs: List<Long>) {

        realm.write {

            val queryPlaylist = this.query<Playlist>("_id == $0", playlist._id).find().first()

            queryPlaylist.songs = songs.toRealmList()
        }
    }

    suspend fun updatePlaylist(playlist: Playlist) {

        realm.write {

            val queryPlaylist = this.query<Playlist>("_id == $0", playlist._id).find().first()

            queryPlaylist.name = playlist.name
            queryPlaylist.songs = playlist.songs
            queryPlaylist.image = playlist.image
        }
    }
}

