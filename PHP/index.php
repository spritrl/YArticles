<?php

/**
 * Index du projet Yartile
 *
 * PHP Version 7
 *
 * @category  DevApi
 * @author    ANOUCH Mouad
 * @author    DUDUC Antoine
 * @author    REALINI Christophe
 * @author    CORMORECHE Leo
 * @copyright 2021 Ynov
 * @version   GIT: <0>
 * @link      https://github.com/spritrl/YArticles
 */

 // On appelle notre fichier de fonction
require 'includes/fct.inc.php';

// Demarre une nouvelle session ou reprend un existante
session_start();

// On recupere le path
$path = $_SERVER['REQUEST_URI'];
$data;

switch($path){
    case '/articles':
        include 'controlers/article/callAPI.php';
        $data = callAPI('GET', '127.0.0.1:8000/articles', false);
        break;
}
$json = json_decode($data, true);
$articles = $json['articles'];
print_r($json);
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