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
        include 'controlers/article/c_articles.php';
        get_articles('127.0.0.1:8000/articles');
        break;
    case '/articles'.$id:
        if (isset($_GET['idArticle'])) {
            //  affichage de l'article recherché
            get_articles('127.0.0.1:8000/articles/' . $_GET['idArticle']);
        } else {
            echo "<form method='get' action=''>
                    <input type='number' name='idArticle' min='1' placeholder= 'Search article' required><br>
                  <input type='submit' value='Submit'>
                </fieldset>
              </form> ";
    
            get_articles('127.0.0.1:8000/articles');
        }
}