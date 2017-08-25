<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My First Form</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<form action="<?= htmlspecialchars($_SERVER['PHP_SELF']) ?>" method="POST">
    <label for="query-type">Search by:</label>
    <select id="query-type" name="queryType">
        <option value="location">Location</option>
        <option value="person">Person</option>
        <option value="theme">Theme</option>
    </select><br>

    <label for="query">Query String:</label>
    <input id="query" type="text" name="query"><br>
    <input type="submit" value="Search">
</form>
<?php
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    echo '<table>';
    echo '<tr>';
    echo '<th>Date</th>';
    echo '<th>Persons</th>';
    echo '<th>Themes</th>';
    echo '<th>Location</th>';
    echo '<th>Link</th>';
    echo '<th>Counts</th>';
    echo '</tr>';
    $queryType = $_POST['queryType'];
    $query = $_POST['query'];

    $unparsed_json = file_get_contents('http://localhost:8080/hello?queryType=' . $queryType . '&query=' . $query);
    $unparsed_json = utf8_encode($unparsed_json);
    //var_dump($unparsed_json);
    $json = json_decode($unparsed_json, true);
    //var_dump($json);
    //echo implode("HABER AYIR", $json);
    foreach ($json as $new) {
        $new = json_decode($new, true);
        //var_dump($new);
        echo '<tr>';

        echo '<td>' . $new['date']['day'] . '.' . $new['date']['month'] . '.' . $new['date']['year'] . '</td>';

        echo '<td>' . implode("<br>", $new['persons1']) . '</td>';

        echo '<td>' . implode("<br>", $new['themes1']) . '</td>';

        echo '<td>';
        foreach ($new['locations1'] as $location) {
            echo $location['locationFullName'] . '<br>';
        }
        echo '</td>';

        echo '<td><a href="' . $new['documentIdent'] . '">' . $new['documentIdent'] . '</a></td>';

        echo '<td>';
        foreach ($new['counts1'] as $count) {
            echo $count['countType'] . ': ' . $count['count'] . '<br>';
        }
        echo '</td>';

        echo '</tr>';
    }
    echo '</table>';
}
?>

</body>
</html>