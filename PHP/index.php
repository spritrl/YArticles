<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./views/articles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="index.css">

    <title>Blog API</title>
</head>
<body>
    
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


switch($path){
    case '/articles':
        include './views/articles.php';
        break;
}

?>

</body>
</html>