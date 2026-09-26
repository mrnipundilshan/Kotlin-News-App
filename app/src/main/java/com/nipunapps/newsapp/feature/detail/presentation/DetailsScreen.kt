package com.nipunapps.newsapp.feature.detail.presentation

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.nipunapps.newsapp.feature.detail.presentation.component.DetailsTopBar
import com.nipunapps.newsapp.feature.homescreen.domain.model.Article
import androidx.core.net.toUri
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nipunapps.newsapp.R
import com.nipunapps.newsapp.core.dimension.Dimension.ArticleImageHeight
import com.nipunapps.newsapp.core.dimension.Dimension.MediumPadding1
import com.nipunapps.newsapp.feature.homescreen.domain.model.Source
import com.nipunapps.newsapp.ui.theme.NewsAppTheme

@Composable
fun DetailsScreen(
    article: Article,
    event: (DetailsEvent) -> Unit,
    navigateUp: () -> Unit
){
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        DetailsTopBar(
            onBrowsingClick = {
                Intent(Intent.ACTION_VIEW).also {
                    it.data = article.url.toUri()
                    if (it.resolveActivity(context.packageManager) != null){
                        context.startActivity(it)
                    }
                }
            },
            onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT, article.url)
                    it.type = "text/plain"
                    if (it.resolveActivity(context.packageManager) != null){
                        context.startActivity(it)
                    }
                }
            },
            onBookmarkClick = {
                event(DetailsEvent.UpsertDeleteArticle(article))},

            onBackClick = navigateUp
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = MediumPadding1,
                end = MediumPadding1,
                top = MediumPadding1
            )
        ) {
            item {
                AsyncImage( model = ImageRequest.Builder(context = context).data(article.urlToImage).build(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ArticleImageHeight)
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(MediumPadding1))

                Text(
                    text = article.title,
                    style = MaterialTheme.typography.displaySmall,
                    color = colorResource(
                        id = R.color.text_title
                    )
                )

                Text(
                    text = article.content,
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(
                        id = R.color.body
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview(){
    NewsAppTheme(dynamicColor = false){
        DetailsScreen(
            article = Article(
                author = "",
                title = "Coin launches all-time high at 10,000 USD",
                description = "Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple ",
                content = "Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says AppleCoinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple Coinbase says Apple ",
                publishedAt = "24 March 2023",
                source = Source(
                    id = "", name = ""
                ),
                url = "",
                urlToImage = ""
            ),
            event = {}
        ){

        }
    }
}