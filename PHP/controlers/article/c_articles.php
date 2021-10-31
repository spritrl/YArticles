<?php


function get_articles($url)
{

    // Init CURL Session
    $curl = curl_init();

    // Url cible que la requete devra appeler
    curl_setopt($curl, CURLOPT_URL, $url);
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
    // Execution de CURL
    $response = curl_exec($curl);
    // var_dump($response);
    if ($e = curl_error($curl)) {
        echo $e;
    }
    else {
        $decode = json_decode($response, true);
        print_r("success");
        $articles = $decode;
        // print_r("the articles");
        // print_r($response);
       /*  foreach ($articles as $articles) {
            ?>
            <ul>
                <li>$articles</span></li>
            </ul>
        <?php
        } */
    }
    curl_close($curl);
}
?>