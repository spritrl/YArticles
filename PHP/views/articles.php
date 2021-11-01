<?php 
include 'controlers/article/callAPI.php';
$data = callAPI('GET', '127.0.0.1:8000/articles', false);
$json = json_decode($data, true);
$articles = $json['articles'];
$links = $json['_links'];
print_r($links);
foreach ($articles as $article) {
    echo "<h2>The articles :";
    echo $article['article_id'];
    echo "</h2>";
    echo "<ul>";
    foreach ($article as $key => $value) {
            ?>
            
            <li><?php echo "{$key} : {$value}"; ?></span></li>
        
        <?php
    }
    echo "</ul>";
}
?>

<div>
    <a href=<?php echo $links['prev']; ?>>previous</a> 
    <a href=<?php echo $links['next']; ?>>next page</a> 
</div>





