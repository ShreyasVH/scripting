<?php 

function post($url, $postdata, $additional_headers = [])
{
    $default_headers = [
        "Content-Type: application/json"
    ];
    $headers = array_merge($default_headers, $additional_headers);
    $postdata = json_encode($postdata, JSON_UNESCAPED_SLASHES);
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $url );
    curl_setopt($ch, CURLOPT_POST, 1);
    curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
    curl_setopt($ch, CURLOPT_CONNECTTIMEOUT_MS, 30000);
    curl_setopt($ch, CURLOPT_TIMEOUT_MS, 30000);
    curl_setopt($ch, CURLINFO_HEADER_OUT, true);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $postdata);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

    $result = curl_exec($ch);

    $status = curl_getinfo($ch, CURLINFO_HTTP_CODE);

    curl_close($ch);

    return array(
        'result' => $result,
        'status' => $status
    );
}

function get($url, $additional_headers = [])
{
    $default_headers = [
        
    ];
    $headers = array_merge($default_headers, $additional_headers);
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $url );
    curl_setopt($ch, CURLOPT_CONNECTTIMEOUT_MS, 30000);
    curl_setopt($ch, CURLOPT_TIMEOUT_MS, 30000);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);

    $result = curl_exec($ch);

    $status = curl_getinfo($ch, CURLINFO_HTTP_CODE);

    curl_close($ch);

    return array(
        'result' => $result,
        'status' => $status
    );
}

function delete($url, $additional_headers = [])
{
    $default_headers = [
        "Content-Type: application/json"
    ];
    $headers = array_merge($default_headers, $additional_headers);
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL,$url);
    curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "DELETE");
    curl_setopt($ch, CURLOPT_CONNECTTIMEOUT_MS, 30000);
    curl_setopt($ch, CURLOPT_TIMEOUT_MS, 30000);
    curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

    $result = curl_exec($ch);

    $status = curl_getinfo($ch, CURLINFO_HTTP_CODE);

    curl_close($ch);

    return array(
        'result' => $result,
        'status' => $status
    );
}

function put($url, $putdata, $additional_headers = [])
{
    $default_headers = [
        "Content-Type: application/json"
    ];
    $headers = array_merge($default_headers, $additional_headers);

    $putdata = json_encode($putdata, JSON_UNESCAPED_SLASHES);
    
    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $url );
    curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "PUT");
    curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
    curl_setopt($ch, CURLOPT_CONNECTTIMEOUT_MS, 30000);
    curl_setopt($ch, CURLOPT_TIMEOUT_MS, 30000);
    curl_setopt($ch, CURLINFO_HEADER_OUT, true);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $putdata);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

    $result = curl_exec($ch);

    $status = curl_getinfo($ch, CURLINFO_HTTP_CODE);

    curl_close($ch);

    return array(
        'result' => $result,
        'status' => $status
    );
}

$url = 'http://cors.playframework.com/api?input=abc';
$headers = [
    'c: C',
    'd: D'
];
$response = get($url, $headers);
echo(json_encode(json_decode($response['result']), JSON_PRETTY_PRINT) . "\n");

echo "------------------------------------------------------------\n";

$url = 'http://cors.playframework.com/api?input=abc';
$headers = [
    'c: C',
    'd: D'
];
$payload = [
    'a' => 'A',
    'b' => 'B'
];
$response = post($url, $payload, $headers);
echo(json_encode(json_decode($response['result']), JSON_PRETTY_PRINT) . "\n");

echo "------------------------------------------------------------\n";

$url = 'http://cors.playframework.com/api?input=abc';
$headers = [
    'c: C',
    'd: D'
];
$response = delete($url, $headers);
echo(json_encode(json_decode($response['result']), JSON_PRETTY_PRINT) . "\n");

echo "------------------------------------------------------------\n";

$url = 'http://cors.playframework.com/api?input=abc';
$headers = [
    'c: C',
    'd: D'
];
$payload = [
    'a' => 'A',
    'b' => 'B'
];
$response = put($url, $payload, $headers);
echo(json_encode(json_decode($response['result']), JSON_PRETTY_PRINT) . "\n");