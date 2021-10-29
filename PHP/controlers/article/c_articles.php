<?php


function get_articles($url)
{

    // Init CURL Session
    $curl = curl_init();

    // Url cible que la requete devra appeler
    curl_setopt($curl, CURLOPT_URL, $url);
    // Execution de CURL
    $response = curl_exec($curl);
    var_dump($response);
}
