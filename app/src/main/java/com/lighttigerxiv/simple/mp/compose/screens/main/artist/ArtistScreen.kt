package com.lighttigerxiv.simple.mp.compose.screens.main.artist

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.lighttigerxiv.simple.mp.compose.*
import com.lighttigerxiv.simple.mp.compose.R
import com.lighttigerxiv.simple.mp.compose.ui.composables.CustomToolbar
import com.lighttigerxiv.simple.mp.compose.ui.composables.PlayAndShuffleRow
import com.lighttigerxiv.simple.mp.compose.ui.composables.SongItem
import com.lighttigerxiv.simple.mp.compose.activities.main.MainVM
import com.lighttigerxiv.simple.mp.compose.data.data_classes.Song
import com.lighttigerxiv.simple.mp.compose.data.variables.ImageSizes
import com.lighttigerxiv.simple.mp.compose.data.variables.SCREEN_PADDING
import com.lighttigerxiv.simple.mp.compose.data.variables.SMALL_SPACING
import com.lighttigerxiv.simple.mp.compose.settings.SettingsVM
import com.lighttigerxiv.simple.mp.compose.ui.composables.CustomText
import com.lighttigerxiv.simple.mp.compose.ui.composables.spacers.MediumHeightSpacer
import com.lighttigerxiv.simple.mp.compose.ui.composables.spacers.SmallHeightSpacer
import com.lighttigerxiv.simple.mp.compose.functions.getAppString
import com.lighttigerxiv.simple.mp.compose.functions.getImage
import com.lighttigerxiv.simple.mp.compose.screens.main.playlists.playlist.modifyIf
import com.lighttigerxiv.simple.mp.compose.ui.composables.ImageCard
import kotlinx.coroutines.launch
import moe.tlaster.nestedscrollview.VerticalNestedScrollView
import moe.tlaster.nestedscrollview.rememberNestedScrollViewState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ArtistScreen(
    mainVM: MainVM,
    settingsVM: SettingsVM,
    artistID: Long,
    vm: ArtistScreenVM,
    activityContext: ViewModelStoreOwner,
    navController: NavHostController,
    onBackClicked: () -> Unit
) {

    val configuration = LocalConfiguration.current
    val inPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    val pagerState = rememberPagerState(2)
    val nestedScrollViewState = rememberNestedScrollViewState()
    val surfaceColor = mainVM.surfaceColor.collectAsState().value
    val surfaceVariantColor = MaterialTheme.colorScheme.surfaceVariant
    val screenLoaded = vm.screenLoaded.collectAsState().value
    val currentSong = mainVM.currentSong.collectAsState().value
    val artistName = vm.artistName.collectAsState().value
    val artistCover = vm.artistCover.collectAsState().value
    val tintCover = vm.tintCover.collectAsState().value
    val songs = vm.artistSongs.collectAsState().value
    val albums = vm.artistAlbums.collectAsState().value
    val showMenu = vm.showMenu.collectAsState().value
    val gridCellsCount = when (configuration.orientation) {

        Configuration.ORIENTATION_PORTRAIT -> 2
        else -> 3
    }

    if (!screenLoaded) {
        vm.loadScreen(artistID, mainVM, settingsVM)
    }

    if (inPortrait) {
        VerticalNestedScrollView(
            modifier = Modifier
                .background(surfaceColor)
                .padding(SCREEN_PADDING),
            state = nestedScrollViewState,
            header = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {

                    ArtistToolbar(
                        onBackClicked = { onBackClicked() },
                        screenLoaded,
                        vm,
                        showMenu,
                        activityContext,
                        navController,
                        artistName,
                        artistID
                    )

                    SmallHeightSpacer()

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Image(
                            bitmap = artistCover.asImageBitmap(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            colorFilter = if (tintCover) ColorFilter.tint(MaterialTheme.colorScheme.primary) else null,
                            modifier = Modifier
                                .fillMaxWidth(0.6f)
                                .aspectRatio(1f)
                                .padding(5.dp)
                                .clip(RoundedCornerShape(14.dp))
                                .modifyIf(tintCover) {
                                    background(surfaceVariantColor)
                                }
                                .modifyIf(tintCover) {
                                    padding(5.dp)
                                }
                        )
                    }

                    MediumHeightSpacer()

                    CustomText(
                        modifier = Modifier.fillMaxWidth(),
                        text = artistName,
                        textAlign = TextAlign.Center,
                        size = 20.sp,
                        weight = FontWeight.Bold
                    )

                    MediumHeightSpacer()
                }
            },
            content = {

                ArtistSongsAndAlbums(
                    vm,
                    mainVM,
                    activityContext,
                    navController,
                    screenLoaded,
                    pagerState,
                    surfaceColor,
                    songs,
                    albums,
                    currentSong,
                    gridCellsCount
                )
            }
        )
    } else {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SCREEN_PADDING)
        ) {

            ArtistToolbar(
                onBackClicked = { onBackClicked() },
                screenLoaded,
                vm,
                showMenu,
                activityContext,
                navController,
                artistName,
                artistID
            )

            MediumHeightSpacer()

            Row(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .weight(0.4f, fill = true),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Image(
                        bitmap = artistCover.asImageBitmap(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        colorFilter = if (tintCover) ColorFilter.tint(MaterialTheme.colorScheme.primary) else null,
                        modifier = Modifier
                            .fillMaxHeight(0.7f)
                            .aspectRatio(1f)
                            .padding(5.dp)
                            .clip(RoundedCornerShape(14.dp))
                            .modifyIf(tintCover) {
                                background(surfaceVariantColor)
                            }
                            .modifyIf(tintCover) {
                                padding(5.dp)
                            }
                    )

                    MediumHeightSpacer()

                    CustomText(
                        modifier = Modifier.fillMaxWidth(),
                        text = artistName,
                        textAlign = TextAlign.Center,
                        size = 20.sp,
                        weight = FontWeight.Bold
                    )

                    MediumHeightSpacer()
                }

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .weight(0.6f, fill = true)
                ) {

                    ArtistSongsAndAlbums(
                        vm,
                        mainVM,
                        activityContext,
                        navController,
                        screenLoaded,
                        pagerState,
                        surfaceColor,
                        songs,
                        albums,
                        currentSong,
                        gridCellsCount
                    )
                }
            }
        }
    }
}

