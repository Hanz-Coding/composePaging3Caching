package hanz.coding.composepaging3caching.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import hanz.coding.composepaging3caching.data.local.NewsEntity
import hanz.coding.composepaging3caching.data.mappers.toDomain
import kotlinx.coroutines.flow.map

class NewsViewModel(
    pager: Pager<Int, NewsEntity>
) : ViewModel() {

    val newsFlow = pager.flow
        .map { pagingData ->
            pagingData.map { it.toDomain() }
        }
        .cachedIn(viewModelScope)
}