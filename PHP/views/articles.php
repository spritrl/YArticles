<?php 
include 'controlers/article/callAPI.php';
$data = callAPI('GET', '127.0.0.1:8000/articles', false);
$json = json_decode($data, true);
$articles = $json['articles'];
$links = $json['_links'];
// print_r($articles);
echo "<div class='articles'>";
foreach ($articles as $article) {
    echo "<h2>The articles :";
    echo $article['article_id'];
    echo "</h2>";
    // foreach ($article as $key => $value) {
            ?>
            
            <!-- <li><?php echo "title : {$article['title']}"; ?></span></li> -->
            <div class="card" style="width: 100%;">
            <div class="card-body">
                <h5 class="card-title"><?php echo "{$article['title']}"; ?></h5>
                <h6 class="card-subtitle mb-2 text-muted"><?php echo "{$article['slug']}"; ?></h6>
                <p class="card-text"><?php echo "{$article['content']}"; ?></p>
                <a href="#" class="card-link"><?php echo "{$article['author']}"; ?></a>
                <a href="#" class="card-link"><?php echo "{$article['date']}"; ?></a>
            </div>
            </div>
        
        <?php
    // }
}
echo "</div>";
?>

<div class='links'>
    <a href=<?php echo $links['prev']; ?>>previous</a> 
    <a href=<?php echo $links['next']; ?>>next page</a> 
</div>





