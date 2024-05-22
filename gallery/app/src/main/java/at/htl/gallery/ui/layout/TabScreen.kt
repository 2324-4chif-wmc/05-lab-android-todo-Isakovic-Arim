package at.htl.gallery.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import at.htl.gallery.model.Model
import at.htl.gallery.model.ModelStore
import at.htl.gallery.model.service.AlbumService

@Composable
fun TabScreen(model: Model, modelStore: ModelStore?, albumService: AlbumService?) {
    var uiState = model.uiState
    val tabIndex = uiState.selectedTab
    val tabs = listOf("Overview", "Details")
    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = uiState.selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title) },
                    selected = tabIndex == index,
                    onClick = { modelStore?.selectTab(index)},
                    icon = {
                        when (index) {
                            0 -> Icon(imageVector = Icons.Default.Home, contentDescription = null)
                            1 -> BadgedBox(badge = { Badge { Text("${model.albums.size}") }}) {
                                Icon(Icons.Filled.Favorite, contentDescription = "Albums")
                            }
                        }
                    }
                )
            }
        }
        when (tabIndex) {
            0 -> Albums(model)
            1 -> Create(model, albumService, modelStore)
        }
    }
}