package at.htl.gallery.ui.layout

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import at.htl.gallery.model.Model
import at.htl.gallery.model.ModelStore
import at.htl.gallery.model.entities.Album
import at.htl.gallery.model.service.AlbumService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainView @Inject constructor() {

    @Inject
    lateinit var store: ModelStore

    @Inject
    lateinit var albumService: AlbumService

    fun buildContent(activity: ComponentActivity) {
        val view = ComposeView(activity)
        view.setContent {
            val viewModel = store.pipe.observeOn(AndroidSchedulers.mainThread()).subscribeAsState(
                initial = Model()
            ).value
            Surface (
                modifier = Modifier.fillMaxSize()
            ) {
                TabScreen(viewModel, store, albumService)
            }
        }
        activity.setContentView(view)
    }
}

@Composable
fun Albums(model: Model, modifier: Modifier = Modifier) {
    val albums = model.albums
    LazyColumn(
        modifier = modifier.padding(16.dp)
    ) {
        items(albums.size) { index ->
            AlbumRow(album  = albums[index])
            HorizontalDivider()
        }
    }
}

@Composable
fun AlbumRow(album: Album) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = {

        }
    ) {
        Text(
            text = album.title,
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.width(8.dp))
    }
}