@Composable
fun ArtistToolbar(
    onBackClicked: () -> Unit,
    screenLoaded: Boolean,
    vm: ArtistScreenVM,
    showMenu: Boolean,
    activityContext: ViewModelStoreOwner,
    navController: NavHostController,
    artistName: String,
    artistID: Long
) {

    val context = LocalContext.current


    CustomToolbar(
        backText = remember { getAppString(context, R.string.Artists) },
        onBackClick = { onBackClicked() },
        secondaryContent = {

            if (screenLoaded) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )

                Column {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(14))
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                            .padding(5.dp)
                            .clickable {

                                vm.updateShowMenu(true)
                            }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.menu),
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier
                                .height(25.dp)
                                .aspectRatio(1f)
                        )
                    }

                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = {

                            vm.updateShowMenu(false)
                        }
                    ) {
                        DropdownMenuItem(
                            text = { Text(text = remember { getAppString(context, R.string.ChangeArtistCover) }) },
                            onClick = {

                                vm.updateShowMenu(false)
                                vm.openSelectArtistCoverScreen(activityContext, navController, artistName, artistID)
                            }
                        )
                    }
                }
            }
        }
    )
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun ArtistSongsAndAlbums(
    vm: ArtistScreenVM,
    mainVM: MainVM,
    activityContext: ViewModelStoreOwner,
    navController: NavHostController,
    screenLoaded: Boolean,
    pagerState: PagerState,
    surfaceColor: Color,
    songs: List<Song>?,
    albums: List<Song>?,
    currentSong: Song?,
    gridCellsCount: Int
){

    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        if (screenLoaded) {
            androidx.compose.material.TabRow(
                selectedTabIndex = pagerState.currentPage,
                contentColor = surfaceColor,
                indicator = {}
            ) {

                val songsTabColor = when (pagerState.currentPage) {

                    0 -> MaterialTheme.colorScheme.surfaceVariant
                    else -> mainVM.surfaceColor.collectAsState().value
                }

                val albumsTabColor = when (pagerState.currentPage) {

                    1 -> MaterialTheme.colorScheme.surfaceVariant
                    else -> mainVM.surfaceColor.collectAsState().value
                }

                Tab(
                    text = { Text(remember { getAppString(context, R.string.Songs) }, fontSize = 16.sp) },
                    selected = pagerState.currentPage == 0,
                    selectedContentColor = MaterialTheme.colorScheme.primary,
                    unselectedContentColor = MaterialTheme.colorScheme.onSurface,
                    onClick = { scope.launch { pagerState.animateScrollToPage(0) } },
                    modifier = Modifier
                        .background(mainVM.surfaceColor.collectAsState().value)
                        .padding(SMALL_SPACING)
                        .clip(RoundedCornerShape(percent = 100))
                        .background(songsTabColor)
                )
                Tab(
                    text = { Text(remember { getAppString(context, R.string.Albums) }, fontSize = 16.sp) },
                    selectedContentColor = MaterialTheme.colorScheme.primary,
                    unselectedContentColor = MaterialTheme.colorScheme.onSurface,
                    selected = pagerState.currentPage == 1,
                    onClick = { scope.launch { pagerState.animateScrollToPage(1) } },
                    modifier = Modifier
                        .background(mainVM.surfaceColor.collectAsState().value)
                        .padding(SMALL_SPACING)
                        .clip(RoundedCornerShape(percent = 100))
                        .background(albumsTabColor)
                )
            }

            MediumHeightSpacer()

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { currentPage ->

                when (currentPage) {

                    //************************************************
                    // Songs
                    //************************************************

                    0 -> {

                        Column(
                            modifier = Modifier.fillMaxSize()
                        ) {

                            PlayAndShuffleRow(
                                surfaceColor = surfaceColor,
                                onPlayClick = {
                                    mainVM.unshuffleAndPlay(songs!!, 0)
                                },
                                onSuffleClick = {
                                    mainVM.shuffleAndPlay(songs!!)
                                }
                            )

                            MediumHeightSpacer()

                            LazyColumn(
                                verticalArrangement = Arrangement.spacedBy(5.dp),
                                content = {

                                    items(
                                        items = songs!!,
                                        key = { song -> song.id }
                                    ) { song ->

                                        SongItem(
                                            song = song,
                                            songAlbumArt = mainVM.songsCovers.collectAsState().value?.find { it.albumID == song.albumID }!!.albumArt,
                                            highlight = song.path == currentSong?.path,
                                            onSongClick = { mainVM.selectSong(songs, songs.indexOf(song)) }
                                        )
                                    }
                                }
                            )
                        }
                    }

                    //************************************************
                    // Albums
                    //************************************************

                    1 -> {
                        Spacer(modifier = Modifier.height(20.dp))
                        Column(modifier = Modifier.fillMaxSize()) {

                            LazyVerticalGrid(
                                columns = GridCells.Fixed(gridCellsCount),
                                verticalArrangement = Arrangement.spacedBy(5.dp),
                                horizontalArrangement = Arrangement.spacedBy(5.dp),
                                content = {

                                    items(
                                        items = albums!!,
                                        key = { album -> album.albumID },
                                    ) { album ->

                                        val albumSongAlbumID = album.albumID
                                        val albumName = album.album
                                        val albumArt = mainVM.songsCovers.collectAsState().value?.first { it.albumID == albumSongAlbumID }?.albumArt


                                        ImageCard(
                                            cardImage = remember { (albumArt ?: getImage(context, R.drawable.cd, ImageSizes.MEDIUM)) },
                                            cardText = albumName,
                                            imageTint = if (albumArt == null) ColorFilter.tint(MaterialTheme.colorScheme.primary) else null,
                                            onCardClicked = {
                                                vm.openAlbumScreen(activityContext, navController, album.albumID)
                                            },

                                            )

                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}