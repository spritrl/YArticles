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