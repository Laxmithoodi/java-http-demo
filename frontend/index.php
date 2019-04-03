<?php
$curl = curl_init();

curl_setopt_array($curl, array(
  CURLOPT_URL => "http://localhost/",
  CURLOPT_RETURNTRANSFER => true,
  CURLOPT_ENCODING => "",
  CURLOPT_MAXREDIRS => 10,
  CURLOPT_TIMEOUT => 30,
  CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  CURLOPT_CUSTOMREQUEST => "GET",
  CURLOPT_HTTPHEADER => array(
    "cache-control: no-cache",
    "postman-token: 62a98256-2b86-66fd-cbc1-fb8434187821"
  ),
));

$response = curl_exec($curl);
$err = curl_error($curl);

curl_close($curl);

if ($err) {
  echo "cURL Error #:" . $err;
} else {
  // echo $response;
}

?>

<!DOCTYPE html>
<html>
<head>
	<title>Jim!</title>
</head>
<body>

<h1>Welcome to my website!</h1>
<div id="info">
	
</div>


<script type="text/javascript">
var data = <?php echo $response ?>;

infoBlock = document.getElementById("info").innerHTML ="<p>My Name is " + data["name"] + "</p>"
+ "<p> My favorite food is " + data["favorite_food"] + "</p>"
+ "<p>here is what I look like </p><img src=\"" + data["profile_pic"] + "\" width=\"400\"/>";



</script>
</body>
</html>
