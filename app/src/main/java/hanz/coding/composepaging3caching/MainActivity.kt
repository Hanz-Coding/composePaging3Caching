package hanz.coding.composepaging3caching

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.collectAsLazyPagingItems
import hanz.coding.composepaging3caching.presentation.NewsScreen
import hanz.coding.composepaging3caching.presentation.NewsViewModel
import hanz.coding.composepaging3caching.ui.theme.ComposePaging3CachingTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePaging3CachingTheme {
                val viewModel = koinViewModel<NewsViewModel>()
                val newsList = viewModel.newsFlow.collectAsLazyPagingItems()
                NewsScreen(newsList)
            }
        }
    }
}
